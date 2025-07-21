package controller;

import model.*;
import model.enums.OrderStatus;
import model.structure.linkedlist.LinkedList;

/**
 * GameController Clase central del juego. Coordina la lógica principal de la
 * fábrica, maneja el estado de las órdenes, las líneas de ensamblaje y la cinta
 * de materiales, y realiza todas las operaciones críticas del juego.
 */
public class GameController {
    
    private Player player;
    private Factory factory;                // Fábrica actual del jugador
    private LinkedList<Order> allOrders;    // Todas las órdenes de la fábrica actual
    private LinkedList<Order> visibleOrders;// Órdenes visibles en el HubPanel (máx 5)
    private LinkedList<AssemblyLine> assemblyLines; // 3 líneas de ensamblaje
    private int maxAssemblyLines = 3;
    private int maxVisibleOrders = 5;
    private int selectedMaterial = -1;      // Índice del material seleccionado en la cinta

    /**
     * Constructor principal. Recibe el jugador, obtiene la fábrica actual y
     * crea líneas de ensamblaje vacías. Llena las órdenes visibles iniciales.
     */
    public GameController(Player player) {
        this.player = player;
        this.factory = player.getFactory();
        this.allOrders = factory.getOrders();         // Todas las órdenes de la fábrica
        this.visibleOrders = new LinkedList<>();      // Las órdenes que ve el usuario en el hub
        this.assemblyLines = new LinkedList<>();      // 3 líneas de ensamblaje

        for (int i = 0; i < maxAssemblyLines; i++) {
            assemblyLines.add(new AssemblyLine());
        }
        
        fillVisibleOrders(); // Carga las primeras 5 órdenes en pantalla
    }

    /**
     * Llena los slots de órdenes visibles con órdenes aleatorias (o null si ya
     * no quedan más).
     */
    private void fillVisibleOrders() {
        visibleOrders.clear();
        for (int i = 0; i < maxVisibleOrders; i++) {
            visibleOrders.add(getNextOrderOrNull());
        }
    }

    /**
     * Obtiene una orden aleatoria de las órdenes restantes en la fábrica. Si ya
     * no hay órdenes, retorna null.
     */
    private Order getNextOrderOrNull() {
        if (!allOrders.isEmpty()) {
            int randIdx = (int) (Math.random() * allOrders.size());
            return allOrders.remove(randIdx);
        } else {
            return null;
        }
    }

    /**
     * Permite aceptar una orden del hub, colocándola en la primera línea de
     * ensamblaje disponible. Devuelve true si fue posible, false si todas las
     * líneas están ocupadas.
     */
    public boolean acceptOrder(int visibleOrderIndex) {
        for (int i = 0; i < assemblyLines.size(); i++) {
            AssemblyLine line = assemblyLines.getElement(i);
            if (!line.isOccupied()) {
                Order order = visibleOrders.getElement(visibleOrderIndex);
                if (order != null) {
                    line.assignOrder(order, visibleOrderIndex); // Asigna la orden y guarda su slot de origen
                    order.setStatus(OrderStatus.IN_PROGRESS);
                    return true;
                }
            }
        }
        return false; // No hay líneas disponibles
    }

    /**
     * Rechaza una orden del hub. Quita la orden actual y la reemplaza por una
     * nueva si quedan disponibles (o null).
     */
    public void rejectOrder(int visibleOrderIndex) {
        visibleOrders.setElement(visibleOrderIndex, getNextOrderOrNull());
    }

    /**
     * Marca como completada la orden en la línea de ensamblaje indicada, libera
     * la línea, y coloca una nueva orden (o null) en el slot visible. NOTA: La
     * suma de capital se realiza al completar el auto (ver addMaterialToLine).
     */
    public void completeOrderInLine(int lineIndex, int visibleOrderIndex) {
        AssemblyLine line = assemblyLines.getElement(lineIndex);
        if (line.getOrder() != null) {
            line.getOrder().setStatus(OrderStatus.COMPLETED);
            line.getOrder().setCompleted(true);
        }
        line.reset(); // Libera la línea de ensamblaje
        visibleOrders.setElement(visibleOrderIndex, getNextOrderOrNull());
    }

    /**
     * Cancela una orden en proceso (por ejemplo, si el usuario la rechaza en
     * ensamblaje). Libera la línea y muestra una nueva orden en el hub.
     */
    public void cancelAssemblyOrder(int lineIndex, int visibleOrderIndex) {
        assemblyLines.getElement(lineIndex).reset();
        visibleOrders.setElement(visibleOrderIndex, getNextOrderOrNull());
    }

