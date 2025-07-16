package controller;

import model.*;
import model.enums.OrderStatus;
import model.structures.LinkedList;

public class GameController {

    private Player player;
    private Factory factory;
    private LinkedList<Order> allOrders;
    private LinkedList<Order> visibleOrders;
    private LinkedList<AssemblyLine> assemblyLines;
    private int maxAssemblyLines = 3;
    private int maxVisibleOrders = 5;
    private int selectedMaterial = -1;

    public GameController(Player player) {
        this.player = player;
        this.factory = player.getFactory();
        this.allOrders = factory.getOrders();
        this.visibleOrders = new LinkedList<>();
        this.assemblyLines = new LinkedList<>();

        for (int i = 0; i < maxAssemblyLines; i++) {
            assemblyLines.add(new AssemblyLine());
        }

        fillVisibleOrders();
    }

    // Llenar los 5 slots del HubPanel con órdenes aleatorias (o null si ya no hay)
    private void fillVisibleOrders() {
        visibleOrders.clear();
        for (int i = 0; i < maxVisibleOrders; i++) {
            visibleOrders.add(getNextOrderOrNull());
        }
    }

    // Obtener la siguiente orden disponible del pool, o null si ya no hay
    private Order getNextOrderOrNull() {
        if (!allOrders.isEmpty()) {
            int randIdx = (int) (Math.random() * allOrders.size());
            return allOrders.remove(randIdx);
        } else {
            return null;
        }
    }

    // Aceptar orden desde el HubPanel (índice 0 a 4)
    public boolean acceptOrder(int visibleOrderIndex) {
        for (int i = 0; i < assemblyLines.size(); i++) {
            AssemblyLine line = assemblyLines.getElement(i);
            if (!line.isOccupied()) {
                Order order = visibleOrders.getElement(visibleOrderIndex);
                if (order != null) {
                    line.assignOrder(order, visibleOrderIndex); // Guarda el índice de origen
                    order.setStatus(OrderStatus.IN_PROGRESS);
                    return true;
                }
            }
        }
        return false;
    }

    // Rechazar orden desde el HubPanel (índice 0 a 4)
    public void rejectOrder(int visibleOrderIndex) {
        // Quita la orden actual y la reemplaza por otra (o null)
        visibleOrders.setElement(visibleOrderIndex, getNextOrderOrNull());
    }

    // Completar una orden en ensamblaje (cuando se termina el auto)
    public void completeOrderInLine(int lineIndex, int visibleOrderIndex) {
        // Libera la línea
        AssemblyLine line = assemblyLines.getElement(lineIndex);
        if (line.getOrder() != null) {
            line.getOrder().setStatus(model.enums.OrderStatus.COMPLETED);
            line.getOrder().setCompleted(true);
        }
        line.reset();
        // Refresca el slot de visibleOrders (agrega nueva orden si quedan, o null si no)
        visibleOrders.setElement(visibleOrderIndex, getNextOrderOrNull());

        // Falta sumar capital
    }

    // Cancelar (rechazar) una orden ya en ensamblaje
    public void cancelAssemblyOrder(int lineIndex, int visibleOrderIndex) {
        // Libera la línea
        assemblyLines.getElement(lineIndex).reset();
        // El slot correspondiente en el HubPanel se refresca
        visibleOrders.setElement(visibleOrderIndex, getNextOrderOrNull());
        // Si no hay más órdenes, slot queda null
    }

    // Obtener la cinta actual de materiales (según fábrica)
    public LinkedList<Material> getConveyorBelt() {
        return factory.getConveyorBelt();
    }

    // Eliminar (consumir) un material de la cinta, lo usas al agregar a ensamblaje o desechar
    public Material consumeMaterial(int index) {
        return factory.consumeMaterial(index);
    }

    // Agregar material a línea de ensamblaje
    public boolean addMaterialToLine(Material material, int lineIndex) {
        AssemblyLine line = assemblyLines.getElement(lineIndex);
        if (line != null && line.isOccupied()) {
            if (line.getOrder().getCar().canAcceptMaterial(material)) {
                line.addMaterial(material);
                // Elimina el material de la cinta
                removeMaterialFromBelt(material);
                // Si el auto está completo, marca la orden y paga
                if (line.getOrder().getCar().isComplete()) {
                    line.getOrder().setCompleted(true);
                    line.getOrder().setStatus(model.enums.OrderStatus.COMPLETED);
                    player.addMoney(line.getOrder().getCar().getProfit());
                }
                return true;
            }
        }
        return false;
    }

    // Elimina material de la cinta por objeto (para control desde panel)
    public void removeMaterialFromBelt(Material material) {
        LinkedList<Material> belt = getConveyorBelt();
        for (int i = 0; i < belt.size(); i++) {
            if (belt.getElement(i) == material) {
                belt.remove(i);
                break;
            }
        }
        factory.refillBelt();
    }

    public void discardMaterial(int index) {
        LinkedList<Material> belt = getConveyorBelt();
        Material mat = belt.getElement(index);

        if (mat != null) {
            factory.discardMaterial(mat); // penaliza y procesa eliminación
            player.subtractMoney(factory.calculatePenalty(mat)); // penaliza capital

            // Elimina el material del slot
            belt.remove(index);

            // Ahora busca un material único
            Material nuevo = factory.getMaterialGenerator().getUniqueRandomMaterial(belt);

            // Inserta en la misma posición
            belt.add(index, nuevo);
        }
    }

    // Métodos para refrescar información en los paneles (getters para HUD, etc.)
    public int getPlayerMoney() {
        return player.getMoney();
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

    // Acceder al estado actual
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

    // Refresca todo para una nueva fábrica (cuando el jugador asciende)
    public void startNewFactory() {
        player.advanceFactory();
        this.factory = player.getFactory();
        this.allOrders = factory.getOrders();
        fillVisibleOrders();

        for (int i = 0; i < assemblyLines.size(); i++) {
            assemblyLines.getElement(i).reset();
        }
    }
}
