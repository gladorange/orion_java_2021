package com.orion.java.homework12.components;

import com.orion.java.homework12.annotations.AfterDependenciesInjected;
import com.orion.java.homework12.annotations.AutowireSimpleComponent;
import com.orion.java.homework12.annotations.SimpleComponent;
import framework.SimpleDIFramework;

@SimpleComponent
public class Zoo {
    @AutowireSimpleComponent
    private Cat cat;

    @AutowireSimpleComponent
    private Dog dog;

    @AfterDependenciesInjected
    private void makeNoise() {
        cat.meow();
        dog.gav();
    }
    public static void main(String[] args) {
         new SimpleDIFramework("com.orion.java.homework12.components");
      //  new SimpleDIFramework("com.orion.java.homework12.testClass");
    }

}
