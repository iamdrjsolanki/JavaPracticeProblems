package com.practice.java.functionalprogramming;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample {

    public static void main(String[] args) {

        /**
         * Basic implementation
         */
        BiConsumer<Integer, Integer> biConsumer1 = (a, b) -> System.out.println("a: "+a+" & b: "+b);
        biConsumer1.accept(5, 10);

        BiConsumer<Integer, Integer> biConsumer2 = (a, b) -> System.out.println("a + b: "+ (a+b));
        biConsumer2.accept(5, 10);

        BiConsumer<String, String> biConsumer3 = (a, b) -> System.out.println("concate a & b: "+ (a+b));
        biConsumer3.accept("why ", "this");

        /**
         * More implementation using Collection
         */
        List<Instructor> instructors = Instructors.getAll();

        System.out.println("----------------");
        BiConsumer<String, String> biConsumer4 = (name, gender) -> System.out.println("name: " + name + " & gender: "+ gender);
        instructors.forEach(instructor -> {
            biConsumer4.accept(instructor.getName(), instructor.getGender());
        });

        System.out.println("----------------");
        BiConsumer<String, List<String>> biConsumer5 = (name, list) -> System.out.println("name: " + name + " & courses: "+ list);
        instructors.forEach(instructor -> {
            biConsumer5.accept(instructor.getName(), instructor.getCourses());
        });

        System.out.println("----------------");
        instructors.forEach(instructor -> {
            if(instructor.isOnlineCourse()) {
                biConsumer4.accept(instructor.getName(), instructor.getGender());
            }
        });


    }

}
