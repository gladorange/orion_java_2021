package com.orion.java.homework10.classes;

import com.orion.java.homework10.xmltools.XmlTools.XmlName;
import com.orion.java.homework10.xmltools.XmlTools.XmlIgnore;

/**
 * Пример класса, предназначенного для серриализации/десерриализации.
 * Для примера не задана аннотация для имени класса.
 */
public class Animal {
    @XmlName("Имя")
    private String name;
    @XmlIgnore
    private String favoriteDish;
    @XmlName("Возраст")
    private int age;
    @XmlName("Кастрация")
    boolean isCastrated;
    public Animal() {
    }

    public Animal(String name, String favoriteDish, int age, boolean isCastrated) {
        this.name = name;
        this.favoriteDish = favoriteDish;
        this.age = age;
        this.isCastrated = isCastrated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteDish() {
        return favoriteDish;
    }

    public void setFavoriteDish(String favoriteDish) {
        this.favoriteDish = favoriteDish;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isCastrated() {
        return isCastrated;
    }

    public void setCastrated(boolean castrated) {
        isCastrated = castrated;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", favoriteDish='" + favoriteDish + '\'' +
                ", age=" + age +
                ", isCastrated=" + isCastrated +
                '}';
    }
}
