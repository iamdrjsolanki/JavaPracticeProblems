package com.practice.java.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringOccurences {

	public static void main(String[] args) {
		
		List<String> stringList = new ArrayList<>();
		Map<String, Integer> stringOccurencesMap = new HashMap<>();
		
		stringList.add("Computer");stringList.add("Laptop");stringList.add("Keyboard");stringList.add("Keyboard");
		stringList.add("Computer");stringList.add("Mouse");stringList.add("Computer");
		
		for(int i=0; i<stringList.size(); i++) {
			if(stringOccurencesMap.containsKey(stringList.get(i))) {
				int count = stringOccurencesMap.get(stringList.get(i));
				stringOccurencesMap.put(stringList.get(i), count + 1);
			} else {
				stringOccurencesMap.put(stringList.get(i), 1);
			}
		}
		
		for(Map.Entry<String, Integer> entry : stringOccurencesMap.entrySet()) {
			System.out.println("The string: " + entry.getKey() + " & occurence: " +entry.getValue());
		}
		
		System.out.print("The string with multiple occurence: ");
		
		StringBuilder multipleStrings = new StringBuilder();
		
		for(Map.Entry<String, Integer> entry : stringOccurencesMap.entrySet()) {
			if(entry.getValue() > 1) {
				multipleStrings.append(entry.getKey() + ", ");
			}
		}
		
		System.out.print(multipleStrings.toString());
		
	}

}
