package home.work10.classes;

import homework10.annotation.Annotation;

@Annotation.XmlTypeName("Транспорт")
public class Transport {

    @Annotation.XmlName("Модель")
    String model = "Порш Каен";

    @Annotation.XmlName("Максимальная скорость")
    int maxSpeed = 260;

    @Annotation.XmlName("Спортивная")
    boolean isSports = true;

    public void setModel(String model) {
        this.model = model;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setSports(boolean sports) {
        isSports = sports;
    }
}
