package Task;

@XmlSerializer.XmlTypeName("Человек")
public class Person
{
    @XmlSerializer.XmlName("Имя")
    private String name;

    @XmlSerializer.XmlName("Возраст")
    private double age;

    @XmlSerializer.XmlIgnore
    private String password;

    public Person() {}

    public Person(String name, double age, String password)
    {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person { " +
                "name = '" + name + '\'' +
                ", age = " + age +
                ", password = '" + password + '\'' +
                " }";
    }
}
