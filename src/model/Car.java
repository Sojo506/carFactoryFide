package model;

import model.enums.CarType;
import model.enums.MaterialType;
import model.structures.LinkedList;
import model.structures.Node;

public class Car {

    private final CarType type;
    private final LinkedList<Material> materialsAdded;

    public Car(CarType type) {
        this.type = type;
        this.materialsAdded = new LinkedList<>();
    }

    public CarType getType() {
        return type;
    }

    public int getProfit() {
        return type.getProfit();
    }

    public MaterialType[] getRequiredMaterials() {
        return type.getRequiredMaterials();
    }

    public void addMaterial(Material material) {
        materialsAdded.add(material);
    }

    public LinkedList<Material> getMaterialsAdded() {
        return materialsAdded;
    }

    public boolean canAcceptMaterial(Material material) {
        MaterialType materialType = material.getType();

        // Verifica si el material está dentro de los requeridos
        boolean isRequired = false;
        for (MaterialType requiredType : type.getRequiredMaterials()) {
            if (requiredType == materialType) {
                isRequired = true;
                break;
            }
        }

        if (!isRequired) {
            return false; // No se requiere este tipo
        }

        // Verifica si ya fue agregado
        Node<Material> current = materialsAdded.getHead();
        while (current != null) {
            if (current.getData().getType() == materialType) {
                return false; // Ya agregado
            }
            current = current.getNext();
        }

        return true; 
    }

    public boolean isComplete() {
        MaterialType[] required = type.getRequiredMaterials();
        boolean[] used = new boolean[required.length];

        Node<Material> current = materialsAdded.getHead();
        while (current != null) {
            MaterialType materialType = current.getData().getType();
            boolean matched = false;

            for (int i = 0; i < required.length; i++) {
                if (!used[i] && required[i] == materialType) {
                    used[i] = true;
                    matched = true;
                    break;
                }
            }

            if (!matched) {
                return false;
            }

            current = current.getNext();
        }

        for (boolean b : used) {
            if (!b) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        return type.name() + " - $" + getProfit();
    }
}
