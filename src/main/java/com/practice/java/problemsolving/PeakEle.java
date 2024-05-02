package com.practice.java.problemsolving;

public class PeakEle {
	
	//find the highest peak element in the array
	public static void main(String[] args) {
		int arr[] = { 100, 180, 260, 310, 40, 535, 695 };
		System.out.print(peakEle(arr));
	}
	
	static int peakEle(int[] arr) {
	    
		if(arr==null||arr.length<=1)
	        return 0;
	 
	    int peak=0; // peak so far
	 
	    for(int i=1; i<arr.length-1; i++){
	        if(arr[i] > arr[i-1] && arr[i] > arr[i+1]) {
	        	peak = arr[i];
	        }
	    }
	 
	    return peak;
	}

}
