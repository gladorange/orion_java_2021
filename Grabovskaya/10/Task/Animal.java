package Task;

@XmlSerializer.XmlTypeName("Животное")
public class Animal
{
    @XmlSerializer.XmlName("Название")
    private String name;

    @XmlSerializer.XmlIgnore
    private int numberTeeth;

    @XmlSerializer.XmlName("Ареал обитания")
    private String habitat;

    public Animal() {}

    public Animal(String name, String habitat, int numberTeeth)
    {
        this.name = name;
        this.habitat = habitat;
        this.numberTeeth = numberTeeth;
    }

    @Override
    public String toString() {
        return "Animal { " +
                "name = '" + name + '\'' +
                ", numberTeeth = " + numberTeeth +
                ", habitat = '" + habitat + '\'' +
                " }";
    }
}
