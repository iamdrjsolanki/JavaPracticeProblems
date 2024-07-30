package com.practice.java.problemsolving;

import java.util.Arrays;

public class LeftRotationsOfArray {

    /**
     * Perform each query on the original array only i.e. every output should be according to the original order of elements.
     *
     * Let the array be [1, 2, 3, 4, 5, 6] and the queries be {2, 4, 1}.
     * For every query, we’ll perform the required number of left rotations on the array.
     * For the first query, rotate the given array to the left by 2 elements, so the resultant array is: [3, 4, 5, 6, 1, 2].
     * For the second query, rotate the given array to the left by 4 elements, so the resultant array is: [5, 6, 1, 2, 3, 4].
     * For the third query, rotate the given array to the left by 1 element, so the resultant array is: [2, 3, 4, 5, 6, 1].
     */

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int queries = 2;

        rotateUsingTempArray(arr, queries);
        System.out.println("\n");
        rotateSubArrays(arr, queries);
        System.out.println("\n");
    }

    public static void rotateUsingTempArray(int[] arr, int q) {
        int[] tempArr = new int[arr.length];
        int tempCounter = 0;
        for(int i=q; i<arr.length; i++) {
            tempArr[tempCounter] = arr[i];
            tempCounter++;
        }
        int counter = arr.length - q;
        for(int i=0; i<q; i++) {
            tempArr[counter] = arr[i];
            counter++;
        }
        Arrays.stream(tempArr).forEach(System.out::print);
    }

    public static void rotateSubArrays(int[] arr, int q) {
        reverseSubArray(arr, 0, q-1);
        reverseSubArray(arr, q, arr.length - 1);
        reverseSubArray(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::print);
    }

    public static void reverseSubArray(int[] arr, int startIdx, int endIdx) {
        while(startIdx < endIdx) {
            int temp = arr[startIdx];
            arr[startIdx] = arr[endIdx];
            arr[endIdx] = temp;
            startIdx++;
            endIdx--;
        }
    }

}
