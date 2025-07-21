package util;

import model.Material;
import model.enums.MaterialType;
import model.structure.linkedlist.LinkedList;

public class GenerateMaterials {

    private LinkedList<Material> materials;
    private LinkedList<Material> randomMaterials;
    private int materialQuantity;

    public GenerateMaterials(int materialQuantity) {
        materials = new LinkedList<>();
        randomMaterials = new LinkedList<>();
        this.materialQuantity = materialQuantity;

        switch (materialQuantity) {
            case 3:
                materials.add(new Material(MaterialType.MOTOR_LUJO));
                materials.add(new Material(MaterialType.CARROCERIA));
                materials.add(new Material(MaterialType.LLANTAS_DEPORTIVAS));
                materials.add(new Material(MaterialType.MOTOR_DEPORTIVO));
                break;
            default:
                materials.add(new Material(MaterialType.MOTOR_DEPORTIVO));
                materials.add(new Material(MaterialType.MOTOR_LUJO));
                materials.add(new Material(MaterialType.CARROCERIA));
                materials.add(new Material(MaterialType.LLANTAS_DEPORTIVAS));
                materials.add(new Material(MaterialType.CARROCERIA_ESPECIAL));
                materials.add(new Material(MaterialType.LLANTAS_TRABAJO));
        }

        generateRandomMaterials();
    }

    private void generateRandomMaterials() {
        randomMaterials.clear();
        for (int i = 0; i < materialQuantity; i++) {
            Material m = getUniqueRandomMaterial(randomMaterials);
            randomMaterials.add(m);
        }
    }

    public Material getUniqueRandomMaterial(LinkedList<Material> currentBelt) {
        LinkedList<Material> all = getMaterials();
        LinkedList<Material> availables = new LinkedList<>();

        // Buscar materiales que NO estén en la cinta actual
        for (int i = 0; i < all.size(); i++) {
            Material posible = all.getElement(i);
            boolean exists = false;
            for (int j = 0; j < currentBelt.size(); j++) {
                if (currentBelt.getElement(j).getType() == posible.getType()) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                availables.add(posible);
            }
        }

        // si no registra alguno por alguna razón: elige uno random de todos
        if (availables.isEmpty()) {
            int idx = (int) (Math.random() * all.size());
            return all.getElement(idx);
        }

        // Si hay materiales únicos, elige uno de los disponibles
        int idx = (int) (Math.random() * availables.size());
        return availables.getElement(idx);
    }

    public Material consumeMaterial(int index) {
        return randomMaterials.remove(index);
    }

    public LinkedList<Material> getMaterials() {
        return materials;
    }

    public LinkedList<Material> getRandomMaterials() {
        return randomMaterials;
    }

    public int getMateriaslQuantity() {
        return materialQuantity;
    }

}
