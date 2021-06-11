package component;

import annotation.SimpleComponent;

@SimpleComponent
public class Animal {

    public void saySomething(){
        System.out.println("Я животное!");
    }
}
