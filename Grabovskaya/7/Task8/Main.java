package Task8;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        Box<Integer> firstBox = new Box<>(2);
        Box<Long> secondBox = new Box<>(2L);
        NumberBox<Integer> third = new NumberBox<>(2);

        System.out.println("Результат 1: " + third.add(secondBox).multiply(firstBox).getElement());

        Box<Double> fourthBox = new Box<>(3D);
        Box<Long> fifthBox = new Box<>(5L);
        NumberBox<Integer> sixth = new NumberBox<>(3);

        System.out.println("Результат 2: " + sixth.add(fifthBox).multiply(fourthBox).getElement());

        List<Box<? extends CharSequence>> boxes = new ArrayList<>();
        boxes.add(new Box<String>("Куз"));
        boxes.add(new StringBoxUtils<String>("не"));
        boxes.add(new StringBoxUtils<StringBuilder>(new StringBuilder("чик")));

        System.out.println("Результат склеивания: " + StringBoxUtils.join(boxes).getElement());

        System.out.println("Добавление не пустых строк в лист:");
        List<CharSequence> emptyList = new ArrayList<>();
        StringBoxUtils.copyNonEmptyStringBoxToList(new Box<String>("    "), emptyList);
        System.out.println(emptyList);
        StringBoxUtils.copyNonEmptyStringBoxToList(new Box<String>("сорок два"), emptyList);
        System.out.println(emptyList);
        StringBoxUtils.copyNonEmptyStringBoxToList(new Box<StringBuilder>(new StringBuilder("some value ")), emptyList);
        System.out.println(emptyList);
    }
}
