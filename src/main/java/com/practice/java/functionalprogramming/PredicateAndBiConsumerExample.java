package com.practice.java.functionalprogramming;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class PredicateAndBiConsumerExample {

    public static void main(String[] args) {

        List<Instructor> instructors = Instructors.getAll();

        System.out.println("------all instructors who teaches online------");
        System.out.println("------instructor experience > 6 years------");
        System.out.println("----BiConsumer print name & courses");

        Predicate<Instructor> p1 = (x) -> x.isOnlineCourse();

        Predicate<Instructor> p2 = (x) -> x.getExperience() > 6;

        BiConsumer<String, List<String>> b1 = (x, y) -> System.out.println("name: "+ x + " & courses: " + y);

        instructors.forEach(instructor -> {
            if(p1.and(p2).test(instructor)) {
                b1.accept(instructor.getName(), instructor.getCourses());
            }
        });

    }

}
