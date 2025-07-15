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
