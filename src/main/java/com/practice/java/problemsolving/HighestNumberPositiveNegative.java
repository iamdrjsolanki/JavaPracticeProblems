package com.practice.java.problemsolving;

import java.util.Arrays;
import java.util.List;

public class HighestNumberPositiveNegative {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(-3, 2, 1, -2, -3, 3);
		List<Integer> numbers1 = Arrays.asList(-3, 2, 8, -9, -6, -3, -2, 9);
		System.out.println(highestPositiveNegative(numbers));
		System.out.println(highestPositiveNegative(numbers1));
	}
	
	public static int highestPositiveNegative(List<Integer> numbers) {
		int max = Integer.MIN_VALUE;
		for(int i=0; i<numbers.size(); i++) {
			int curr = numbers.get(i);
			if(curr > 0 && curr > max) {
				int currOpp = curr + (curr * -2);
				System.out.println("curr:"+curr+" currOpp:"+currOpp);
				if(numbers.contains(currOpp)) {
					if(curr > max) {
						max = curr;
					}
				}
			}			
		}
		return max;
	}

}
