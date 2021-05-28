package com.orion.lesson9;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

public class ThreadExecutorExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(50, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                final Thread thread = new Thread(r);
                thread.setName("Thread-counter");
                thread.setDaemon(true);
                return thread;
            }
        });


        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int immutableI = i;

            final Future<Integer> submit = executor.submit(() -> immutableI * immutableI);
            futures.add(submit);
        }

        for (Future<Integer> future : futures) {
            System.out.println(future.get());
        }


        final CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "some string";

        });


        //stringCompletableFuture.thenAccept()

    }
}
