package model;

public class Order {

    private final Car car;
    private boolean completed;

    public Order(Car car) {
        this.car = car;
        this.completed = false;
    }

    public Car getCar() {
        return car;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Order: " + car.toString();
    }
}
