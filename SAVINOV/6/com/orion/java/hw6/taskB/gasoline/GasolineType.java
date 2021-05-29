package com.orion.java.hw6.taskB.gasoline;

public enum GasolineType {
    DT("ДТ"),
    AI_92("АИ-92"),
    AI_95("АИ-95"),
    AI_98("АИ-98");

    private String gasoline;

    GasolineType(String gasoline){
        this.gasoline = gasoline;
    }

    public String getGasoline() {
        return gasoline;
    }
}
