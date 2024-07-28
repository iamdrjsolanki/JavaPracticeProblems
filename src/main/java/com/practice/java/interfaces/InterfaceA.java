package com.practice.java.interfaces;

public interface InterfaceA {

    default void sumA(int a, int b) {
        System.out.println("InterfaceA.sumA: " + (a+b));
    }

}
