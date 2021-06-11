package component;

import annotation.SimpleComponent;

@SimpleComponent
public class Person {

    public void saySomething(){
        System.out.println("Я человек!");
    }
}
