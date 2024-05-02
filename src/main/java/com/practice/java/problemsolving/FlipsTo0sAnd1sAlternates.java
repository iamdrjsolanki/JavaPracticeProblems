package com.practice.java.problemsolving;

import java.util.Arrays;
import java.util.List;

public class FlipsTo0sAnd1sAlternates {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 1, 0, 1, 1);
		System.out.println(minimumFlipsRequiredForAlternates(numbers));
	}
	
	public static int minimumFlipsRequiredForAlternates(List<Integer> numbers) {
		int start0FlipCount = 0, start1FlipCount = 0;
		int startWith0 = 0, startWith1 = 1;
		
		for(int i=0; i<numbers.size(); i++) {
			int curr = numbers.get(i);
			if(startWith0 != curr) {
				start0FlipCount++;
				startWith0 = startWith0==0 ? 1 : 0;
			} else {
				startWith0 = startWith0==0 ? 1 : 0;
			}
			
			if(startWith1 != curr) {
				start1FlipCount++;
				startWith1 = startWith1==0 ? 1 : 0;
			} else {
				startWith1 = startWith1==0 ? 1 : 0;
			}
		}
		System.out.println(start0FlipCount);
		System.out.println(start1FlipCount);
		
		return Math.min(start0FlipCount, start1FlipCount);
	}

}
