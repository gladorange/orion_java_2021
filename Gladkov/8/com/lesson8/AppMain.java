package com.lesson8;

import com.lesson8.task1.Person;
import com.lesson8.task2.Calculator;
import com.lesson8.task3.Lection;
import com.lesson8.task3.Lections;
import com.lesson8.task3.Student;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class AppMain {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>(Arrays.asList(
                new Person("Никита", 34),
                new Person("Валера", 26),
                new Person("Иван", 25),
                new Person("Владимир", 45),
                new Person("Константин", 20),
                new Person("Дмитрий", 54),
                new Person("Игорь", 16)
        ));

        System.out.println("Сортировка по имени");
        Collections.sort( personList, Comparator.comparing(Person::getName) );
        System.out.println(personList);

        System.out.println("Сортировка по возрасту");
        Collections.sort( personList, Comparator.comparing(Person::getAge) );
        System.out.println( personList );

        System.out.println("!!!!!!!!!!!---- РАСШИРЯЕМЫЙ КАЛЬКУЛЯТОР --------------!!!!!!!!!!");
        Calculator calc = new Calculator();
        calc.addOperation("mul", (a, b) -> a * b);
        calc.addOperation("dev", (a, b) -> a / b);
        calc.addOperation("sum", Double::sum);
        calc.addOperation("sub", (a, b) -> a - b);
        calc.addOperation("pow", Math::pow);
        calc.addOperation("ext", (a, b) -> Math.pow(a, 1 / b));
        System.out.println(calc.calculate( "sum", 2d, 3d ));

        System.out.println("!!!!!!!!!!!---- ПОТОКОВЫЕ ЛЕКЦИИ --------------!!!!!!!!!!");
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Никита"),
                new Student("Валера"),
                new Student("Иван"),
                new Student("Владимир"),
                new Student("Константин"),
                new Student("Дмитрий"),
                new Student("Игорь"),
                new Student("Николай"),
                new Student("Андрей"),
                new Student("Роман")
        ));

        System.out.println("************* Кто посещал матанализ *************");
        List<Student> studentsMath = students.stream().filter(
                student -> student.getLectionSet().stream()
                        .anyMatch(
                                lection -> "Матанализ".equals(lection.getName())
                        )
        ).collect(Collectors.toList());
        System.out.println(studentsMath);

        System.out.println("************* Статистика посещений для каждого студента *************");
        students.forEach(s -> System.out.println(s.getName() + " " + s.getLectionSet().size()));

        System.out.println("************* Наибольшее количество посещений *************");

        Map<String, Integer> countVisitLectionMap = new HashMap<>();
        for (Lections lections : Lections.values()) {
            countVisitLectionMap.put(lections.getName(), 0);
        }

        students.stream()
                .flatMap(student -> student.getLectionSet().stream())
                .forEach(lection -> countVisitLectionMap.put(lection.getName(), countVisitLectionMap.get(lection.getName()) + 1));

        int maxValue = Collections.max(countVisitLectionMap.values());
        countVisitLectionMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxValue)
                .forEach(entry -> System.out.println(entry.getKey() + ". Количество посещений: " + entry.getValue()));

        System.out.println("************* Студенты посетившие наибольшие количество лекций в день *************");
        Map<String, Long> resultMapDayLection = new HashMap<>();

        for ( Student student : students ) {
            Map<LocalDate, Long> dateLongMap = student
                    .getLectionSet()
                    .stream()
                    .collect(Collectors.groupingBy( Lection::getDate, Collectors.counting()));

            Long max = Collections.max(dateLongMap.entrySet(), Map.Entry.comparingByValue()).getValue();
            resultMapDayLection.put(student.getName(), max);
        }

        Long maxVal = Collections.max( resultMapDayLection.entrySet(), Map.Entry.comparingByValue() ).getValue();

        resultMapDayLection.entrySet()
                .stream()
                .filter( entry -> entry.getValue().equals( maxVal ))
                .forEach( System.out::println );


        System.out.println("************* Статистика по курсам *************");
        Map<String, Set<String>> resultMapStatisticLection = new HashMap<>();

        for ( Lections lection : Lections.values() ) {
            Set<String> names = new HashSet<>();
            for ( Student student : students ) {
                long count = student.getLectionSet().stream()
                        .filter( l -> l.getName().equals( lection.getName()) )
                        .count();
                if ( count > 0 ) {
                    names.add(student.getName());
                    resultMapStatisticLection.put( lection.getName(), names );
                }
            }
        }

        System.out.println( resultMapStatisticLection );
    }
}