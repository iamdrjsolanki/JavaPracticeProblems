package com.practice.java.java8lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class SumOfNumbersUsingCallable {

    public static int[] array = IntStream.rangeClosed(0, 5000).toArray();

    public static int total = IntStream.rangeClosed(0, 5000).sum();

    public static void main(String[] args) throws InterruptedException, java.util.concurrent.ExecutionException {

        java.util.concurrent.Callable<Integer> callable1 = () -> {
            int sum = 0;
            for(int i=0; i< array.length/2; i++) {
                sum += array[i];
            }
            return sum;
        };

        java.util.concurrent.Callable<Integer> callable2 = () -> {
            int sum = 0;
            for(int i= array.length/2; i< array.length; i++) {
                sum += array[i];
            }
            return sum;
        };

        java.util.concurrent.ExecutorService executorService = java.util.concurrent.Executors.newFixedThreadPool(2);
        List<java.util.concurrent.Callable<Integer>> callables = Arrays.asList(callable1, callable2);
        List<java.util.concurrent.Future<Integer>> futures = executorService.invokeAll(callables);

        int totalSum = 0;
        for(java.util.concurrent.Future<Integer> future : futures) {
            totalSum += future.get();
        }
        System.out.println("Exector Sum: " + totalSum);
        System.out.println("Original Sum: " + total);

        executorService.shutdown();

    }

}
