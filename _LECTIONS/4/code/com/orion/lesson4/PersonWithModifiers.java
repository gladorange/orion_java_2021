package com.orion.lesson4;

public class PersonWithModifiers {

    private String name;
    private String surname;
    char[] password;


    public PersonWithModifiers(String name, String surname) {
        this.name = name;
        this.surname = surname;

        password = getPassword(surname);
    }

    private char[] getPassword(String surname) {
        return surname.replace("а", "O").toCharArray();
    }

    public String getName() {
        return name;
    }


    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return new String(password);
    }

}
