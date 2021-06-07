package home.work8.task3;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Student {

    private String name;
    private Set<Lection> lections;

    public Student(String name, List<String> lectionNames) {
        this.name = name;
        lections = new HashSet<>();
        setRandomLections(lectionNames);
    }

    public String getName() {
        return name;
    }

    public Set<Lection> getLections() {
        return lections;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    private void setRandomLections(List<String> lectionNames) {
        int count = (int) (Math.random() * ((10 - 3) + 1)) + 3;
        for (int i = count; i > 0; i--) {
            int randomPosition = new Random().nextInt(lectionNames.size());
            int day = (int) (Math.random() * ((5 - 1) + 1)) + 1;
            lections.add(new Lection(lectionNames.get(randomPosition), LocalDate.of(2021, 4, day)));
        }
    }
}
