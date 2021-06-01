package com.orion.lesson10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentModification {



    public static void main(String[] args) throws ExecutionException, InterruptedException {


        List<Integer> integers = Collections.synchronizedList(new ArrayList<>());
        final ExecutorService executorService = Executors.newFixedThreadPool(4);


        List<Future<?>> futures = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            final Future<?> future = executorService.submit(() -> {
                for (int i1 = 0; i1 < 10000; i1++) {
                    integers.add(i1);


                    int currentSum = 0;

                    for (Integer integer : integers) {
                        currentSum += integer;
                    }


                }
            });

            futures.add(future);
        }


        for (Future<?> future : futures) {
            future.get();
        }

        System.out.println(integers.size());

        executorService.shutdownNow();


    }
}
