package com.practice.java.java8streams;

import com.practice.java.functionalprogramming.Instructor;
import com.practice.java.functionalprogramming.Instructors;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamCollectorsOperations {

    public static void main(String[] args) {

        List<Instructor> instructors = Instructors.getAll();

        /**
         * counting() -> Used for downstream operations
         * Example: groupingBy(String::length, counting)
         */
        // Count the number of instructor who teaches online courses
        Long count = instructors.stream()
                .filter(Instructor::isOnlineCourse)
                .collect(Collectors.counting());
        System.out.println("Count the number of instructor who teaches online courses: "+count);

        /**
         * mapping()
         * Collectors.mapping(Instructor::getName, Collectors.toList())
         */
        System.out.println("instructors by their years of experience");
        Map<Integer, List<String>> instructorExpMap = instructors.stream()
                .collect(Collectors.groupingBy(Instructor::getExperience,
                    Collectors.mapping(Instructor::getName, Collectors.toList())));
        instructorExpMap.forEach((x,y) -> System.out.println(x+":"+y));

        /**
         * minBy()
         * maxBy()
         */
        System.out.println("Instructor with minimum years of experience");
        Optional<Instructor> instructorWithMinYrsOfExp = instructors.stream()
                .collect(Collectors.minBy(Comparator.comparing(Instructor::getExperience)));
        System.out.println(instructorWithMinYrsOfExp.get());

        System.out.println("Instructor with maximum years of experience");
        Optional<Instructor> instructorWithMaxYrsOfExp = instructors.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Instructor::getExperience)));
        System.out.println(instructorWithMaxYrsOfExp.get());

        /**
         * summingInt()
         * averagingInt()
         */
        System.out.println("sum of years of exp of all instructors");
        int expSum = instructors.stream().collect(Collectors.summingInt(Instructor::getExperience));
        System.out.println(expSum);

        System.out.println("avg of years of exp of all instructors");
        double avgSum = instructors.stream().collect(Collectors.averagingInt(Instructor::getExperience));
        System.out.println(avgSum);

        /**
         * groupingBy(classifier)
         */
        System.out.println("group list of instructor names by their length");
        Map<Integer, List<String>> groupOfNameLength = instructors.stream().map(Instructor::getName)
                 .collect(Collectors.groupingBy(String::length));
        groupOfNameLength.forEach((k, v) -> System.out.println(k+":"+v));

        System.out.println("group list of instructor names by the gender");
        Map<String, List<Instructor>> groupOfGender = instructors.stream()
                .collect(Collectors.groupingBy(Instructor::getGender));
        groupOfGender.forEach((k, v) -> System.out.println(k+":"+v));

        System.out.println("group by exp where > 8 are Senior and others are junior");
        Map<String, List<Instructor>> groupOfExp = instructors.stream()
                .collect(Collectors.groupingBy(i -> i.getExperience() > 8 ? "Senior" : "Junior"));
        groupOfExp.forEach((k, v) -> System.out.println(k+":"+v));

        /**
         * groupingBy(classifier, downstream)
         */
        System.out.println("group by length of name & check that the names contains 'e' " +
                "and return only those names with 'e'");
        Map<Integer, List<String>> groupOfNameLengthAndE = instructors.stream().map(Instructor::getName)
                .collect(
                        Collectors.groupingBy(String::length,
                                Collectors.filtering(s -> s.contains("e"), Collectors.toList())
                        )
                );
        groupOfNameLengthAndE.forEach((k, v) -> System.out.println(k+":"+v));

        System.out.println("group by exp where > 8 are Senior and others are junior" +
                " and has online course");
        Map<String, List<Instructor>> groupOfExpAndOnline = instructors.stream()
                .collect(
                        Collectors.groupingBy(i -> i.getExperience() > 8 ? "Senior" : "Junior",
                                Collectors.filtering(Instructor::isOnlineCourse, Collectors.toList()))
                );
        groupOfExpAndOnline.forEach((k, v) -> System.out.println(k+":"+v));

        /**
         * groupingBy(classifier, mapFactory, downstream)
         */
        System.out.println("Using groupingBy(classifier, mapFactory, downstream)");
        System.out.println("group by length of name & check that the names contains 'e' " +
                "and return only those names with 'e'");
        Map<Integer, List<String>> groupOfNameLengthAndE1 = instructors.stream().map(Instructor::getName)
                .collect(
                        Collectors.groupingBy(String::length, LinkedHashMap::new,
                                Collectors.filtering(s -> s.contains("e"), Collectors.toList())
                        )
                );
        groupOfNameLengthAndE1.forEach((k, v) -> System.out.println(k+":"+v));

        System.out.println("group by exp where > 8 are Senior and others are junior" +
                " and has online course");
        Map<String, List<Instructor>> groupOfExpAndOnline1 = instructors.stream()
                .collect(
                        Collectors.groupingBy(i -> i.getExperience() > 8 ? "Senior" : "Junior", LinkedHashMap::new,
                                Collectors.filtering(Instructor::isOnlineCourse, Collectors.toList()))
                );
        groupOfExpAndOnline1.forEach((k, v) -> System.out.println(k+":"+v));

        /**
         * maxBy(), minBy(), collectingAndThen(), summarizingInt()
         */
        System.out.println("group instructors in 2 sets, online & not online & get max years of exp");
        Map<String, Optional<Instructor>> groupOnlineAndMaxExp = instructors.stream()
                .collect(
                        Collectors.groupingBy(i -> i.isOnlineCourse() ? "Online" : "!Online",
                                Collectors.maxBy(Comparator.comparing(Instructor::getExperience))
                        )
                );
        groupOnlineAndMaxExp.forEach((k, v) -> System.out.println(k+":"+v));

        System.out.println("group instructors in 2 sets, online & not online & get max years of exp " +
                "using collectingAndThen()");
        Map<String, Instructor> groupOnlineAndMaxExp1 = instructors.stream()
                .collect(
                        Collectors.groupingBy(i -> i.isOnlineCourse() ? "Online" : "!Online",
                                Collectors.collectingAndThen(
                                    Collectors.maxBy(Comparator.comparing(Instructor::getExperience)), Optional::get
                                )
                        )
                );
        groupOnlineAndMaxExp1.forEach((k, v) -> System.out.println(k+":"+v));

        System.out.println("Avg years of exp with group by on isOnline and !isOnline");
        Map<String, Double> groupOnlineAndAvgExp = instructors.stream()
                .collect(
                        Collectors.groupingBy(i -> i.isOnlineCourse() ? "Online" : "!Online",
                                Collectors.averagingInt(Instructor::getExperience)
                        )
                );
        groupOnlineAndAvgExp.forEach((k, v) -> System.out.println(k+":"+v));

        System.out.println("Drive a summary from properties of grouped items");
        Map<Object, IntSummaryStatistics> groupOnlineAndAvgExp1 = instructors.stream()
                .collect(
                        Collectors.groupingBy(i -> i.isOnlineCourse() ? "Online" : "!Online",
                                Collectors.summarizingInt(Instructor::getExperience)
                        )
                );
        groupOnlineAndAvgExp1.forEach((k, v) -> System.out.println(k+":"+v));

        /**
         * partitioningBy(predicate)
         * partitioningBy(predicate, downstream)
         */
        System.out.println("Partition instructors in 2 groups, exp > 10 and others");
        Map<Boolean, List<Instructor>> partitionedByExp = instructors.stream()
                .collect(Collectors.partitioningBy(i -> i.getExperience() > 8));
        partitionedByExp.forEach((k, v) -> System.out.println(k+":"+v));

        System.out.println("Partition instructors in 2 groups, exp > 10 and others " +
                "using downstream");
        Map<Boolean, Set<Instructor>> partitionedByExp1 = instructors.stream()
                .collect(Collectors.partitioningBy(i -> i.getExperience() > 8, Collectors.toSet()));
        partitionedByExp1.forEach((k, v) -> System.out.println(k+":"+v));


    }

}
