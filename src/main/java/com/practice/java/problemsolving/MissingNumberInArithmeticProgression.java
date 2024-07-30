package com.practice.java.problemsolving;

public class MissingNumberInArithmeticProgression {

    /**
     * You are given a sorted array of ‘N’ distinct integers that are in the Arithmetic Progression sequence
     * except for one element which is missing from the sequence.
     * You have to find that missing number from the given sequence.
     *
     * Note:
     * 1. A sequence [arr0, arr1,…, arr(n-1)] is called an Arithmetic progression
     * if for each 'i' ( 0 ≤ i < n - 1) the value arr[i+1] − arr[i] is the same.
     * 2. There is exactly one missing number in the given sequence.
     * 3. All the numbers present in the sequence are distinct.
     * 4. It is the guarantee that the first and last elements of the sequence are not missing elements.
     */

    public static void main(String[] args) {
        int[] arr = {1, 6, 11, 16, 26};
        System.out.println(findMissingNumberInArithmeticProgression(arr));
    }

    public static int findMissingNumberInArithmeticProgression(int[] arr) {
        int n = arr.length;
        int a = arr[0];
        int l = arr[arr.length-1];
        int sum = 0;
        int s = 0;
        int missingnumber = 0;
        /* Taking the sum of all the elements of the array including the missing element using formulae
           S(n) = n/2 (a+l)  where a is the first element and l is the last element */

        // ensuring this as n/2(a+l) and (a+l)/2 would give different values programmatically
        if ((a + l) % 2 == 0) {
            s = (a + l) / 2;
            s = s * (n + 1);
        } else {
            s = (n + 1) / 2;
            s = (a + l) * s;
        }

        // Taking the sum of all the elements of the array excluding the missing element
        for (int i = 0; i <= n - 1; i++) {
            sum = sum + arr[i];
        }

        missingnumber = s - sum;

        return missingnumber;
    }

}
