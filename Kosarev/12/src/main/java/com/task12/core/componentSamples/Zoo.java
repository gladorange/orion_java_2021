package com.task12.core.componentSamples;

import com.task12.core.annotation.AfterDependenciesInjected;
import com.task12.core.annotation.AutowireSimpleComponent;
import com.task12.core.annotation.SimpleComponent;


@SimpleComponent
public class Zoo {

    @AutowireSimpleComponent
    private Cat cat;
    @AutowireSimpleComponent
    private Dog dog;

    @AfterDependenciesInjected
    private void makeNoise() {
        cat.meow();
        dog.woof();
    }

    @AfterDependenciesInjected
    private void congratulate() {
        System.out.println("Все получилось!!!");
    }

    private void doNotCallMe() {
        System.out.println("Зачем меня вызвали?!");
    }

}
