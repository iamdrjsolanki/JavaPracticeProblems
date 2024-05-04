package com.practice.java.functionalprogramming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionExample {

    public static void main(String[] args) {

        /**
         * Basic Implementation
         * takes 2 arg type
         * 1 for input & 1 for output
         * Function<Integer, Boolean>
         */

        Function<Integer, Double> f1 = Math::sqrt;
        System.out.println("Sqrt of 10: " + f1.apply(10));

        System.out.println("------Uppercase String to lowercase--------");
        Function<String, String> f2 = String::toLowerCase;
        System.out.println("HOW ARE YOU convert to lowercase: " + f2.apply("HOW ARE YOU"));

        System.out.println("------concate with previous function implementation--------");
        Function<String, String> f3 = (x) -> x.concat(" In Java");
        System.out.println(f2.andThen(f3).apply("PROGRAMMING"));

        System.out.println("----apply lower case to whole string");
        System.out.println(f2.compose(f3).apply("PROGRAMMING"));

        /**
         * More Implementation with Collection
         */
        List<Instructor> instructors = Instructors.getAll();

        System.out.println("------Fucntion with List<Instructor> as input and return Map<String, Integer> as name & exp who has online courses");
        Predicate<Instructor> p1 = Instructor::isOnlineCourse;
        Function<List<Instructor>, Map<String, Integer>> f4 =
                (list -> {
                    Map<String, Integer> map = new HashMap<>();
                    list.forEach(i -> {
                        if(p1.test(i)) {
                            map.put(i.getName(), i.getExperience());
                        }
                    });
                    return map;
                });
        System.out.println(f4.apply(instructors));


    }

}
