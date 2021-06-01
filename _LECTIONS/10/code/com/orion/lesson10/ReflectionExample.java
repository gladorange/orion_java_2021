package com.orion.lesson10;

import com.orion.lesson10.Person.PersonWithMiddleName;

public class ReflectionExample {


    public static void main(String[] args) {
        PersonWithMiddleName person = new PersonWithMiddleName();

        if (person instanceof Person) {
            System.out.println("is person = true");
        }
    }

}
