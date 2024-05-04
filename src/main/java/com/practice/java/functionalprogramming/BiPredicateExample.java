package com.practice.java.functionalprogramming;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class BiPredicateExample {

    public static void main(String[] args) {

        List<Instructor> instructors = Instructors.getAll();

        System.out.println("------instructors who teaches online and experience > 6 years------");
        System.out.println("----BiConsumer print name & courses");

        BiPredicate<Boolean, Integer> bp1 = (online, exp) -> online == true && exp > 6;

        BiConsumer<String, List<String>> b1 = (x, y) -> System.out.println("name: "+ x + " & courses: " + y);

        instructors.forEach(instructor -> {
            if(bp1.test(instructor.isOnlineCourse(), instructor.getExperience())) {
                b1.accept(instructor.getName(), instructor.getCourses());
            }
        });

    }

}
