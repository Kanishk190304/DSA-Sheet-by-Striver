package ArraysPart2;

import java.util.Scanner;

class ArraysPart2_RotateMatrix{
    // Function to rotate the matrix by 90 degrees clockwise
    public static void rotate(int[][] matrix){
        int n = matrix.length;
        // Transpose the matrix
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                swap(matrix, i, j);
            }
        }
        // Reverse each row
        for(int i = 0; i < n; i++){
            reverse(matrix[i]);
        }
    }

    // Helper function to swap elements
    public static void swap(int[][] matrix, int i, int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    // Helper function to reverse a row
    public static void reverse(int[] row){
        int left = 0;
        int right = row.length - 1;
        while(left < right){
            int temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the matrix (n x n):");
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        // Input matrix elements
        System.out.println("Enter the elements of the matrix:");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Rotate the matrix
        rotate(matrix);

        // Output the rotated matrix
        System.out.println("Rotated matrix:");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
