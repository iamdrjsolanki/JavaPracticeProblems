package com.practice.java.problemsolving;

public class Anagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package com.practice.problems;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestClass {

	public static void main(String[] args) {
		//07/12/2021
		checkAnagrams("hello", "ehlll");
	}
	
	static void returnDate(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat();
		Date input = sdf.parse(date);
		
				
		LocalDateTime todaysDate = LocalDateTime.now();
		
		//Instant instant = input.
		
	}
	
	/*
	 * String s = "[{'id':1, 'name': 'test'}, {'id':2, 'name': 'test2'}]";
	 * 
	 * String s1 = "hello"; String s2 = "eholl";
	 */
	
	static void checkAnagrams(String s1, String s2) {
		boolean flag = true;
		if(s1.length() != s2.length()) {
			System.out.println("Not Anagram");
			return;
		}
		List<Character> charList = new ArrayList<Character>();
		for(int i=0; i<s1.length(); i++) {
			charList.add(s1.charAt(i));
		}
		
		for(int i=0; i<s2.length(); i++) {
			if(!charList.contains(s2.charAt(i))) {
				flag = false;
			}
		}
		
		if(flag) {
			System.out.println("Anagram");
			return;
		}
		else {
			System.out.println("Not Anagram");
			return;
		}
		
	}
}

class Temp {
	int id;
	String name;
	public Temp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
}

