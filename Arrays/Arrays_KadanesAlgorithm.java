package Arrays;

import java.util.Scanner;

public class Arrays_KadanesAlgorithm{

    // Function to find the maximum subarray sum using Kadane's Algorithm
    public int maxSubArray(int[] nums){
        int n = nums.length;
        if(n == 1) return nums[0]; // If array has only one element, return it

        int sum = 0;
        int max = nums[0];

        // Iterate through the array
        for(int i = 0; i < n; i++){
            sum += nums[i]; // Add current element to the sum

            // Update max if current sum is greater than max
            if(sum > max){
                max = sum;
            }

            // If sum becomes negative, reset it to zero
            if(sum < 0){
                sum = 0;
            }
        }
        return max; // Return the maximum subarray sum
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the number of elements in the array
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];

        // Take array elements as input
        System.out.println("Enter the elements of the array: ");
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }

        Arrays_KadanesAlgorithm solution = new Arrays_KadanesAlgorithm();

        // Find and print the maximum subarray sum
        int result = solution.maxSubArray(nums);
        System.out.println("The maximum subarray sum is: " + result);

        scanner.close();
    }
}
