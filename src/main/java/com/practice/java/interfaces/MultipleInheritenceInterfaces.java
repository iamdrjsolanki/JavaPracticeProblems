package com.practice.java.interfaces;

public class MultipleInheritenceInterfaces implements InterfaceA, InterfaceB, InterfaceC {

    public static void main(String[] args) {

        MultipleInheritenceInterfaces multi = new MultipleInheritenceInterfaces();
        multi.sumA(1, 2);
        multi.sumB(2, 3);
        multi.sumC(3, 4);

    }

    public void sumA(int a, int b) {
        System.out.println("MultipleInheritenceInterfaces.sumA: " + (a+b));
    }

}
