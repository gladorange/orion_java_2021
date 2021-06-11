package component;

import annotation.Annotation;

@Annotation.SimpleComponent
public class Transport {

    public void saySomething(){
        System.out.println("Я машина!");
    }
}
