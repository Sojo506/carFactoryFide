package model.enums;

public enum MaterialType {
    MOTOR_LUJO(500, "Motor de lujo"),
    MOTOR_DEPORTIVO(2000, "Motor deportivo"),
    CARROCERIA(500, "Carrocería"),
    CARROCERIA_ESPECIAL(800, "Carrocería especial"),
    LLANTAS_TRABAJO(2000, "Llantas de trabajo"),
    LLANTAS_DEPORTIVAS(800, "Llantas deportivas");

    private final int value;
    private final String materialName;

    MaterialType(int value, String materialName) {
        this.value = value;
        this.materialName = materialName;
    }

    public int getValue() {
        return value;
    }

    public String getMaterialName() {
        return materialName;
    }
}
