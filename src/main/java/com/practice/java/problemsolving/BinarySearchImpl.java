package com.practice.java.problemsolving;

public class BinarySearchImpl {

    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 8, 12, 15, 18, 23, 45, 67, 89};
        int target = 1;
        int n = arr.length;
        int result = binarySearch(arr, 0, n-1, target);
        System.out.println(result == -1 ? "element is not present in array" : "element present at index: " + result);
    }

    private static int binarySearch(int[] arr, int s, int e, int t) {
        // start index should always be lesser than end index
        if(s < e) {
            // middle = start index + (end index - start index) / 2
            // example in first iteration: 0 + (11 - 0) / 2 = 5
            int m = s + (e - s) / 2;
            // if target exists at middle then return
            if(arr[m] == t)
                return m;
            // if target is greater than value at middle index then send the right arr for recursive search
            // else send the left arr for recursive search
            return t > arr[m] ? binarySearch(arr, m+1, e, t) : binarySearch(arr, s, m, t);
        }
        // return -1 as the target is not present in the array
        return -1;
    }

}
