package homework10.classes;


import homework10.annotation.SecretField;
import homework10.annotation.XmlName;
import homework10.annotation.XmlTypeName;

@XmlTypeName("Человек")
public class Person {

    @XmlName("Имя")
    String firstName;

    @XmlName("Возраст")
    double age;

    @SecretField
    String password;

    public Person() {
    }

    public Person(String firstName, double age, String password) {
        this.firstName = firstName;
        this.age = age;
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAge(double age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}


