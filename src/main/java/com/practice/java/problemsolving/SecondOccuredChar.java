package com.practice.java.problemsolving;

import java.util.LinkedHashMap;
import java.util.Map;

public class SecondOccuredChar {
	
	public static void main(String a[]) {
		String s1 = "data binding";
		
		int count1 = 0;		
		
		Map<Character, Integer> map = new LinkedHashMap<>();
		
		for(int j=0; j<s1.length(); j++) {
			if(map.containsKey(s1.charAt(j))) {
				map.put(s1.charAt(j), map.get(s1.charAt(j))+ 1);
			} else {
				map.put(s1.charAt(j), 1);
			}
		}
		
		map.forEach((k, v) -> System.out.println("Key: "+k+" Value: "+v));
		
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : "+ entry.getValue());
		}
		
		for(int i=0; i<s1.length(); i++) {
			for(int j=i+1; j<s1.length(); j++) {
				if(s1.charAt(i) == s1.charAt(j)) {
					count1++;
					if(count1 > 1) {
						System.out.println(s1.charAt(i));
						return;
					}
				}
			}
		}
		
	}

}
