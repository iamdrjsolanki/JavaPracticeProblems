package com.practice.java.problemsolving;

/*
  Given a n x n matrix. The problem is to sort the matrix row-wise and column wise.
  Input : mat[][] = { {4, 1, 3},
                      {9, 6, 8},
                      {5, 2, 7} }
  Output : 1 3 4
           2 5 7
           6 8 9

  Input : mat[][] = { {12, 7, 1, 8},
                      {20, 9, 11, 2},
                      {15, 4, 5, 13},
                      {3, 18, 10, 6} } 
  Output : 1 5 8 12
           2 6 10 15
           3 7 11 18
           4 9 13 20

*/
public class Sort2DArray {
	
  public static void main(String[] args) {
    // Test case 1
    int mat[][] = { { 4, 1, 3 },
                    { 9, 6, 8 },
                    { 5, 2, 7 } };
    int n = 3;

    System.out.print("Original Matrix:\n");
    printMatrix(mat, n);

    // Sort matrix
    sortMatrix(mat, n);

    System.out.print("\nMatrix After Sorting:\n");
    printMatrix(mat, n);
    
    
    // Test case 2
    int mat1[][] = { {12, 7, 1, 8},
                  {20, 9, 11, 2},
                  {15, 4, 5, 13},
                  {3, 18, 10, 6} };
    int n1 = 4;

    System.out.print("Original Matrix:\n");
    printMatrix(mat1, n1);

    // Sort matrix
    sortMatrix(mat1, n1);

    System.out.print("\nMatrix After Sorting:\n");
    printMatrix(mat1, n1);
  }
  
  // function to print the matrix
  private static void printMatrix(int mat[][], int n) {
      for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++)
              System.out.print(mat[i][j] + " ");
          System.out.println();
      }
  }
  
  //used Bubble sort, time complexity is 2n^3. Can be introduced another sorting algo which reduces the time
  public static void sortMatrix(int mat[][], int n) {
      int[][] temp = new int[1][1];
      for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++){
          for(int k=0; k<n; k++){
            if(mat[i][j] < mat[i][k]) {
              temp[0][0] = mat[i][j];
              mat[i][j] = mat[i][k];
              mat[i][k] = temp[0][0];
            }
          }
        }
      }
    
      for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
          for(int k=0; k<n; k++){
            if(mat[j][i] < mat[k][i]) {
              temp[0][0] = mat[j][i];
              mat[j][i] = mat[k][i];
              mat[k][i] = temp[0][0];
            }
          }
        }
      }
    }
}
