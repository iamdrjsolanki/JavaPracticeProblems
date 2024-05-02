package com.practice.java.problemsolving;

import java.util.HashMap;
import java.util.Map;

//input Array : {-40, -5, 1, 3, 6, 7, 8, 20}
//sum = 15
//Print numbers to which by adding them we get the output as sum.

public class PrintNumbersForSum {

	public static void main(String[] args) {
			int[] arr = {-40, -5, 1, 3, 6, 7, 8, 20};
			Map<Integer, Integer> sumMap = new HashMap<>();
			for(int i=0; i<arr.length; i++) {
				if(sumMap.containsKey(arr[i])) {
					System.out.println(sumMap.get(arr[i]) + " " + arr[i]);
				}
				if(sumMap.containsKey(arr[i]*-1)) {
					System.out.println(sumMap.get(arr[i]*-1) + " " + arr[i]);
				}
				int sum = arr[i] - 15;
				sumMap.put(sum, arr[i]);
			}
		
		}
	
	
//Array = {13, 15, 16, 17, 18, 19, 20, 9};
	/*13 -> 7
	7 -> 6
	6 -> -1
	12 -> -1*/
	
	/*13 -> 9
	15 -> 9
	16 -> 9
	17 -> 9
	18 -> 9
	19 -> 9
	20 -> 9
	9 -> -1*/
	
	
	
}

