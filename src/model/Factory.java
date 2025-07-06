package model;

import model.enums.CarType;
import model.structures.LinkedList;
import util.GenerateMaterials;

public class Factory {

    private final int number;
    private final int profitGoal;
    private final int beltCapacity;

    private final GenerateMaterials materialGenerator;
    private final LinkedList<Material> trashBin;
    private final LinkedList<Order> orders;

    public Factory(int number) {
        this.number = number;
        this.profitGoal = getGoalFor(number);
        this.beltCapacity = getBeltCapacity(number);

        this.materialGenerator = new GenerateMaterials(beltCapacity);
        this.trashBin = new LinkedList<>();
        this.orders = new LinkedList<>();

        generateRandomOrders(15);
    }

    private int getGoalFor(int n) {
        return switch (n) {
            case 1 ->
                90000;
            case 2 ->
                125000;
            case 3 ->
                275000;
            default ->
                0;
        };
    }

    private int getBeltCapacity(int n) {
        return switch (n) {
            case 1 ->
                3;
            case 2 ->
                4;
            case 3 ->
                5;
            default ->
                0;
        };
    }

    public void generateRandomOrders(int count) {
        for (int i = 0; i < count; i++) {
            Car car = new Car(CarType.values()[(int) (Math.random() * CarType.values().length)]);
            orders.add(new Order(car));
        }
    }

    public void refillBelt() {
        materialGenerator.refill();
    }

    public Material consumeMaterial(int index) {
        return materialGenerator.consumeMaterial(index);
    }

    public LinkedList<Material> getConveyorBelt() {
        return materialGenerator.getRandomMaterials();
    }

    public void discardMaterial(Material material) {
        trashBin.add(material);
    }

    public int calculatePenalty(Material material) {
        return (int) (material.getValue() * 0.6);
    }

    public LinkedList<Material> getTrashBin() {
        return trashBin;
    }

    public LinkedList<Order> getOrders() {
        return orders;
    }

    public int getProfitGoal() {
        return profitGoal;
    }

    public int getBeltCapacity() {
        return beltCapacity;
    }

    public int getNumber() {
        return number;
    }
}
