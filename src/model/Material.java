package model;

import model.enums.MaterialType;

public class Material {

    private final MaterialType type;

    public Material(MaterialType type) {
        this.type = type;
    }

    public MaterialType getType() {
        return type;
    }

    public int getValue() {
        return type.getValue();
    }

    @Override
    public String toString() {
        return type.name();
    }
}
