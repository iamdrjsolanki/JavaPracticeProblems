package com.practice.java.java8streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreamProblems {

    public static void main(String[] args) {

        System.out.println("Separate odd and even numbers in a list of integers : " + separateOddAndEvenNumbers());

        System.out.println("Remove duplicate elements from a list using Java 8 streams : " + removeDuplicatesFromList());

        System.out.println("Find the frequency of each character in a string using Java 8 streams : " + characterFrequencyInString());

        System.out.println("Find the frequency of each element in an array or a list : " + elementFrequencyInList());

        System.out.println("Sort a given list of decimals in reverse order : " + sortListInReverese());

        System.out.println("Sort a given list of decimals in reverse order" + sortListOfDecimalsInReverse());
        System.out.println("Join a list of strings with '[' as prefix, ']' as suffix, and ',' as delimiter" + joinListOfString());
        System.out.println("Print the numbers from a given list of integers that are multiples of 5." + printMultipleOf5());
        System.out.println("Find the maximum and minimum of a list of integers." + minAndMaxOfIntegers());
//        System.out.println("Merge two unsorted arrays into a single sorted array using Java 8 streams. Write a Java 8 program to merge two unsorted arrays into a single sorted array using the stream API." + );
//        System.out.println("Merge two unsorted arrays into a single sorted array without duplicates. Write a Java 8 program to merge two unsorted arrays into a single sorted array without duplicates." + );
//        System.out.println("Get the three maximum and three minimum numbers from a given list of integers. Write a Java 8 program to get the three maximum and three minimum numbers from a given list of integers." + );
//        System.out.println("Check if two strings are anagrams or not using Java 8 streams. Write a Java 8 program to check if two strings are anagrams or not using the stream API and lambda expressions." + );
//        System.out.println("Find the sum of all digits of a number in Java 8. Write a Java 8 program to find the sum of all digits of a given number." + );
//        System.out.println("Find the second largest number in an integer array. Write a Java 8 program to find the second largest number in an integer array." + );
//        System.out.println("Sort a list of strings according to the increasing order of their length. Write a Java 8 program to sort a given list of strings according to the increasing order of their length." + );
//        System.out.println("Find the sum and average of all elements in an integer array. Write a Java 8 program to find the sum and average of all elements in an integer array." + );
//        System.out.println("Find the common elements between two arrays. Write a Java 8 program to find the common elements between two arrays using streams." + );
//        System.out.println("Reverse each word of a string using Java 8 streams. Write a Java 8 program to reverse each word of a given string using the stream API and lambda expressions." + );
//        System.out.println("Find the sum of the first 10 natural numbers. Write a Java 8 program to find the sum of the first 10 natural numbers using streams." + );
//        System.out.println("Reverse an integer array. Write a Java 8 program to reverse an integer array." + );
//        System.out.println("Print the first 10 even numbers. Write a Java 8 program to print the first 10 even numbers." + );
//        System.out.println("Find the most repeated element in an array. Write a Java 8 program to find the most repeated element in an array." + );
//        System.out.println("Check if a string is a palindrome using Java 8 streams. Write a Java 8 program to check if a given string is a palindrome using the stream API and lambda expressions." + );
//        System.out.println("Find strings in a list that start with a number. Given a list of strings, write a Java 8 program to find the strings that start with a number." + );
//        System.out.println("Extract duplicate elements from an array. Write a Java 8 program to extract duplicate elements from an array." + );
//        System.out.println("Print duplicate characters in a string. Write a Java 8 program to print the duplicate characters in a string." + );
//        System.out.println("Find the first repeated character in a string. Write a Java 8 program to find the first repeated character in a string." + );
//        System.out.println("Find the first non-repeated character in a string. Write a Java 8 program to find the first non-repeated character in a string." + );
//        System.out.println("Generate the Fibonacci series. Write a Java 8 program to generate the Fibonacci series." + );
//        System.out.println("Print the first 10 odd numbers. Write a Java 8 program to print the first 10 odd numbers." + );
//        System.out.println("Get the last element of an array. Write a Java 8 program to get the last element of an array." + );
//        System.out.println("Calculate the age of a person in years. Write a Java 8 program to calculate the age of a person in years given their birthday.");

    }

    private static Collection<List<Integer>> separateOddAndEvenNumbers() {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 ,13, 14, 15);
        return integers.stream()
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.partitioningBy(x -> x % 2 == 0), Map::values
                        )
                );
    }

    private static Set<Integer> removeDuplicatesFromList() {
        return Arrays.asList(1, 2, 3, 1, 2, 3, 1, 2, 5, 5, 34, 7, 3, 7, 8, 9, 9, 8)
                .stream().collect(Collectors.toSet());
    }

    private static Map<String, Long> characterFrequencyInString() {
        String str = "ASDFASFQWERQWRETBFDJM";
        return Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(x -> x, LinkedHashMap::new, Collectors.counting()));
    }

    private static Map<String, Long> elementFrequencyInList() {
        List<String> elements = List.of("a", "s", "d", "f", "a", "f");
        return elements.stream().collect(
                Collectors.groupingBy(e -> e, LinkedHashMap::new, Collectors.counting())
        );
    }

    private static List<Integer> sortListInReverese() {
        List<Integer> integers = List.of(5, 2, 7, 9, 1, 2, 0, 5, 23 ,7, 8, 3242 ,7345);
        return integers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    private static List<Double> sortListOfDecimalsInReverse() {
        List<Double> doubles = List.of(5.2, 2.5, 7.2, 5.5, 2.9, 7.9);
        return doubles.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    private static String joinListOfString() {
        List<String> strings  = List.of("sadf", "sdfg", "qwer", "tyuiy", "zxcv", "ndgfbvd");
        return strings.stream().collect(Collectors.joining(",", "[", "]"));
    }

    private static List<Integer> printMultipleOf5() {
        List<Integer> integers = List.of(5, 8, 10, 15, 18, 13, 23, 24, 35, 25);
        return integers.stream().filter(x -> x % 5 == 0).collect(Collectors.toList());
    }

    private static Collection<Integer> minAndMaxOfIntegers() {
        List<Integer> integers = List.of(5, 2, 7, 9, 1, 2, 0, 5, 23 ,7, 8, 3242 ,7345);
        Collection<Integer> collection = new ArrayList<>();
        collection.add(integers.stream().min(Integer::compareTo).orElse(Integer.MIN_VALUE));
        collection.add(integers.stream().max(Integer::compareTo).orElse(Integer.MAX_VALUE));
        return collection;
    }

}
