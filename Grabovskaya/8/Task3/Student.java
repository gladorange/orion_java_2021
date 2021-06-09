package Task3;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Student
{
    String name;
    Set<Lecture> attendedLectures;

    public Student(String name, Set<Lecture> classesAttended)
    {
        this.name = name;
        this.attendedLectures = classesAttended;
    }

    public String getName() {
        return name;
    }

    public Set<Lecture> getAttendedLectures()
    {
        return attendedLectures;
    }

    @Override
    public String toString() {
        return "Student { " +
                "Имя='" + name + '\'' +
                ", Посещенные занятия=" + attendedLectures +
                " }\n";
    }

    public static List<String> getStudentsWhoAttendedLectureOnce(List<Student> students, String lectureName)
    {
        return students.stream()
                .filter(student -> student.getAttendedLectures().stream()
                .anyMatch(lecture -> lecture.getName().equals(lectureName)))
                .map(Student::getName)
                .collect(Collectors.toList());
    }

    public static List<String> getAttendanceLectures(List<Student> students)
    {
        return students.stream()
                .map(student -> student.getName() + ": " + student.getAttendedLectures().size())
                .collect(Collectors.toList());
    }

    public static Set<Map.Entry<String, Long>> getLecturesAttendedMoreThanTenTimes(List<Student> students)
    {
        return getLecturesAndTheirAttendance(students).stream()
                .filter(stringLongEntry -> stringLongEntry.getValue() > 10)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public static List<String> getStudentsWhoMoreThanOneAttendingLecturePerDay(List<Student> students)
    {
        List<Map.Entry<LocalDate, Long>> dateAttendance = students.stream()
                .map(student -> student.getAttendedLectures().stream()
                        .collect(Collectors.groupingBy(Lecture::getDateOfEvent, Collectors.counting()))
                        .entrySet().stream()
                        .max(Map.Entry.comparingByValue())
                        .get())
                .collect(Collectors.toList());

        return IntStream.range(0, students.size())
                .filter(i -> dateAttendance.get(i).getValue() > 1L)
                .mapToObj(i -> students.get(i).getName() + " посетил " + dateAttendance.get(i).getValue() + " лекции " + dateAttendance.get(i).getKey())
                .collect(Collectors.toList());
    }

    public static Set<Map.Entry<String, Long>> getLecturesAndTheirAttendance(List<Student> students)
    {
        Map<String, Long> lecturesAttendance = students.stream()
                .map(Student::getAttendedLectures)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(Lecture::getName, Collectors.counting()));

        return lecturesAttendance.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public static void main(String[] args)
    {
        List<Student> students = new ArrayList<>();

        String[] studentsNames = new String[] { "Игорь", "Лина", "Маша", "Андрей", "Рома", "Люба", "Саша", "Алексей", "Настя", "Катя" };
        List<Lecture> lectures = new ArrayList<>();
        lectures.add(new Lecture("Мат.анализ", LocalDate.of(2021, 2, 1)));
        lectures.add(new Lecture("Мат.анализ", LocalDate.of(2021, 2, 15)));
        lectures.add(new Lecture("Мат.анализ", LocalDate.of(2021, 3, 1)));
        lectures.add(new Lecture("Мат.анализ", LocalDate.of(2021, 3, 15)));
        lectures.add(new Lecture("Мат.анализ", LocalDate.of(2021, 3, 29)));

        lectures.add(new Lecture("Философия", LocalDate.of(2021, 1, 27)));
        lectures.add(new Lecture("Философия", LocalDate.of(2021, 2, 10)));
        lectures.add(new Lecture("Философия", LocalDate.of(2021, 3, 3)));
        lectures.add(new Lecture("Философия", LocalDate.of(2021, 3, 15)));
        lectures.add(new Lecture("Философия", LocalDate.of(2021, 3, 24)));

        lectures.add(new Lecture("Англ.язык", LocalDate.of(2021, 1, 27)));
        lectures.add(new Lecture("Англ.язык", LocalDate.of(2021, 2, 3)));
        lectures.add(new Lecture("Англ.язык", LocalDate.of(2021, 2, 17)));
        lectures.add(new Lecture("Англ.язык", LocalDate.of(2021, 3, 15)));
        lectures.add(new Lecture("Англ.язык", LocalDate.of(2021, 4, 7)));

        lectures.add(new Lecture("История", LocalDate.of(2021, 2, 1)));
        lectures.add(new Lecture("История", LocalDate.of(2021, 2, 15)));
        lectures.add(new Lecture("История", LocalDate.of(2021, 3, 3)));
        lectures.add(new Lecture("История", LocalDate.of(2021, 3, 15)));
        lectures.add(new Lecture("История", LocalDate.of(2021, 3, 29)));

        lectures.add(new Lecture("Физкультура", LocalDate.of(2021, 1, 27)));
        lectures.add(new Lecture("Физкультура", LocalDate.of(2021, 2, 10)));
        lectures.add(new Lecture("Физкультура", LocalDate.of(2021, 3, 3)));
        lectures.add(new Lecture("Физкультура", LocalDate.of(2021, 3, 15)));
        lectures.add(new Lecture("Физкультура", LocalDate.of(2021, 3, 24)));
        lectures.add(new Lecture("Физкультура", LocalDate.of(2021, 4, 7)));

        int studentsCount = 10;
        Random random = new Random();
        for (int i = 0; i < studentsCount; i++)
        {
            Set<Lecture> classesAttended = new HashSet<>();
            for (int j = 0; j < random.nextInt(lectures.size()) + 1; j++)
            {
                classesAttended.add(lectures.get(random.nextInt(lectures.size())));
            }
            students.add(new Student(studentsNames[i], classesAttended));
        }
        System.out.println(students);

        System.out.println("\n1. Студенты, которые хоть раз посещали мат.анализ:");
        System.out.println(getStudentsWhoAttendedLectureOnce(students, "Мат.анализ"));

        System.out.println("\n2. Статистика посещений (имя студента: количество посещенных за всё время занятий):");
        System.out.println(getAttendanceLectures(students));

        System.out.println("\n3. Дисциплины, которые студенты посетили более 10 раз:");
        System.out.println(getLecturesAttendedMoreThanTenTimes(students));

        System.out.println("\n4. Студенты, которые посетили более одной лекции в какой-то день:");
        System.out.println(getStudentsWhoMoreThanOneAttendingLecturePerDay(students));

        System.out.println("\n5. Названия дисциплин и количество их посещений студентами:");
        System.out.println(getLecturesAndTheirAttendance(students));
    }
}
