package component;

import annotation.AfterDependenciesInjected;
import annotation.AutowireSimpleComponent;
import annotation.SimpleComponent;

@SimpleComponent
public class Common {

    @AutowireSimpleComponent
    Person person;

    @AutowireSimpleComponent
    Animal animal;

    @AutowireSimpleComponent
    Transport transport;

    @AfterDependenciesInjected
    private void makeNoise() {
        person.saySomething();
        animal.saySomething();
        transport.saySomething();
    }
}
