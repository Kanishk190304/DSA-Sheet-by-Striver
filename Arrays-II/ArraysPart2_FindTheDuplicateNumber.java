package ArraysPart2;

import java.util.*;

public class ArraysPart2_FindTheDuplicateNumber{

    // Function to find the duplicate number in an array
    public int findDuplicate(int[] nums){
        int slow = nums[0];
        int fast = nums[0];

        // Use Floyd's cycle detection algorithm
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        // Find the entry point of the cycle
        fast = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    // Main function to handle user input and output
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements of the array: ");
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }

        ArraysPart2_FindTheDuplicateNumber solution = new ArraysPart2_FindTheDuplicateNumber();
        int duplicate = solution.findDuplicate(nums);
        System.out.println("The duplicate number is: " + duplicate);

        scanner.close();
    }
}

