package model.enums;

public enum CarType {
    SEDAN_LUJO(5000, new MaterialType[]{
        MaterialType.MOTOR_LUJO,
        MaterialType.CARROCERIA
    }),
    PICKUP_ALTA_GAMA(12000, new MaterialType[]{
        MaterialType.MOTOR_LUJO,
        MaterialType.CARROCERIA
    }),
    MAQUINARIA_PESADA(17500, new MaterialType[]{
        MaterialType.MOTOR_DEPORTIVO,
        MaterialType.CARROCERIA_ESPECIAL,
        MaterialType.LLANTAS_TRABAJO
    }),
    SUPERAUTO_DEPORTIVO(20000, new MaterialType[]{
        MaterialType.MOTOR_DEPORTIVO,
        MaterialType.CARROCERIA,
        MaterialType.LLANTAS_DEPORTIVAS
    });

    private final int profit;
    private final MaterialType[] required;

    CarType(int profit, MaterialType[] required) {
        this.profit = profit;
        this.required = required;
    }

    public int getProfit() {
        return profit;
    }

    public MaterialType[] getRequiredMaterials() {
        return required;
    }
}
