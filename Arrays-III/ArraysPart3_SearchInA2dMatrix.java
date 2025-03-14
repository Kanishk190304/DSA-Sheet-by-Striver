package ArraysPart3;

import java.util.*;

public class ArraysPart3_SearchInA2dMatrix{

    // Function to search for a target value in a matrix
    public boolean searchMatrix(int[][] matrix, int target){
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = (n * m) - 1;

        // Binary search in a 2D matrix
        while(low <= high){
            int mid = (low + high) / 2;
            int row = mid / n;
            int col = mid % n;

            if(matrix[row][col] == target){
                return true; // Target found
            }
            else if(matrix[row][col] < target){
                low = mid + 1; // Search right half
            }
            else{
                high = mid - 1; // Search left half
            }
        }
        return false; // Target not found
    }

    // Main function to handle user input and output
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows in the matrix: ");
        int m = scanner.nextInt();
        System.out.println("Enter the number of columns in the matrix: ");
        int n = scanner.nextInt();

        int[][] matrix = new int[m][n];
        System.out.println("Enter the elements of the matrix: ");
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter the target value to search: ");
        int target = scanner.nextInt();

        ArraysPart3_SearchInA2dMatrix solution = new ArraysPart3_SearchInA2dMatrix();
        boolean found = solution.searchMatrix(matrix, target);

        if(found){
            System.out.println("Target found in the matrix.");
        }
        else{
            System.out.println("Target not found in the matrix.");
        }

        scanner.close();
    }
}

