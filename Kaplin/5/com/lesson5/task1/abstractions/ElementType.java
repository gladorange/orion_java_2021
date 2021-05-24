package com.lesson5.task1.abstractions;

public enum ElementType {
    BUTTON("Кнопка"), CHECK_BOX("Чекбокс"), TEXT_FIELD("Текстовое поле");

    final String typeName;

    ElementType(String typeName) {
        this.typeName = typeName;
    }


    @Override
    public String toString() {
        return typeName;
    }
}
