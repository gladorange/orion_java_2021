package com.lesson12.simpleclasses;

import com.lesson12.framework.DIannotations;

@DIannotations.SimpleComponent
public class Manager {
    public void saySomething() {
        System.out.println("Lets go! 5 minutes and we are in production");
    }
}
