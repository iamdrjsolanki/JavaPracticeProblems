package com.practice.java.problemsolving;

import java.util.Scanner;

public class StarLadderPattern {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int i, k;
		int j = 0;
		int t1 = 1;
		int temp = input;
		if(input > 0) {
			while(temp > 0) {
				if(temp == input) {
					for(i = t1; i < (t1 + input); i++)
						System.out.print("\n*");		//initial ladder
				}
				else {
					for(k = t1; k < (t1 + (input-1)); k++) {
						System.out.println();
						for(i = 1; i < (t1 + input); i++) {
							if(i == (t1 + (input-1)))
								System.out.print("*");
							else
								System.out.print(" ");
						}
					}
					t1 = t1 + (input -1);
				}
				temp--;
				if(temp > 0) {
					for(j=1; j < input; j++)
						System.out.print("*");		//print star side ways
				}
				temp--;
			}
		}
	}
}
