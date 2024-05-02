package com.practice.java.functionalprogramming;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[] args) {

        Consumer<String> stringConsumer = (x) -> System.out.println("String length: " + x.length());
        stringConsumer.accept("Up in the air");

        // with block statement
        Consumer<Integer> integerConsumer = (x) -> {
            System.out.println("x*x="+x*x);
            System.out.println("x/x="+x/x);
        };
        integerConsumer.accept(10);

        List<Instructor> instructors = Instructors.getAll();
        Consumer<Instructor> instructorConsumer1 = System.out::println;
        instructors.forEach(instructorConsumer1);

        System.out.println("-----------------");
        Consumer<Instructor> instructorConsumer2 = (x) -> System.out.println(x.getName());
        instructors.forEach(instructorConsumer2);

        System.out.println("-----------------");
        Consumer<Instructor> instructorConsumer3 = (x) -> System.out.println(x.getCourses());
        instructors.forEach(instructorConsumer2.andThen(instructorConsumer3));

        System.out.println("-----------------");
        instructors.forEach(
                i -> {
                    if(i.getExperience() >= 10) {
                        instructorConsumer2.accept(i);
                    }
                }
        );

        System.out.println("-----------------");
        instructors.forEach((x) -> {
                    if(x.getExperience() >= 5 && x.isOnlineCourse()) {
                        instructorConsumer2.andThen(instructorConsumer3).accept(x);
                    }
                }


        );

    }

}
