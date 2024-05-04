package com.practice.java.functionalprogramming;

import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {

        /**
         * Basic Implementation
         * Does not have input type arg
         * Has a return type like Function
         */

        Supplier<Integer> s1 = () -> (int) (Math.random() * 100);
        System.out.println(s1.get());
        System.out.println(s1.get());

    }


}
