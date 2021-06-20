package com.lesson12.simpleclasses;

import com.lesson12.framework.DIannotations;

@DIannotations.SimpleComponent
public class Office {
    @DIannotations.AutowireSimpleComponent
    public Manager manager;
    @DIannotations.AutowireSimpleComponent
    public Programmer programmer;
    @DIannotations.AutowireSimpleComponent
    public QAEngineer qaEngineer;

    @DIannotations.AfterDependenciesInjected
    public void work() {
        manager.saySomething();
        programmer.saySomething();
        qaEngineer.saySomething();
    }
}
