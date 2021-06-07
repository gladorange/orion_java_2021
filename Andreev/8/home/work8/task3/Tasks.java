package home.work8.task3;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Tasks {

    public void run() {

        List<String> list = getLections();

        List<Student> students = createStudents(list);

        taskOne(students);
        taskTwo(students);
        taskThree(students);
        taskFour(students);
        taskFive(students, list);
    }

    private List<String> getLections() {

        List<String> list = Stream.of("Матанализ", "Философия", "Английский язык", "Физкультура", "История").collect(toList());

        return list;
    }

    private List<Student> createStudents(List<String> Lectionlist) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Max", Lectionlist));
        students.add(new Student("Eva", Lectionlist));
        students.add(new Student("Jhon", Lectionlist));
        students.add(new Student("Ben", Lectionlist));
        students.add(new Student("Marry", Lectionlist));
        students.add(new Student("Henry", Lectionlist));
        students.add(new Student("Bill", Lectionlist));
        students.add(new Student("Jake", Lectionlist));
        students.add(new Student("Anna", Lectionlist));
        students.add(new Student("Jane", Lectionlist));
        return students;
    }

    private void taskOne(List<Student> students) {
        System.out.println("1. Выведите список студентов, которые хоть раз посещали матанализ.");
        List<Student> list = students.stream()
                .filter(el -> el.getLections()
                        .stream()
                        .anyMatch(l -> l.getName().equals("Матанализ")))
                .collect(toList());

        System.out.println(list);
    }

    private void taskTwo(List<Student> students) {
        System.out.println("2. Выведите статистику посещений для каждого студентам в формате: имя - количество посщенных лекций.");
        System.out.println("2. Выведите статистику посещений для каждого студентам в формате: имя - количество посщенных лекций.");
        students.forEach(el ->{
            System.out.println(el.getName() + " = " + el.getLections().size());
        });
    }

    private void taskThree(List<Student> students) {
        System.out.println("3. Выведите название дисциплин, имеющих наибольшее количество посещений.");
        List<Lection> lectionList = new ArrayList<>();

        for (Student student : students) {
            lectionList.addAll(student.getLections());
        }

        Map<String, Long> result = lectionList
                .stream()
                .collect(Collectors.groupingBy(Lection::getName, Collectors.counting()));

        Long max = Collections.max(result.entrySet(), Map.Entry.comparingByValue()).getValue();

        result
                .entrySet()
                .stream()
                .filter(el -> el.getValue().equals(max))
                .forEach(System.out::println);
    }

    private void taskFour(List<Student> students) {
        System.out.println("4. Выведите имена студентов, которые посетили наибольшее количество лекций в день.");
        Map<String, Long> result = new HashMap<>();

        for (Student student : students) {
            Map<LocalDate, Long> dateLongMap = student
                    .getLections()
                    .stream()
                    .collect(Collectors.groupingBy(Lection::getDate, Collectors.counting()));

            Long max = Collections.max(dateLongMap.entrySet(), Map.Entry.comparingByValue()).getValue();

            result.put(student.getName(), max);
        }

        Long maxValue = Collections.max(result.entrySet(), Map.Entry.comparingByValue()).getValue();

        result
                .entrySet()
                .stream()
                .filter(el -> el.getValue().equals(maxValue))
                .forEach(System.out::println);

    }

    private void taskFive(List<Student> students, List<String> lectionsList) {
        System.out.println("5. Выведите статистику по курсам.");
        Map<String, Set<String>> result = new HashMap<>();

        for (String el : lectionsList) {
            Set<String> names = new HashSet<>();
            for (Student student : students) {
                long count = student.getLections().stream().filter(l -> l.getName().equals(el)).count();
                if (count > 0) {
                    names.add(student.getName());
                    result.put(el, names);
                }
            }
        }

        System.out.println(result);

    }
}
