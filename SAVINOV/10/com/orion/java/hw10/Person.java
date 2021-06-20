package com.orion.java.hw10;

@MyAnnotation.XmlTypeName("Person")
public class Person {
    @MyAnnotation.XmlName("Name")
    private String firstName;
    @MyAnnotation.XmlName("LastName")
    private String lastName;
    @MyAnnotation.XmlName("Sex")
    private String sex;

    public Person() {
    }

    public Person(String firstName, String lastName, String sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
