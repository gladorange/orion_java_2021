package com.orion.java.homework12.testClass;

import com.orion.java.homework12.annotations.AutowireSimpleComponent;
import framework.SimpleDIFramework;

public class Main {
    @AutowireSimpleComponent
    private Person person;

    public static void main(String[] args) {
        new SimpleDIFramework("com.orion.java.homework12.testClass");
    }
}

