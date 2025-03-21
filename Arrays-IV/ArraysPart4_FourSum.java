package ArraysPart4;

import java.util.*;

class ArraysPart4_FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // Sort the input array
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        // Iterate through the array with two pointers
        for (int i = 0; i < n; i++) {
            // Avoid duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n; j++) {
                // Avoid duplicate values for j
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l]; // Using long to avoid overflow

                    if (sum == target) {
                        // Store the valid quadruplet
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;

                        // Skip duplicate values for k and l
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < target) {
                        k++; // Move right pointer to increase sum
                    } else {
                        l--; // Move left pointer to decrease sum
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Enter the target sum:");
        int target = scanner.nextInt();

        ArraysPart4_FourSum solution = new ArraysPart4_FourSum();
        List<List<Integer>> result = solution.fourSum(nums, target);

        System.out.println("Quadruplets with sum " + target + " are:");
        for (List<Integer> quad : result) {
            System.out.println(quad);
        }
    }
}
