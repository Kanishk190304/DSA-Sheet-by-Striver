package ArraysPart2;

import java.util.*;

public class ArraysPart2_MergeSortedArray {

    // Function to merge two sorted arrays
    public void merge(int[] nums1, int m, int[] nums2, int n){
        int i = m - 1;
        int j = n - 1;
        int k = n + m - 1;

        // Merge nums2 into nums1 starting from the end
        while (j >= 0){
            if (i >= 0 && nums1[i] >= nums2[j]){
                nums1[k--] = nums1[i--];
            }
            else{
                nums1[k--] = nums2[j--];
            }
        }
    }

    // Main function to handle user input and output
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of nums1 (including extra space for nums2): ");
        int mPlusN = scanner.nextInt();

        System.out.println("Enter the number of elements in nums1: ");
        int m = scanner.nextInt();

        System.out.println("Enter the elements of nums1: ");
        int[] nums1 = new int[mPlusN];
        for (int i = 0; i < m; i++){
            nums1[i] = scanner.nextInt();
        }

        System.out.println("Enter the number of elements in nums2: ");
        int n = scanner.nextInt();

        System.out.println("Enter the elements of nums2: ");
        int[] nums2 = new int[n];
        for (int i = 0; i < n; i++){
            nums2[i] = scanner.nextInt();
        }

        ArraysPart2_MergeSortedArray solution = new ArraysPart2_MergeSortedArray();
        solution.merge(nums1, m, nums2, n);

        System.out.println("Merged array: ");
        for (int num : nums1){
            System.out.print(num + " ");
        }

        scanner.close();
    }
}

