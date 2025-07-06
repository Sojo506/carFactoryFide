package model;

import model.enums.CarType;
import model.enums.MaterialType;
import model.structures.Node;

public class Main {

    public static void main(String[] args) {

        System.out.println("===== Prueba de clases CAR, MATERIAL y ORDER =====\n");

        for (CarType carType : CarType.values()) {
            Car car = new Car(carType);
            System.out.println("Car: " + carType.name());
            System.out.println("Ganancias: $" + car.getProfit());
            System.out.println("Materiales requeridos:");
            for (MaterialType mat : car.getRequiredMaterials()) {
                System.out.println(" - " + mat.name() + " ($" + mat.getValue() + ")");
            }
            System.out.println();
        }

        System.out.println("===== Linea de ensamblaje: SEDAN =====");
        Car sedan = new Car(CarType.SEDAN_LUJO);
        sedan.addMaterial(new Material(MaterialType.CARROCERIA));
        sedan.addMaterial(new Material(MaterialType.MOTOR_LUJO));

        System.out.println("Car: " + sedan.getType());
        System.out.println("Materiales agregados:");
        Node<Material> node = sedan.getMaterialsAdded().getHead();
        while (node != null) {
            System.out.println(" - " + node.getData().getType());
            node = node.getNext();
        }
        System.out.println("Esta completo? " + sedan.isComplete());

        System.out.println("\n===== Linea de ensamblaje: SUPER AUTO =====");
        Car faultyCar = new Car(CarType.SUPERAUTO_DEPORTIVO);
        faultyCar.addMaterial(new Material(MaterialType.MOTOR_DEPORTIVO));
        faultyCar.addMaterial(new Material(MaterialType.CARROCERIA_ESPECIAL));
        faultyCar.addMaterial(new Material(MaterialType.LLANTAS_DEPORTIVAS));

        System.out.println("Car: " + faultyCar.getType());
        System.out.println("Materiales agregados:");
        node = faultyCar.getMaterialsAdded().getHead();
        while (node != null) {
            System.out.println(" - " + node.getData().getType());
            node = node.getNext();
        }
        System.out.println("Esta completo? " + faultyCar.isComplete());

        // 4. Probar Order
        System.out.println("\n===== Prueba de la clase Order =====");
        Order order = new Order(sedan);
        System.out.println("Pedido para: " + order.getCar().getType());
        System.out.println("Completo? " + order.isCompleted());
        order.setCompleted(sedan.isComplete());
        System.out.println("Completo ahora? " + order.isCompleted());

        System.out.println("\n===== Fin de pueba =====");
    }
}
