package com.practice.java.java8streams;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ParallelStreams {

    public static void main(String[] args) {

        /**
         * Parallel Stream
         */
        System.out.println(sumSequentialStream());
        System.out.println(sumParallelStream());

        System.out.println("Time taken by Sequential processing: " +
                measurePerformance(ParallelStreams::sumSequentialStream, 200));
        System.out.println("Time taken by Parallel processing: " +
                measurePerformance(ParallelStreams::sumParallelStream, 200));

    }

    public static long measurePerformance(Supplier<Integer> supplier, int n) {
        long startTime = System.currentTimeMillis();
        for(int i=0; i<n; i++) {
            supplier.get();
        }
        return System.currentTimeMillis() - startTime;
    }

    public static int sumSequentialStream() {
        return IntStream.range(0, 500000).sum();
    }

    public static int sumParallelStream() {
        return IntStream.range(0, 500000).parallel().sum();
    }

}
