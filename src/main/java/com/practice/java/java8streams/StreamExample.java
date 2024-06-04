package com.practice.java.java8streams;

import com.practice.java.functionalprogramming.Instructor;
import com.practice.java.functionalprogramming.Instructors;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class StreamExample {

    public static void main(String[] args) {

        List<Instructor> instructors = Instructors.getAll();

        Predicate<Instructor> p1 = Instructor::isOnlineCourse;
        Predicate<Instructor> p2 = i -> i.getExperience() > 6;

        System.out.println("creating a map of names and courses of instructors who teaches online " +
                "and have more than 6 years of exp");
        Map<String, List<String>> map1 = instructors.stream()
                .filter(p1.and(p2))
                .collect(Collectors.toMap(Instructor::getName, Instructor::getCourses));

        System.out.println(map1);

        System.out.println("Map Operation: return only list of instructor names");
        List<String> list1 = instructors.stream()
                .map(Instructor::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(list1);

        System.out.println("FlatMap Operation: get a list of all the courses which instructors offers");
        Set<String> list2 = instructors.stream()
                .map(Instructor::getCourses)
                .flatMap(List::stream)
                .collect(Collectors.toSet());
        System.out.println(list2);

        System.out.println("Distinct Operation: Distinct Count all the courses instructors provide");
        Long list3 = instructors.stream()
                .map(Instructor::getCourses)
                .flatMap(List::stream)
                .distinct()
                .count();
        System.out.println(list3);

        System.out.println("Distinct Operation: Distinct list of all the courses instructors provide");
        List<String> distinctCourses = instructors.stream()
                .map(Instructor::getCourses)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinctCourses);

        System.out.println("Count Operation: Count all the courses instructors provide");
        Long list4 = instructors.stream()
                .map(Instructor::getCourses)
                .flatMap(List::stream)
                .count();
        System.out.println(list4);

        System.out.println("Sorted Operation: Distinct Sorted list of all the courses instructors provide");
        List<String> distinctSortedCourses = instructors.stream()
                .map(Instructor::getCourses)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(distinctSortedCourses);

        System.out.println("AnyMatch Operation: match Course Names Starts With J");
        boolean courseNameStartsWithJ = instructors.stream()
                .map(Instructor::getCourses)
                .flatMap(List::stream)
                .anyMatch(c -> c.startsWith("J"));
        System.out.println(courseNameStartsWithJ);

        System.out.println("AllMatch Operation: match all Course Names Starts With J");
        boolean allCourseNameStartsWithJ = instructors.stream()
                .map(Instructor::getCourses)
                .flatMap(List::stream)
                .allMatch(c -> c.startsWith("J"));
        System.out.println(allCourseNameStartsWithJ);

        System.out.println("NoneMatch Operation: match no Course Names Starts With J");
        boolean noCourseNameStartsWithJ = instructors.stream()
                .map(Instructor::getCourses)
                .flatMap(List::stream)
                .noneMatch(c -> c.startsWith("J"));
        System.out.println(noCourseNameStartsWithJ);

        System.out.println("Stream with Comparator: all instructors sorted by name, ascending order");
        List<Instructor> nameSortedAscList = instructors.stream()
                .sorted(Comparator.comparing(Instructor::getName))
                .collect(Collectors.toList());
        nameSortedAscList.forEach(System.out::println);

        System.out.println("Stream with Comparator: all instructors sorted by name, descending order");
        List<Instructor> nameSortedDescList = instructors.stream()
                .sorted(Comparator.comparing(Instructor::getName).reversed())
                .collect(Collectors.toList());
        nameSortedDescList.forEach(System.out::println);

        System.out.println("Reduce Operation: total exp of all instructors");
        Integer totalExp = instructors.stream()
                .map(Instructor::getExperience)
                .reduce(0, Integer::sum);
        System.out.println(totalExp);

        System.out.println("Reduce Operation: Multiplication of each numbers from 1 to 10");
        Integer multiplication = IntStream.rangeClosed(1, 10)
                .reduce(1, (a, b) -> a * b);
        System.out.println(multiplication);

        System.out.println("Reduce Operation: Multiplication of each numbers from 1 to 10");
        OptionalInt intSum = IntStream.rangeClosed(1, 10).reduce(Integer::sum);
        System.out.println(intSum.getAsInt());

        System.out.println("Reduce Operation: print the instructor who has highest years of exp");
        Optional<Instructor> instructor = instructors.stream()
                .reduce((a, b) -> a.getExperience() > b.getExperience() ? a: b);
        instructor.ifPresent(System.out::println);

        System.out.println("Map Filter Reduce Operation: total years of exp b/w instructors who is teaching online");
        Integer totalExp1 = instructors.stream()
                .filter(p1)
                .map(Instructor::getExperience)
                .reduce(0, Integer::sum);
        System.out.println(totalExp1);

        System.out.println("Max Operation: print the instructor who has highest years of exp");
        Optional<Integer> maxYearOfExp = instructors.stream()
                .map(Instructor::getExperience)
                .max(Integer::compareTo);
        System.out.println(maxYearOfExp);

        System.out.println("Min Operation: print the instructor who has lowest years of exp");
        Optional<Integer> minYearOfExp = instructors.stream()
                .map(Instructor::getExperience)
                .min(Integer::compareTo);
        System.out.println(minYearOfExp);

        System.out.println("Limit Operation: print only 5 numbers from 1 to 10");
        IntStream.rangeClosed(1, 10).limit(5).forEach(System.out::println);

        System.out.println("Skip Operation: skip 5 numbers from 1 to 10");
        IntStream.rangeClosed(1, 10).skip(5).forEach(System.out::println);

        System.out.println("FindAny Operation: print any instructor");
        Optional<Instructor> findAnyInstructor = instructors.stream().findAny();
        System.out.println(findAnyInstructor);

        System.out.println("FindFirst Operation: print first instructor");
        Optional<Instructor> findFirstInstructor = instructors.stream().findFirst();
        System.out.println(findFirstInstructor);

        System.out.println("mapToObj Operation: int stream to a class RandomIds");
        List<RandomIds> randomIds = IntStream.rangeClosed(1, 5)
                .mapToObj(i -> new RandomIds(i, ThreadLocalRandom.current().nextInt(100)))
                .collect(Collectors.toList());
        randomIds.forEach(System.out::println);

        System.out.println("mapToLong Operation: int to long");
        LongStream longStream = IntStream.rangeClosed(1, 5).mapToLong(i -> (long) i);
        longStream.forEach(System.out::println);

        System.out.println("mapToDouble Operation: long to double");
        DoubleStream doubleStream = LongStream.rangeClosed(1, 5).mapToDouble(i -> (double) i);
        doubleStream.forEach(System.out::println);


    }

}

class RandomIds {
    int id;
    int randomNumbers;

    public RandomIds(int id, int randomNumbers) {
        this.id = id;
        this.randomNumbers = randomNumbers;
    }
}