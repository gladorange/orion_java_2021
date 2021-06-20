package com.orion.java.hw10;

@MyAnnotation.XmlTypeName("Telephone")
public class Telephone {
    @MyAnnotation.XmlName("Type")
    String type;
    @MyAnnotation.XmlName("Number")
    String number;

    public Telephone() {
    }

    public Telephone(String type, String number) {
        this.type = type;
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Telephone{" +
                "type='" + type + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
