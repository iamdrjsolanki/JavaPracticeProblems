package com.practice.java.java8streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JavaStreamProblems {

    public static void main(String[] args) {

        System.out.println("Separate odd and even numbers in a list of integers : " + separateOddAndEvenNumbers());

        System.out.println("Remove duplicate elements from a list using Java 8 streams : " + removeDuplicatesFromList());

        System.out.println("Find the frequency of each character in a string using Java 8 streams : " + characterFrequencyInString());

        System.out.println("Find the frequency of each element in an array or a list : " + elementFrequencyInList());

        System.out.println("Sort a given list of decimals in reverse order : " + sortListInReverese());

        System.out.println("Sort a given list of decimals in reverse order: " + sortListOfDecimalsInReverse());
        System.out.println("Join a list of strings with '[' as prefix, ']' as suffix, and ',' as delimiter: " + joinListOfString());
        System.out.println("Print the numbers from a given list of integers that are multiples of 5: " + printMultipleOf5());
        System.out.println("Find the maximum and minimum of a list of integers." + minAndMaxOfIntegers());
        System.out.println("Merge two unsorted arrays into a single sorted array using Java 8 streams: " + sortAndMergeTwoArrays());
        System.out.println("Merge two unsorted arrays into a single sorted array without duplicates: " + sortAndMergeTwoArraysWithoutDuplicates());
        System.out.println("Get the three maximum and three minimum numbers from a given list of integers : "); getThreeMaxAndThreeMinNumbers();
        System.out.println("Check if two strings are anagrams or not using Java 8 streams: " + checkStringAnagrams());
        System.out.println("Find the sum of all digits of a number in Java 8 : " + sumOfAllDigits());
        System.out.println("Find the second largest number in an integer array : " + getSecondLargestNumber());
        System.out.println("Sort a list of strings according to the increasing order of their length : " + sortStringsIncreasingOrderOfLength());
        System.out.println("Find the sum and average of all elements in an integer array : "); findSumAndAvg();
        System.out.println("Find the common elements between two arrays : " + findCommonElementsInTwoArrays());
        System.out.println("Reverse each word of a string using Java 8 streams : " + reverseStrings());
        System.out.println("Find the sum of the first 10 natural numbers : " + sumOfFirst5NaturalNumbers());
        System.out.println("Reverse an integer array : " + reverseIntegerArray());
        System.out.println("Print the first 5 even numbers : " + getFirst5EvenNumbers());
        System.out.println("Find the most repeated element in an array : " + findMostRepeatedNumber());
        System.out.println("Check if a string is a palindrome using Java 8 streams: " + isStringPalindrome());
        System.out.println("Find strings in a list that start with a number: " + findStringInListStartsWithNumber());
        System.out.println("Extract duplicate elements from an array: " + extractDuplicatesFromArray());
//        System.out.println("Print duplicate characters in a string. Write a Java 8 program to print the duplicate characters in a string." + );
//        System.out.println("Find the first repeated character in a string. Write a Java 8 program to find the first repeated character in a string." + );
//        System.out.println("Find the first non-repeated character in a string. Write a Java 8 program to find the first non-repeated character in a string." + );
//        System.out.println("Generate the Fibonacci series. Write a Java 8 program to generate the Fibonacci series." + );
//        System.out.println("Print the first 10 odd numbers. Write a Java 8 program to print the first 10 odd numbers." + );
//        System.out.println("Get the last element of an array. Write a Java 8 program to get the last element of an array." + );
//        System.out.println("Calculate the age of a person in years. Write a Java 8 program to calculate the age of a person in years given their birthday.");

        List<Item> items = new ArrayList<>();
        items.add(new Item(123));
        items.add(new Item(456));
        items.add(new Item(123));
        items.add(new Item(789));

        Transaction transaction1 = new Transaction(items);
        Transaction transaction2 = new Transaction(List.of(new Item(123)));
        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(transaction1); transactionList.add(transaction2);

        System.out.println("Count all the items which has id 123 in transactionsList: " + countItemIds(transactionList, 123));


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

    private static List<Integer> sortAndMergeTwoArrays() {
        List<List<Integer>> integers = List.of(List.of(7, 4, 9, 2, 1), List.of(5, 9, 6, 0, 8));
        return integers.stream()
                .flatMap(Collection::stream)
                .sorted()
                .collect(Collectors.toList());
    }

    private static Set<Integer> sortAndMergeTwoArraysWithoutDuplicates() {
        List<List<Integer>> integers = List.of(List.of(7, 4, 9, 2, 1), List.of(5, 9, 6, 0, 8));
        return integers.stream()
                .flatMap(Collection::stream)
                .sorted()
                .collect(Collectors.toSet());
    }

    private static void getThreeMaxAndThreeMinNumbers() {
        List<Integer> integers = List.of(7, 4, 9, 2, 1, 5, 9, 6, 0, 8);
        List<Integer> threeMax = integers.stream().sorted(Comparator.comparingInt(a -> (int) a).reversed()).limit(3).collect(Collectors.toList());
        List<Integer> threeMin = integers.stream().sorted(Comparator.comparingInt(a -> a)).limit(3).collect(Collectors.toList());
        System.out.println("Max three: "+ threeMax);
        System.out.println("Min three: "+ threeMin);
    }

    private static boolean checkStringAnagrams() {
        String s1 = "act";
        String s2 = "tac";
        String sortedStr1 = s1.toLowerCase().chars().sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        String sortedStr2 = s2.toLowerCase().chars().sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        return sortedStr1.equals(sortedStr2);
    }

    private static int sumOfAllDigits() {
        List<Integer> integers = List.of(7, 4, 9, 2);
        return integers.stream().reduce(0, Integer::sum);
    }

    private static int getSecondLargestNumber() {
        List<Integer> integers = List.of(7, 4, 9, 2, 1, 5, 6, 0, 8);
        return integers.stream().sorted(Comparator.comparingInt(a -> (int) a).reversed()).skip(1).findFirst().get();
    }

    private static List<String> sortStringsIncreasingOrderOfLength() {
        List<String> strings = List.of("asdf", "qwerty", "as", "a", "wer");
        return strings.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
    }

    private static void findSumAndAvg() {
        List<Integer> integers = List.of(7, 4, 9, 2);
        System.out.println("Sum of the integers: " + integers.stream().reduce(0, Integer::sum));
        System.out.println("Avg of the integers: " + integers.stream().collect(Collectors.averagingInt(b -> b)));
    }

    private static List<Integer> findCommonElementsInTwoArrays() {
        List<Integer> integers = List.of(7, 0, 9, 2, 1);
        List<Integer> integers2 = List.of(5, 9, 6, 0, 8);
        return integers.stream().distinct().filter(integers2::contains).collect(Collectors.toList());
    }

    private static List<String> reverseStrings() {
        List<String> strings = List.of("asdf", "qwerty", "as", "a", "wer");
        return strings.stream().map(s -> new StringBuilder(s).reverse().toString()).collect(Collectors.toList());
    }

    private static int sumOfFirst5NaturalNumbers() {
        List<Integer> integers = List.of(7, 4, 9, 2, 1, 5, 6, 0, 8);
        return integers.stream().sorted().limit(5).reduce(0, Integer::sum);
    }

    private static String reverseIntegerArray() {
        int[] integers = {7, 4, 9, 2, 1, 5, 6, 0, 8};
        return Arrays.toString(IntStream.range(0, integers.length).map(i -> integers[integers.length - 1 - i]).toArray());
    }

    private static List<Integer> getFirst5EvenNumbers() {
        List<Integer> integers = List.of(7, 4, 9, 2, 1, 5, 6, 0, 8, 10);
        return integers.stream().filter(i -> i % 2 == 0).limit(5).collect(Collectors.toList());
    }

    private static int findMostRepeatedNumber() {
        List<Integer> integers = List.of(7, 4, 9, 2, 1, 5, 6, 0, 8, 9, 9, 6);
        return integers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse(0);
    }

    private static String isStringPalindrome() {
        String str = "popop";
        return IntStream.range(0, str.length() / 2).allMatch(i -> str.charAt(i) == str.charAt(str.length() - i - 1))
                ? "String " + str + " is a palindrome!"
                : "String " + str + " is not a palindrome!";
    }

    private static String findStringInListStartsWithNumber() {
        List<String> strings = List.of("safaas", "2fasdfds", "asdfd", "asdfa", "5dfsgds", "w33fdsaf");
        List<String> numbers = List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
        return strings.stream().filter(s -> Character.isDigit(s.charAt(0))).collect(Collectors.joining(", "));
    }

    private static String extractDuplicatesFromArray() {
        int[] arr = {1, 2, 3, 4, 4, 5, 6, 7, 7, 2, 9, 1, 0};
        List<Integer> arr1 = List.of(1, 2, 3, 4, 4, 5, 6, 7, 7, 2, 9, 1, 0);
        return arr1.stream()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet()
                    .stream()
                    .filter(e -> e.getValue() > 1)
                    .map(Map.Entry::getKey)
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
    }



    private static long countItemIds(List<Transaction> transactionList, int id) {
        return transactionList.stream()
                .flatMap(t -> t.getItems().stream())
                .filter(i -> i.getItemId() == id)
                .count();
    }

}

class Transaction {
    private List<Item> items;
    Transaction(List<Item> items) { this.items = items; }
    public List<Item> getItems() { return this.items; }
}

class Item {
    private int itemId;
    Item(int id) { this.itemId = id; }
    public int getItemId() { return this.itemId; }
}