package com.lesson6.task2;

public enum GasolineType {
    DT("ДТ"),
    AI_92("АИ-92"),
    AI_95("АИ-95"),
    AI_98("АИ-98");

    private String type;


    GasolineType( String type ){
        this.type = type;
    }


    public String getType() {
        return type;
    }
}
