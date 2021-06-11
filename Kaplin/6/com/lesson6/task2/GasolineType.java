package com.lesson6.task2;

public enum GasolineType {
    DT("Дизель"), AI92("92 бензин"), AI95("95 бензин"), AI98("98 бензин");


    private final String gasName;

    GasolineType(String gasName) {
        this.gasName = gasName;
    }

    @Override
    public String toString() {
        return gasName;
    }
}
