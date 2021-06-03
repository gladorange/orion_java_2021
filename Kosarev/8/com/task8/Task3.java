package com.task8;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Task3 {
    public static void run() {
        List<Student> students = List.of(Student.of("Алекс"),
                                         Student.of("Вера"),
                                         Student.of("Рома"),
                                         Student.of("Наташа"),
                                         Student.of("Соня"),
                                         Student.of("Алиса"),
                                         Student.of("Паша"),
                                         Student.of("Саша"));
        Set<Lecture> schedule = createSchedule(4);
        visitCourses(students, schedule);
        System.out.println("Посещаемость:");
        printVisits(students);
        System.out.println();

        System.out.println("Хоть раз посещали матанализ:");
        System.out.println(onceBeenOnDiscipline(students, "Матанализ"));
        System.out.println();

        System.out.println("Посещаемость по студентам:");
        System.out.println(courseVisitsStats(students));
        System.out.println();

        System.out.println("Самые посещаемые дисциплины:");
        System.out.println(mostVisitedDisciplines(students));
        System.out.println();

        System.out.println("Студенты, посетившие наибольшее количество лекций за день:");
        System.out.println(visitedMostLecturesAtDay(students));
        System.out.println();

        System.out.println("Посещаемость по дисциплинам");
        System.out.println(disciplinesStats(students));
        System.out.println();
    }

    public static Map<String, Integer> disciplinesStats(List<Student> students) {
        Map<String, Integer> stat = new HashMap<>();
        Lecture.getAvailableDisciplines().forEach(d -> stat.put(d, onceBeenOnDiscipline(students, d).size()));
        return stat;
    }

    public static List<Student> visitedMostLecturesAtDay(List<Student> students) {
        Map<Student, Long> studentsMaxVisitsMap = new HashMap<>();
        students.forEach(s -> {
            Map<LocalDate, Long> dailyVisitsStat = s.getVisitedLectures().stream()
                                                                         .collect(Collectors.groupingBy(Lecture::getDate, Collectors.counting()));
            Long maxDailyVisitsOfStudent = dailyVisitsStat.entrySet().stream()
                                                                     .max(Map.Entry.comparingByValue())
                                                                     .get().getValue();
            studentsMaxVisitsMap.put(s, maxDailyVisitsOfStudent);
        });
        Long maxDailyVisits = studentsMaxVisitsMap.entrySet().stream()
                                                             .max(Map.Entry.comparingByValue())
                                                             .get().getValue();
        return studentsMaxVisitsMap.entrySet().stream()
                                              .filter(studentLongEntry -> studentLongEntry.getValue().equals(maxDailyVisits))
                                              .map(Map.Entry::getKey)
                                              .collect(Collectors.toList());
    }

    public static List<String> mostVisitedDisciplines(List<Student> students) {
        // подсмотрел https://habr.com/ru/post/348536/ , потому что до этого тут был жуткий спагетти-код
        List<Lecture> lecturesVisited = new ArrayList<>();
        students.forEach(s -> lecturesVisited.addAll(s.getVisitedLectures()));
        Map<String, Long> visitingStat = lecturesVisited.stream()
                                                        .collect(Collectors.groupingBy(Lecture::getDiscipline, counting()));
        Long maxVisits = visitingStat.entrySet().stream()
                                                .max(Map.Entry.comparingByValue())
                                                .get().getValue();
        return visitingStat.entrySet().stream()
                                      .filter(stringLongEntry -> stringLongEntry.getValue().equals(maxVisits))
                                      .map(Map.Entry::getKey)
                                      .collect(Collectors.toList());
    }

    public static Map<Student, Integer> courseVisitsStats(List<Student> students) {
        Map<Student, Integer> stat = new HashMap<>();
        students.forEach(s -> stat.put(s, s.getVisitedLectures().size()));
        return stat;
    }

    public static List<Student> onceBeenOnDiscipline(List<Student> students, String disciplineName) {
        return students.stream()
                       .filter(s -> s.getVisitedLectures().stream()
                                                          .anyMatch(l -> l.getDiscipline().equals(disciplineName)))
                       .collect(toList());
    }

    public static void printVisits(List<Student> students) {
        students.stream().map(s -> s.getName() + ": " + s.getVisitedLectures()).forEach(System.out::println);
    }

    public static void visitCourses(List<Student> students, Set<Lecture> lectures) {
        Random r = new Random();
        students.forEach(student -> lectures.forEach(lecture -> {
            if (r.nextBoolean())
                student.visitLecture(lecture);
//            student.visitLecture(lecture);
        }));
    }

    public static Set<Lecture> createSchedule(int lecturesAmount) {
        Set<Lecture> schedule = new HashSet<>();
        Lecture.getAvailableDisciplines().forEach(d -> {
            for (int i = 0; i < lecturesAmount; i++)
                schedule.add(Lecture.withRandomDate(d));
        });
        return schedule;
    }

    public static class Lecture {
        private String discipline;
        private LocalDate date;
        private static final Set<String> AVAILABLE_DISCIPLINES = Set.of("Матанализ",
                                                                        "Философия",
                                                                        "Английский язык",
                                                                        "История",
                                                                        "Физкультура");

        public Lecture(String discipline, LocalDate date) {
            this.discipline = discipline;
            this.date = date;
        }

        public static Lecture of(String discipline, LocalDate date) {
            return new Lecture(discipline, date);
        }

        public String getDiscipline() {
            return discipline;
        }

        public LocalDate getDate() {
            return date;
        }

        public static Lecture withRandomDate(String discipline) {
            long randomEpochDay = ThreadLocalRandom.current().nextLong(
                    LocalDate.of(2021, Month.JANUARY, 1).toEpochDay(),
                    LocalDate.of(2021, Month.FEBRUARY, 1).toEpochDay());

            LocalDate randomDay = LocalDate.ofEpochDay(randomEpochDay);
            return Lecture.of(discipline, randomDay);
        }

        @Override
        public String toString() {
            return discipline + ":" + DateTimeFormatter.ofPattern("dd.MM.yyyy").format(date);
        }

        public static Set<String> getAvailableDisciplines() {
            return AVAILABLE_DISCIPLINES;
        }
    }

    public static class Student {
        private String name;
        private Set<Lecture> visitedLectures = new HashSet<>();

        public Student(String name) {
            this.name = name;
        }

        public static Student of(String name) {
            return new Student(name);
        }

        public void visitLecture(Lecture lecture) {
            visitedLectures.add(lecture);
        }

        public String getName() {
            return name;
        }

        public Set<Lecture> getVisitedLectures() {
            return visitedLectures;
        }

        public void printVisitedLectures() {
            visitedLectures.stream()
                           .sorted(Comparator.comparing(Lecture::getDiscipline))
                           .forEach(l -> System.out.println(l.getDiscipline() + ": " + l.getDate()));
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
