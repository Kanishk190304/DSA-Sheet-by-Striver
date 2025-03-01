package Arrays;

import java.util.*;

class Solution{

    // Function to set matrix rows and columns to zero
    public void setZeroes(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int col0 = matrix[0][0];

        // First pass to mark rows and columns for zeroing
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    if(j != 0){
                        matrix[0][j] = 0;
                    }
                    else{
                        col0 = 0;
                    }
                }
            }
        }

        // Second pass to set elements to zero based on markers
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] != 0){
                    if(matrix[i][0] == 0 || matrix[0][j] == 0){
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        // Handle the first row
        if(matrix[0][0] == 0){
            Arrays.fill(matrix[0], 0);
        }

        // Handle the first column
        if(col0 == 0){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        // Input matrix dimensions
        System.out.print("Enter number of rows: ");
        int m = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int n = scanner.nextInt();

        int[][] matrix = new int[m][n];

        // Input matrix elements
        System.out.println("Enter matrix elements:");
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = scanner.nextInt();
            }
        }

        Solution solution = new Solution();
        solution.setZeroes(matrix);

        // Print the updated matrix
        System.out.println("Matrix after setting zeroes:");
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
