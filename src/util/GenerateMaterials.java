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

        materials.add(new Material(MaterialType.MOTOR_DEPORTIVO));
        materials.add(new Material(MaterialType.MOTOR_LUJO));
        materials.add(new Material(MaterialType.CARROCERIA));
        materials.add(new Material(MaterialType.CARROCERIA_ESPECIAL));
        materials.add(new Material(MaterialType.LLANTAS_DEPORTIVAS));
        materials.add(new Material(MaterialType.LLANTAS_TRABAJO));

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
        // Obtener todos los materiales posibles
        LinkedList<Material> all = getMaterials();
        java.util.ArrayList<Material> disponibles = new java.util.ArrayList<>();

        // Llena la lista de materiales que NO están en la cinta actual
        for (int i = 0; i < all.size(); i++) {
            Material posible = all.getElement(i);
            boolean yaEsta = false;
            for (int j = 0; j < currentBelt.size(); j++) {
                if (currentBelt.getElement(j).getType() == posible.getType()) {
                    yaEsta = true;
                    break;
                }
            }
            if (!yaEsta) {
                disponibles.add(posible);
            }
        }
        if (disponibles.isEmpty()) {
            // Si ya están todos, puedes devolver null o cualquier material aleatorio
            return null;
        }
        // Escoge uno aleatorio entre los disponibles
        int idx = (int) (Math.random() * disponibles.size());
        return disponibles.get(idx);
    }

    public Material consumeMaterial(int index) {
        return randomMaterials.remove(index);
    }

    public void refill() {
        // Se rellena solo cuando hay 3 o menos
        if (randomMaterials.size() <= 3) {
            int materialsToAdd = materialQuantity - randomMaterials.size();
            for (int i = 0; i < materialsToAdd; i++) {
                Material nuevo = getUniqueRandomMaterial(randomMaterials);
                randomMaterials.add(nuevo);
            }
        }
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
