package com.practice.java.problemsolving;

//Find missing numbers from given sequential positive integers.
//1,2,3,4,6,7,8,9

//Approach to create the new array with the total size i.e. last ele - first ele
//put the elements in the index
//print null index

public class Test1234 {
	
	public static void main(String a[]) {
		int arr[] = {1,2,3,4,8,9};
		int count=arr[0];
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == count) {
				count++;
			} else {
				System.out.println(count);
				count+=2;
			}
		}
		
		
		
	}

}
