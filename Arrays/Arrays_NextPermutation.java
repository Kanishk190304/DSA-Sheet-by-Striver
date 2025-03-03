package Arrays;

import java.util.*;

public class Arrays_NextPermutation {

    // Finds the next lexicographical permutation
    public void nextPermutation(int[] nums){
        int n = nums.length;
        int ind = -1;

        // Find the first decreasing element from the end
        for(int i = n - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                ind = i;
                break;
            }
        }

        // If no such element, reverse the array
        if(ind == -1){
            reverse(nums, 0, n - 1);
            return;
        }

        // Find the element just larger than nums[ind]
        for(int i = n - 1; i >= 0; i--){
            if(nums[i] > nums[ind]){
                swap(nums, i, ind);
                break;
            }
        }

        // Reverse the elements to the right of ind
        reverse(nums, ind + 1, n - 1);
    }

    // Swap elements at positions x and y
    public void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    // Reverse elements between left and right
    public void reverse(int[] nums, int left, int right){
        while(left < right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    // Main method to test nextPermutation
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Arrays_NextPermutation solution = new Arrays_NextPermutation();

        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }

        solution.nextPermutation(nums);
        System.out.println("Next permutation: " + Arrays.toString(nums));

        scanner.close();
    }
}
