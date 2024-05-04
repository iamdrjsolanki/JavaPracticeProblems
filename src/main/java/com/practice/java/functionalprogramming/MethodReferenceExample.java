package com.practice.java.functionalprogramming;

import java.util.function.Function;
import java.util.function.Predicate;

public class MethodReferenceExample {

    public static void main(String[] args) {

        /**
         * Basic implementation
         */
        Predicate<Instructor> p1 = i -> i.isOnlineCourse();
        Predicate<Instructor> p2 = Instructor::isOnlineCourse;

        Function<Integer, Double> f1 = i -> Math.sqrt(i);
        Function<Integer, Double> f2 = Math::sqrt;

        Function<String, String> f3 = x -> x.toLowerCase();
        Function<String, String> f4 = String::toLowerCase;

    }

}
