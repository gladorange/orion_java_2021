package com.orion.lesson8;

import java.util.List;
import java.util.stream.Stream;

public class StreamApi {


    public static void main(String[] args) {
        List<String> strs = List.of("1", "2", "3", "4");

        int sum = 0;
        for (String str : strs) {
            final int i = Integer.parseInt(str);

            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println("Сумма из цикла "+ sum);


        final int streamSum = strs.stream()
                .mapToInt(Integer::valueOf)
                .filter(integer -> integer % 2 == 0)
                .sum();


        System.out.println("Сумма из stream "+ streamSum);

    }
}
