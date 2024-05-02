package com.practice.java.problemsolving;

public class PrimeNumbers {

	public static void main(String[] args) {
		for(int i=1; i<=10; i++) {
			boolean flag = true;
			for(int j=2; j<=Math.sqrt(i); j++) {
				if(i % j == 0) {
					flag = false;
					break;
				}
			}
			if(flag)
				System.out.println("The number " + i + " is a prime number.");
			else
				System.out.println("The number " + i + " is not a prime number.");
		}
	}
}
