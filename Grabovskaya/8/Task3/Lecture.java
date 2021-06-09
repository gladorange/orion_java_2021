package Task3;

import java.time.LocalDate;
import java.util.Objects;

public class Lecture
{
    String name;
    LocalDate dateOfEvent;

    public Lecture(String name, LocalDate dateOfEvent)
    {
        this.name = name;
        this.dateOfEvent = dateOfEvent;
    }

    public String getName()
    {
        return name;
    }

    public LocalDate getDateOfEvent()
    {
        return dateOfEvent;
    }

    @Override
    public String toString() {
        return "Lecture { " +
                "Название='" + name + '\'' +
                ", дата проведения=" + dateOfEvent +
                " }\n";
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lecture lecture = (Lecture) o;
        return Objects.equals(name, lecture.name) && Objects.equals(dateOfEvent, lecture.dateOfEvent);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, dateOfEvent);
    }
}
