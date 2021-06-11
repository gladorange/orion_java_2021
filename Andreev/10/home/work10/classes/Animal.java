package homework10.classes;


import homework10.annotation.XmlName;
import homework10.annotation.XmlTypeName;

@XmlTypeName("Животное")
public class Animal {

    @XmlName("Кличка")
    String name = "Barsik";

    @XmlName("Возраст")
    int age = 15;

    @XmlName("Порода")
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
