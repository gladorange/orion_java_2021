package com.lesson12.simpleclasses;

import com.lesson12.framework.DIannotations;

@DIannotations.SimpleComponent
public class QAEngineer {
    public void saySomething() {
        System.out.println("We are not ready for production, testing was failed");
    }
}
