package homework10.classes;

import homework10.annotation.XmlName;
import homework10.annotation.XmlTypeName;

@XmlTypeName("Транспорт")
public class Transport {

    @XmlName("Модель")
    String model = "Порш Каен";

    @XmlName("Максимальная скорость")
    int maxSpeed = 260;

    @XmlName("Спортивная")
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

    @Override
    public String toString() {
        return "Transport{" +
                "model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", isSports=" + isSports +
                '}';
    }
}
