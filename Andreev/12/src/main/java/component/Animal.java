package component;

import annotation.Annotation;

import java.time.Period;

@Annotation.SimpleComponent
public class Animal {

    public void saySomething(){
        System.out.println("Я животное!");
    }
}
