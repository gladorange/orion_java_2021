package com.orion.lesson10;

import com.orion.lesson10.XmlSerializer.SecretField;
import com.orion.lesson10.XmlSerializer.XmlFieldName;

public class Person {

    public static int someNumber = 42;

    @XmlFieldName( "Name")
    private final String firstName;

    @XmlFieldName("LastName")
    private String lastName;

    @XmlFieldName("Age")
    private int age;

    @SecretField
    private String password;


    public Person() {
        firstName = "";
    }

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
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


    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    public static class PersonWithMiddleName extends Person {
        String middleName;

        public String getMiddleName() {
            return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }
    }

}

