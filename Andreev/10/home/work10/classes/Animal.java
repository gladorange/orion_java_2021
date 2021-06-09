package home.work10.classes;

import homework10.annotation.Annotation;

@Annotation.XmlTypeName("Животное")
public class Animal {

    @Annotation.XmlName("Кличка")
    String name = "Barsik";

    @Annotation.XmlName("Возраст")
    int age = 15;

    @Annotation.XmlName("Порода")
    String breed = "Сиамская";

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
