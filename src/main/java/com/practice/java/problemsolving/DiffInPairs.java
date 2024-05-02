package com.practice.java.problemsolving;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DiffInPairs {

	public static void main(String[] args) {
		
		List<Integer> numbers = new ArrayList<>();
		numbers.add(4);
		numbers.add(2);
		numbers.add(1);
		numbers.add(3);
		numbers.add(6);
		numbers.add(5);
		
		printNums(numbers);
		
	}
	
	public static void printNums(List<Integer> numbers) {
		
		Set<List<Integer>> numset = new HashSet<List<Integer>>();
		int diff = Integer.MAX_VALUE;
		
		for(int i=0; i<numbers.size(); i++) {
			for(int j=0; j<numbers.size(); j++) {
				if(j != i) {
					int minus = Math.abs(numbers.get(i) - numbers.get(j));
					if(minus < diff) {
						diff = minus;
						numset.clear();
						List<Integer> list = new ArrayList<Integer>();
						list.add(numbers.get(i));
						list.add(numbers.get(j));
						numset.add(list);
					} else if(minus == diff) {
						List<Integer> list = null;
						boolean flag = false;
						for(List<Integer> list1 : numset) {
							if(list1.contains(numbers.get(i)) && list1.contains(numbers.get(j))) {
								flag = true;
								break;
							}
						}
						if(!flag) {
							list = new ArrayList<Integer>();
							list.add(numbers.get(i));
							list.add(numbers.get(j));
						}
						if(list!=null)
							numset.add(list);
					}
				}
			}
		}
		
		for(List<Integer> list1 : numset) {
			for(int i=0; i<list1.size()-1; i++) {
				System.out.println(list1.get(i) + " " + list1.get(i+1));
			}
		}
		
	}

}
