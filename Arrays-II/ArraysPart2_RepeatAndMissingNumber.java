package ArraysPart2;

import java.util.*;

public class ArraysPart2_RepeatAndMissingNumber{

    // Function to find the repeated and missing number in the array
    public int[] repeatedNumber(final int[] A){
        long n = A.length;
        long Sn = (n * (n + 1)) / 2;
        long S2n = (n * (n + 1) * (2 * n + 1)) / 6;
        long S = 0;
        long S2 = 0;

        // Calculate the sum and sum of squares of array elements
        for(int i = 0; i < n; i++){
            S += A[i];
            S2 += (long)A[i] * (long)A[i];
        }

        long val1 = S - Sn;
        long val2 = S2 - S2n;
        val2 = val2 / val1;

        long x = (val1 + val2) / 2;
        long y = x - val1;

        int[] ans = new int[2];
        ans[0] = (int)x; // Repeated number
        ans[1] = (int)y; // Missing number
        return ans;
    }

    // Main function to handle user input and output
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] A = new int[n];
        System.out.println("Enter the elements of the array: ");
        for(int i = 0; i < n; i++){
            A[i] = scanner.nextInt();
        }

        ArraysPart2_RepeatAndMissingNumber solution = new ArraysPart2_RepeatAndMissingNumber();
        int[] result = solution.repeatedNumber(A);

        System.out.println("Repeated number: " + result[0]);
        System.out.println("Missing number: " + result[1]);

        scanner.close();
    }
}

