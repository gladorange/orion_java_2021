package com.orion.lesson12;


import org.springframework.stereotype.Component;

@Component
public class NotASpringBean {




    public void printSomething() {
        System.out.println("Not a spring bean");
    }
}
