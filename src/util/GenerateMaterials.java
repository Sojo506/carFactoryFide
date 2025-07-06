package util;

import model.Material;
import model.enums.MaterialType;
import model.structures.LinkedList;

public class GenerateMaterials {

    private LinkedList<Material> materials;
    private LinkedList<Material> randomMaterials;
    private int materialQuantity;

    public GenerateMaterials(int materiaslQuantity) {
        materials = new LinkedList<>();
        randomMaterials = new LinkedList<>();
        this.materialQuantity = materiaslQuantity;

        materials.add(new Material(MaterialType.MOTOR_DEPORTIVO));
        materials.add(new Material(MaterialType.MOTOR_LUJO));
        materials.add(new Material(MaterialType.CARROCERIA));
        materials.add(new Material(MaterialType.CARROCERIA_ESPECIAL));
        materials.add(new Material(MaterialType.LLANTAS_DEPORTIVAS));
        materials.add(new Material(MaterialType.LLANTAS_TRABAJO));

        generateRandomMaterials();
    }

    private void generateRandomMaterials() {
        for (int i = 0; i < materialQuantity; i++) {
            randomMaterials.add(materials.getRandomElement());
        }
    }

    public Material consumeMaterial(int index) {
        return randomMaterials.remove(index);
    }

    public void refill() {
        if (randomMaterials.size() <= 3) {
            int materialsToAdd = materialQuantity - randomMaterials.size();
            for (int i = 0; i < materialsToAdd; i++) {
                randomMaterials.add(materials.getRandomElement());
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
