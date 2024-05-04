package com.practice.java.functionalprogramming;

import java.util.List;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

public class PredicateExample {

    public static void main(String[] args) {

        /**
         * Basic implementation
         */
        Predicate<Integer> predicate1 = (x) -> x > 10;
        System.out.println(predicate1.test(100));

        System.out.println("--------------");
        Predicate<Integer> predicate2 = (x) -> x % 2 == 0;
        System.out.println(predicate1.and(predicate2).test(100));

        System.out.println("------n > 10 && n is even--------");
        System.out.println(predicate1.or(predicate2).test(8));
        System.out.println(predicate1.or(predicate2).test(79));
        System.out.println(predicate1.or(predicate2).test(9));

        System.out.println("------n > 10 && n is odd--------");
        System.out.println(predicate1.and(predicate2.negate()).test(80));
        System.out.println(predicate1.and(predicate2.negate()).test(79));

        /**
         * More implementation with Collection
         */
        List<Instructor> instructors = Instructors.getAll();

        System.out.println("------Instructor who teaches online--------");
        Predicate<Instructor> predicate3 = (x) -> x.isOnlineCourse();

        instructors.forEach(instructor -> {
            if(predicate3.test(instructor)) {
                System.out.println(instructor);
            }
        });

        System.out.println("------Instructor experience > 10 years--------");
        Predicate<Instructor> predicate4 = (x) -> x.getExperience() > 6;
        instructors.forEach(instructor -> {
            if(predicate3.and(predicate4).test(instructor)) {
                System.out.println(instructor);
            }
        });

        /**
         * Specialised Predicates
         * IntPredicate, LongPredicate, DoublePredicate
         */
        System.out.println("-----------------");
        IntPredicate intPredicate = (x) -> x > 10;
        LongPredicate longPredicate = (x) -> x > 100L;
        DoublePredicate doublePredicate = (x) -> x > 10.0;

        System.out.println(intPredicate.test(20));
        System.out.println(longPredicate.test(200L));
        System.out.println(doublePredicate.test(20.0));

        System.out.println(intPredicate.test(2));
        System.out.println(longPredicate.test(20L));
        System.out.println(doublePredicate.test(2.0));


    }

}
