package com.practice.java.problemsolving;

public class NextHighest {

	public static void main(String[] args) {
		//Find out next highest element from given index.
		//Input   []  = {10, 3, 4,  6, 89, 98,  8, 21}
		//Output [] = 	{89, 4, 6, 89, 98, -1, 21, -1}
		
		int arr[]  = {10, 3, 4,  6, 89, 98,  8, 21};
		
		for(int i=0; i<arr.length; i++) {
			if(i==arr.length-1) { 
				System.out.println("-1"); 
			}
			for(int j=i+1; j<arr.length; j++) {
				if(j == arr.length-2) {
					System.out.println("-1");
				}
				if(arr[j] > arr[i] || arr[j+1] > arr[i]) {
					if(arr[j] > arr[i] && arr[j] < arr[j+1]) {
						System.out.println(arr[j]);
					}
					if(arr[j+1] > arr[i] && arr[j+1] < arr[j]) {
						System.out.println(arr[j+1]);
					}
					break;
				}
			}
		}
	}

}
