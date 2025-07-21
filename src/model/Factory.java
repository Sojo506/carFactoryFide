package model;

import model.enums.CarType;
import model.structure.linkedlist.LinkedList;
import util.GenerateMaterials;

public class Factory {

    private int number;
    private int profitGoal;
    private int beltCapacity;

    private GenerateMaterials materialGenerator;
    private LinkedList<Material> trashCan;
    private LinkedList<Order> orders;

    public Factory(int number) {
        this.number = number;
        this.profitGoal = getGoalFor(number);
        this.beltCapacity = getBeltCapacity(number);

        this.materialGenerator = new GenerateMaterials(beltCapacity);
        this.trashCan = new LinkedList<>();
        this.orders = new LinkedList<>();

        generateRandomOrders(15);
    }

    public GenerateMaterials getMaterialGenerator() {
        return materialGenerator;
    }

    private int getGoalFor(int n) {
        return switch (n) {
            case 1 -> 90000;
            case 2 -> 125000;
            case 3 -> 275000;
            default -> 0;
        };
    }

    private int getBeltCapacity(int n) {
        return switch (n) {
            case 1 -> 3;
            case 2 -> 4;
            case 3 -> 5;
            default -> 0;
        };
    }

    public void generateRandomOrders(int count) {
        LinkedList<CarType> allowedTypes = getAllowedCarTypes(number);
        
        for (int i = 0; i < count; i++) {
            int rand = (int) (Math.random() * allowedTypes.size());
            Car car = new Car(allowedTypes.getElement(rand));
            orders.add(new Order(car));
        }
    }

    private LinkedList<CarType> getAllowedCarTypes(int factoryNumber) {
        LinkedList<CarType> list = new LinkedList<>();
        
        switch (factoryNumber) {
            case 1 -> {
                list.add(CarType.SEDAN_LUJO);
                list.add(CarType.PICKUP_ALTA_GAMA);
            }
            case 2 -> {
                list.add(CarType.SEDAN_LUJO);
                list.add(CarType.PICKUP_ALTA_GAMA);
                list.add(CarType.MAQUINARIA_PESADA);
            }
            case 3 -> {
                // CarType.values() devuelve un array, así que lo convertimos a LinkedList
                for (CarType ct : CarType.values()) {
                    list.add(ct);
                }
            }
        }
        return list;
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
        return (int) (material.getValue() * 0.3);
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
