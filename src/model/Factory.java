package model;

import model.enums.CarType;
import model.structures.LinkedList;
import util.GenerateMaterials;

public class Factory {

    private final int number;
    private final int profitGoal;
    private final int beltCapacity;

    private final GenerateMaterials materialGenerator;
    private final LinkedList<Material> trashCan;
    private final LinkedList<Order> orders;

    public Factory(int number) {
        this.number = number;
        this.profitGoal = getGoalFor(number);
        this.beltCapacity = getBeltCapacity(number);

        this.materialGenerator = new GenerateMaterials(beltCapacity);
        this.trashCan = new LinkedList<>();
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
        CarType[] allowedTypes = getAllowedCarTypes(number);
        for (int i = 0; i < count; i++) {
            int rand = (int) (Math.random() * allowedTypes.length);
            Car car = new Car(allowedTypes[rand]);
            orders.add(new Order(car));
        }
    }

    private CarType[] getAllowedCarTypes(int factoryNumber) {
        return switch (factoryNumber) {
            case 1 ->
                new CarType[]{CarType.SEDAN_LUJO, CarType.PICKUP_ALTA_GAMA};
            case 2 ->
                new CarType[]{CarType.SEDAN_LUJO, CarType.PICKUP_ALTA_GAMA, CarType.MAQUINARIA_PESADA};
            case 3 ->
                CarType.values();
            default ->
                new CarType[0];
        };
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
        trashCan.add(material);
    }

    public int calculatePenalty(Material material) {
        return (int) (material.getValue() * 0.6);
    }

    public LinkedList<Material> getTrashCan() {
        return trashCan;
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
