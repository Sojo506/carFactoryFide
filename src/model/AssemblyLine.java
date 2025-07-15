package model;

import model.enums.OrderStatus;

public class AssemblyLine {

    private Order order;
    private boolean occupied;
    private int originSlot = -1;

    public AssemblyLine() {
        occupied = false;
    }

    public void assignOrder(Order o, int slot) {
        this.order = o;
        this.originSlot = slot;
        this.occupied = true;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean addMaterial(Material m) {
        if (order != null && order.getCar().canAcceptMaterial(m)) {
            order.getCar().addMaterial(m);
            // Marcar como completa si el auto se termina aquí mismo
            if (order.getCar().isComplete()) {
                order.setCompleted(true);
                order.setStatus(OrderStatus.COMPLETED);
            }
            return true;
        }
        return false;
    }

    public boolean isOrderComplete() {
        return order != null && order.isCompleted();
    }

    public void setOccupied(boolean val) {
        occupied = val;
    }

    public Order getOrder() {
        return order;
    }

    public int getOriginSlot() {
        return originSlot;
    }

    public void reset() {
        order = null;
        originSlot = -1;
        occupied = false;
    }

}
