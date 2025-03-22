package ArraysPart4;

import java.util.HashSet;
import java.util.Scanner;

class ArraysPart4_LongestConsecutiveSequence {
    // Function to find the longest consecutive sequence in an array
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int longest = 1;
        HashSet<Integer> set = new HashSet<>();

        // Add all numbers to a HashSet for O(1) look-up time
        for (int num : nums) {
            set.add(num);
        }

        // Iterate through the set to find the longest consecutive sequence
        for (int num : set) {
            // Only check for a new sequence if 'num - 1' is not in the set
            if (!set.contains(num - 1)) {
                int count = 1;
                int x = num;

                // Count the consecutive numbers
                while (set.contains(x + 1)) {
                    count++;
                    x++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }

    // Main function to take user input and test the function
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Create an instance of ArraysPart4_LongestConsecutiveSequence and call longestConsecutive
        ArraysPart4_LongestConsecutiveSequence solution = new ArraysPart4_LongestConsecutiveSequence();
        int result = solution.longestConsecutive(nums);

        // Print the result
        System.out.println("Longest Consecutive Sequence Length: " + result);

        scanner.close();
    }
}
