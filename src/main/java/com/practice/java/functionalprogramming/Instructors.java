package com.practice.java.functionalprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Instructors {

    public static List<Instructor> getAll() {
        List<Instructor> instructors = new ArrayList<>();

        instructors.add(
                new Instructor("Mike", 10, "Senior Software Developer", "M",
                true, Arrays.asList("Java", "Python", "C++")));
        instructors.add(
                new Instructor("Pike", 5, "Software Developer", "M",
                false, Arrays.asList("CI/CD", "Unit Testing")));
        instructors.add(
                new Instructor("Like", 15, "Lead Software Developer", "F",
                false, Arrays.asList("Java", "Junit")));
        instructors.add(
                new Instructor("Nike", 2, "Junior Software Developer", "F",
                true, Arrays.asList("Flask", "Python")));
        instructors.add(
                new Instructor("Tike", 6, "Software Developer", "M",
                true, Arrays.asList("C", "C++")));
        instructors.add(
                new Instructor("Hike", 10, "Senior Software Developer", "F",
                true, Arrays.asList("Javascript", "Typescript")));

        return instructors;
    }

}
