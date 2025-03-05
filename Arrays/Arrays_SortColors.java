package Arrays;

import java.util.Scanner;

public class Arrays_SortColors{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements (0, 1, or 2):");
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }
        Arrays_SortColors solution = new Arrays_SortColors();
        solution.sortColors(nums);
        System.out.println("Sorted array:");
        for(int num : nums){
            System.out.print(num + " ");
        }
        scanner.close();
    }

    public void sortColors(int[] nums){
        int n = nums.length;
        int low = 0, mid = 0, high = n - 1;
        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums, low, mid);
                mid++;
                low++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
