package controller;

import model.*;
import model.structures.LinkedList;

public class GameController {

    private Player player;
    private Factory factory;
    private LinkedList<Order> allOrders;
    private LinkedList<Order> visibleOrders;
    private LinkedList<AssemblyLine> assemblyLines;
    private int maxAssemblyLines = 3;
    private int maxVisibleOrders = 5;

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
        // Busca la primera línea de ensamblaje libre
        for (int i = 0; i < assemblyLines.size(); i++) {
            AssemblyLine line = assemblyLines.getElement(i);
            if (!line.isOccupied()) {
                Order order = visibleOrders.getElement(visibleOrderIndex);
                if (order != null) {
                    line.assignOrder(order);
                    order.setStatus(model.enums.OrderStatus.IN_PROGRESS);
                    // El slot de visibleOrders sigue mostrando la orden pero con status "En progreso"
                    return true;
                }
            }
        }
        return false; // No hay línea libre
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
