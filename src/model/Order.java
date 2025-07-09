package model;

import model.enums.OrderStatus;

public class Order {

    private final Car car;
    private OrderStatus status;
    private boolean completed;

    public Order(Car car) {
        this.car = car;
        this.status = OrderStatus.NOT_ACCEPTED;
        this.completed = false;
    }

    public Car getCar() {
        return car;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Order: " + car.toString();
    }
}
