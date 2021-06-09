package com.orion.java.homework10.classes;

import com.orion.java.homework10.xmltools.XmlTools.XmlName;
import com.orion.java.homework10.xmltools.XmlTools.XmlIgnore;
import com.orion.java.homework10.xmltools.XmlTools.XmlTypeName;

/**
 * Пример класса, предназначенного для серриализации/десерриализации.
 */
@XmlTypeName("Человек")
public class Person {
    @XmlName("Имя")
    private  String firstName;
    @XmlName("Фамилия")
    private  String lastName;
    @XmlName("Возраст")
    private int age;
    @XmlName("СемейноеПоложение")
    private boolean isMarried;
    @XmlIgnore
    private int password;

    public Person() {
    }

    public Person(String firstName, String lastName, int age, boolean isMarried) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.isMarried = isMarried;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", isMarried=" + isMarried +
                ", password=" + password +
                '}';
    }
}
