package home.work10.classes;

import homework10.annotation.Annotation;

@Annotation.XmlTypeName("Человек")
public class Person {

    @Annotation.XmlName("Имя")
    String firstName="Vasya";

    @Annotation.XmlName("Возраст")
    double age=12;

    @Annotation.SecretField
    String password;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAge(double age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}


