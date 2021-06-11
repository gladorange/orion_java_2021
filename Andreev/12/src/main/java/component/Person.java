package component;

import annotation.Annotation;

@Annotation.SimpleComponent
public class Person {

    public void saySomething(){
        System.out.println("Я человек!");
    }
}
