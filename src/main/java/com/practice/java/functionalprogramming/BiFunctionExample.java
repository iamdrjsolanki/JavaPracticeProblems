package com.practice.java.functionalprogramming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BiFunctionExample {

    public static void main(String[] args) {

        /**
         * Basic Implementation
         * takes 3 arg type
         * 2 for input & 1 for output
         * Function<Integer, Integer, Boolean>
         */

        System.out.println("----BiFunction<List<Instructor>, Predicator<Instructor>" +
                "which will filter if instructor has online courses" +
                "and return a map of String, Integer as name & exp----");
        Predicate<Instructor> p1 = x -> x.isOnlineCourse() == true;
        BiFunction<List<Instructor>, Predicate<Instructor>, Map<String, Integer>> f1 =
                ((list, predicate) -> {
                    Map<String, Integer> map = new HashMap<>();
                    list.forEach(i -> {
                        if(predicate.test(i)) {
                            map.put(i.getName(), i.getExperience());
                        }
                    });
                    return map;
                });

        System.out.println(f1.apply(Instructors.getAll(), p1));


    }

}
