package ArraysPart4;

import java.util.*;
import java.io.*;

public class ArraysPart4_LargestSubarrayWithSumK {

    // Function to find the length of the longest subarray with sum K
    public static int getLongestSubarray(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>(); // Stores prefix sum and its first occurrence index
        int sum = 0;
        int maxLen = 0;

        // Initialize map with sum 0 at index -1
        map.put(0, -1);

        for (int i = 0; i < n; i++) {
            sum += nums[i]; // Update the cumulative sum

            // Check if the sum itself equals k
            if (sum == k) {
                maxLen = i + 1;
            }

            int rem = sum - k; // Calculate the remaining sum needed

            // If rem exists in map, update maxLen
            if (map.containsKey(rem)) {
                maxLen = Math.max(maxLen, i - map.get(rem));
            }

            // Store the first occurrence of sum
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;
    }

    // Main function to handle user input and call the getLongestSubarray function
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for array size
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        // Taking input for array elements
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Taking input for target sum K
        System.out.print("Enter the target sum K: ");
        int k = scanner.nextInt();

        // Calling the function and displaying the result
        int result = getLongestSubarray(nums, k);
        System.out.println("Length of the longest subarray with sum " + k + " is: " + result);

        scanner.close();
    }
}
