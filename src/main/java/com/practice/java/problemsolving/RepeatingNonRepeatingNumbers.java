package com.practice.java.problemsolving;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * Find the first repeating element in an array of integers
 * Input:  arr[] = {10, 5, 3, 4, 3, 5, 6}
 * Output: 5 [5 is the first element that repeats]
 * Output: 10 [10 is the first element that is non repeating]
*/

public class RepeatingNonRepeatingNumbers {
	
	public static void main(String a[]) {
		
		int arr[] = {10, 5, 3, 4, 3, 5, 6};
		
		Map<Integer, Integer> map = new LinkedHashMap<>();
		boolean repeating = false;
		boolean nonrepeating = false;

		for(int i=0; i<arr.length; i++) {
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(!repeating && entry.getValue() > 1) {
				System.out.println("1st Repeating number: "+entry.getKey());
				repeating = true;
			}
			if(!nonrepeating && entry.getValue() == 1) {
				System.out.println("Last Non repeating number: "+entry.getKey());
				nonrepeating = true;
			}
			if(repeating && nonrepeating) {
				break;
			}
		}
	}

}
