package model.enums;

public enum CarType {
    SEDAN_LUJO(5000, "Sedán de lujo", new MaterialType[]{
        MaterialType.MOTOR_LUJO,
        MaterialType.CARROCERIA
    }),
    PICKUP_ALTA_GAMA(12000, "Pickup alta gama", new MaterialType[]{
        MaterialType.MOTOR_LUJO,
        MaterialType.CARROCERIA
    }),
    MAQUINARIA_PESADA(17500, "Maquinaria pesada", new MaterialType[]{
        MaterialType.MOTOR_DEPORTIVO,
        MaterialType.CARROCERIA_ESPECIAL,
        MaterialType.LLANTAS_TRABAJO
    }),
    SUPERAUTO_DEPORTIVO(20000, "Super auto deportivo", new MaterialType[]{
        MaterialType.MOTOR_DEPORTIVO,
        MaterialType.CARROCERIA,
        MaterialType.LLANTAS_DEPORTIVAS
    });

    private final int profit;
    private final String carName;
    private final MaterialType[] required;

    CarType(int profit, String carName, MaterialType[] required) {
        this.profit = profit;
        this.carName = carName;
        this.required = required;
    }

    public int getProfit() {
        return profit;
    }

    public String getCarName() {
        return carName;
    }

    public MaterialType[] getRequiredMaterials() {
        return required;
    }
}
