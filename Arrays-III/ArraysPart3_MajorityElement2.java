package ArraysPart3;

import java.util.*;

class Solution1 {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = nums.length;

        int count1 = 0, count2 = 0; // Counters for two potential majority elements
        int e1 = Integer.MIN_VALUE, e2 = Integer.MIN_VALUE; // Variables to store potential elements

        // First pass: Finding potential majority elements using Boyer-Moore Voting Algorithm
        for (int i = 0; i < n; i++) {
            if (count1 == 0 && nums[i] != e2) { // Assign e1 if count1 is 0 and not equal to e2
                count1 = 1;
                e1 = nums[i];
            } else if (count2 == 0 && nums[i] != e1) { // Assign e2 if count2 is 0 and not equal to e1
                count2 = 1;
                e2 = nums[i];
            } else if (nums[i] == e1) { // Increment count1 if nums[i] matches e1
                count1++;
            } else if (nums[i] == e2) { // Increment count2 if nums[i] matches e2
                count2++;
            } else { // Decrement both counters if nums[i] matches neither
                count1--;
                count2--;
            }
        }

        // Reset counters to verify the actual occurrences
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == e1) count1++;
            if (nums[i] == e2) count2++;
        }

        // Minimum count required for an element to be a majority element (more than n/3 times)
        int min = (int) (n / 3) + 1;
        if (count1 >= min) {
            ans.add(e1);
        }
        if (count2 >= min && e1 != e2) { // Ensure e1 and e2 are not the same before adding
            ans.add(e2);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Solution1 solution = new Solution1();
        List<List<Integer>> result = Collections.singletonList(solution.majorityElement(nums));

        System.out.println("Majority elements (appearing more than n/3 times): " + result);

        sc.close();
    }
}