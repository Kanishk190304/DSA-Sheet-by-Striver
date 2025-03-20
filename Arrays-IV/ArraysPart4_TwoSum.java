package ArraysPart4;

import java.util.HashMap;
import java.util.Scanner;

class ArraysPart4_TwoSum {
    // Function to find two indices that add up to the target
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = ans[1] = -1; // Default values if no solution is found

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int need = target - num;
            // Check if the needed number exists in the map
            if (map.containsKey(need)) {
                ans[0] = map.get(need);
                ans[1] = i;
                return ans;
            }
            // Store the current number with its index
            map.put(nums[i], i);
        }
        return ans; // Return the indices or -1, -1 if not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for the array size
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        // Taking input for the array elements
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Taking input for the target sum
        System.out.print("Enter the target sum: ");
        int target = scanner.nextInt();

        // Creating an instance of ArraysPart4_TwoSum
        ArraysPart4_TwoSum solution = new ArraysPart4_TwoSum();
        int[] result = solution.twoSum(nums, target);

        // Printing the result
        if (result[0] != -1) {
            System.out.println("Indices: " + result[0] + " and " + result[1]);
        } else {
            System.out.println("No two numbers add up to the target.");
        }

        scanner.close();
    }
}
