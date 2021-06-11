package component;

import annotation.Annotation;

@Annotation.SimpleComponent
public class Common {

    @Annotation.AutowireSimpleComponent
    Person person;

    @Annotation.AutowireSimpleComponent
    Animal animal;

    @Annotation.AutowireSimpleComponent
    Transport transport;

    @Annotation.AfterDependenciesInjected
    private void makeNoise() {
        person.saySomething();
        animal.saySomething();
        transport.saySomething();
    }
}
