package model.enums;

public enum MaterialType {
    MOTOR_LUJO(500),
    MOTOR_DEPORTIVO(2000),
    CARROCERIA(500),
    CARROCERIA_ESPECIAL(800),
    LLANTAS_TRABAJO(2000),
    LLANTAS_DEPORTIVAS(800);

    private final int value;

    MaterialType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