    /**
     * Devuelve la cinta transportadora actual de materiales. Este método es
     * usado por los paneles para mostrar la cinta.
     */
    public LinkedList<Material> getConveyorBelt() {
        return factory.getConveyorBelt();
    }

    /**
     * Quita un material de la cinta (por índice). Se usa al agregar a
     * ensamblaje o desechar.
     */
    public Material consumeMaterial(int index) {
        return factory.consumeMaterial(index);
    }

    /**
     * Intenta agregar un material a una línea de ensamblaje. Si el material es
     * válido para ese auto, lo agrega, lo elimina de la cinta y si completa el
     * auto, suma el profit al jugador y marca la orden como completa.
     */
    public boolean addMaterialToLine(Material material, int lineIndex) {
        AssemblyLine line = assemblyLines.getElement(lineIndex);
        if (line != null && line.isOccupied()) {
            if (line.getOrder().getCar().canAcceptMaterial(material)) {
                line.addMaterial(material);
                removeMaterialFromBelt(material); // Elimina el material usado de la cinta

                // Si el auto está completo, marca la orden y suma profit
                if (line.getOrder().getCar().isComplete()) {
                    line.getOrder().setCompleted(true);
                    line.getOrder().setStatus(OrderStatus.COMPLETED);
                    player.addCapital(line.getOrder().getCar().getProfit());
                }
                return true;
            }
        }
        return false; // Material no válido para ese auto/orden
    }

    /**
     * Elimina un material específico de la cinta, buscándolo por referencia.
     * Esto asegura que la cinta nunca tenga duplicados después de actualizar.
     */
    public void removeMaterialFromBelt(Material material) {
        LinkedList<Material> belt = getConveyorBelt();
        for (int i = 0; i < belt.size(); i++) {
            if (belt.getElement(i) == material) {
                belt.remove(i);
                break;
            }
        }
    }

    /**
     * Descarta un material (botón basurero): penaliza al jugador, elimina el
     * material, y coloca uno nuevo en esa posición (que no se repita en la
     * cinta actual).
     */
    public void discardMaterial(int index) {
        LinkedList<Material> belt = getConveyorBelt();
        Material mat = belt.getElement(index);
        
        if (mat != null) {
            factory.discardMaterial(mat); // Aplica penalización y lógica de eliminación
            player.subtractCapital(factory.calculatePenalty(mat)); // Descuenta el capital

            // Elimina el material del slot y trae uno nuevo que no esté repetido
            belt.remove(index);
            Material nuevo = factory.getMaterialGenerator().getUniqueRandomMaterial(belt);
            belt.add(index, nuevo);
        }
    }

    // MÉTODOS PARA OBTENER INFORMACIÓN PARA EL HUB O LOS PANELES
    public int getPlayerMoney() {
        return player.getCapital();
    }
    
    public int getPlayerGoal() {
        return factory.getProfitGoal();
    }
    
    public int getFactoryNumber() {
        return factory.getNumber();
    }
    
    public String getPlayerPosition() {
        return player.getPosition();
    }

    // ACCESOS AL ESTADO ACTUAL DEL JUEGO
    public LinkedList<AssemblyLine> getAssemblyLines() {
        return assemblyLines;
    }
    
    public LinkedList<Order> getVisibleOrders() {
        return visibleOrders;
    }
    
    public Player getPlayer() {
        return player;
    }
    
    public Factory getFactory() {
        return factory;
    }
    
    public int getSelectedMaterial() {
        return selectedMaterial;
    }
    
    public void setSelectedMaterial(int selectedMaterial) {
        this.selectedMaterial = selectedMaterial;
    }

    /**
     * Prepara todo para una nueva fábrica (cuando el usuario sube de
     * nivel/fábrica). Cambia la fábrica, reinicia las órdenes y limpia las
     * líneas de ensamblaje.
     */
    public void startNewFactory() {
        player.advanceFactory();
        player.setCapital(0);
        
        this.factory = player.getFactory();
        this.allOrders = factory.getOrders();
        
        fillVisibleOrders();
        
        for (int i = 0; i < assemblyLines.size(); i++) {
            assemblyLines.getElement(i).reset();
        }
    }
}
