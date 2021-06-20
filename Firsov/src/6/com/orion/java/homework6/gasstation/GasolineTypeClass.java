package com.orion.java.homework6.gasstation;

public enum GasolineTypeClass {
    DT("ДТ"),
    AI_92("АИ-92"),
    AI_95("АИ-95"),
    AI_98("АИ-98");

    private String type;


    GasolineTypeClass( String type ){
        this.type = type;
    }


    public String getType() {
        return type;
    }
}
