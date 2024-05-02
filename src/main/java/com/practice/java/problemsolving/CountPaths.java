package com.practice.java.problemsolving;

/*

2D-ARRAY

0,0

	(ENTRY) 1 1 0 0 0 0 
            1 1 1 0 0 0
            0 1 1 1 1 1
            0 0 0 1 0 1 (EXIT)
            
3,5

int[][]
Number of paths -> 4

*/

public class CountPaths {

	static int n = 6, m = 5;
	static int[][] arr = { { 1, 1, 0, 0, 0, 0 },
					{ 1, 1, 1, 0, 0, 0 },
					{ 0, 1, 1, 1, 1, 1 },
					{ 0, 0, 0, 1, 0, 1 }
					};
	static int counter = 0;

	public static void main(String[] args) {
		countPaths();
	}
	
	static void countPaths() {
		for(int i=0; i<n; i++) {
		    for(int j=0; j<m; j++) {
		        checkNext(i, j);
		    }
		}
	}

	static int checkNext(int i, int j) {
	    if(arr[i][j+1] == 1) {
	        if(i== n && j==m) {
	            return counter++;
	        } else {
	            if(i==n) {
	                return checkNext(i+1, j);
	            } else {
	                return checkNext(i, j+1);
	            } 
	        }
	    } else if(arr[i+1][j] == 1) {
	        return checkNext(i+1, j);
	    } else { return -1;}
	}

}
