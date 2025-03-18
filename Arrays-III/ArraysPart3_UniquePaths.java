package ArraysPart3;

import java.util.Scanner;

class ArraysPart3_UniquePaths{
    // Function to calculate the number of unique paths
    public static int uniquePaths(int m, int n){
        int N = n + m - 2; // Total steps (right + down)
        int r = m - 1; // Choose m-1 steps to go down
        double res = 1;

        // Compute the combination formula: C(N, r) = N! / (r! * (N-r)!)
        for(int i = 1; i <= r; i++){
            res = res * (N - r + i) / i;
        }

        return (int)res;
    }

    // Main function to take user input and display the result
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // Taking input for m and n
        System.out.print("Enter the number of rows (m): ");
        int m = scanner.nextInt();

        System.out.print("Enter the number of columns (n): ");
        int n = scanner.nextInt();

        int result = uniquePaths(m, n);

        // Display the result
        System.out.println("Number of unique paths: " + result);

        // Closing the scanner
        scanner.close();
    }
}
