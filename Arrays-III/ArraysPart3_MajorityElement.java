package ArraysPart3;

import java.util.Scanner;

class Solution{
    // Function to find the majority element
    public int majorityElement(int[] nums){
        int n = nums.length;
        int count = 0;
        int el = nums[0];

        // Moore's Voting Algorithm to find potential majority element
        for (int i = 0; i < n; i++){
            if(count == 0){
                el = nums[i];
                count = 1;
            }
            else if(nums[i] == el){
                count++;
            }
            else{
                count--;
            }
        }

        // Verifying if the found element is actually the majority element
        int c = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == el){
                c++;
            }
        }

        if(c > n / 2){
            return el;
        }
        return -1; // Return -1 if no majority element exists
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // Taking input from the user
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter the elements: ");
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }

        // Creating an instance of Solution and calling majorityElement method
        Solution solution = new Solution();
        int result = solution.majorityElement(nums);

        // Displaying the result
        if(result != -1){
            System.out.println("Majority Element: " + result);
        }
        else{
            System.out.println("No majority element found.");
        }

        scanner.close();
    }
}
