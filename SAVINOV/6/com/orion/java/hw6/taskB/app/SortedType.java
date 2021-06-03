package com.orion.java.hw6.taskB.app;

public enum SortedType {
    DESC("Descending"),
    ASC("Ascending");

    private String sortedType;

    SortedType(String sortedType) {
        this.sortedType = sortedType;
    }

    public String getSortedType() {
        return sortedType;
    }
}
