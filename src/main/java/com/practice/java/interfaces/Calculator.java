package com.practice.java.interfaces;

@FunctionalInterface
public interface Calculator {

    public int sum(int a, int b);

    default int subtract(int a, int b) {
        return a - b;
    }

    static int multiply(int a, int b) {
        return a * b;
    }

}
