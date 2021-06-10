package com.lesson10.task1;
@Annotation.JSONTypeName("Человек")
public class Person {

    @Annotation.JSONname("Имя")
    private String name;

    @Annotation.JSONname("Брак")
    boolean isMarried;

    @Annotation.SecretField
    private int salary;

    public Person() {
    }

    public Person(String name, boolean isMarried) {
        this.name = name;
        this.isMarried = isMarried;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", isMarried=" + isMarried +
                ", salary=" + salary +
                '}';
    }
}
