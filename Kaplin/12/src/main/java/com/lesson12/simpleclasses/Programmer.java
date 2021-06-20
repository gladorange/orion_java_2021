package com.lesson12.simpleclasses;

import com.lesson12.framework.DIannotations;

@DIannotations.SimpleComponent
public class Programmer {
    public void saySomething() {
        System.out.println("This code is terrible, i need more time for refactor this");
    }
}
