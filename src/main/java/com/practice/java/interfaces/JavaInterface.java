package com.practice.java.interfaces;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class JavaInterface implements Calculator{

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Mike", "Syed", "Jenny", "Gene", "Rajeev");
        /*Collections.sort(names);
        System.out.println("names: "+names);*/
        names.sort(Comparator.naturalOrder());
        System.out.println("names: "+names);

        /**
         * Math Operations
         */
        JavaInterface obj = new JavaInterface();
        System.out.println("Sum: "+obj.sum(1, 2));
        System.out.println("Subtract: "+obj.subtract(2, 1));
        System.out.println("Multiply: "+Calculator.multiply(3, 2));

        Calculator calculator = (a, b) -> a % b;
        System.out.println("Overriden using lamba & mod operation: "+calculator.sum(999, 10));

    }

    @Override
    public int sum(int a, int b) {
        return a + b;
    }
}
