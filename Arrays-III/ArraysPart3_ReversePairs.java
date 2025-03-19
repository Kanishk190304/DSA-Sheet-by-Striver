package ArraysPart3;

import java.util.*;

class ArraysPart3_ReversePairs {
    // Merge function to merge two sorted halves
    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // Temporary array
        int left = low;      // Starting index for left subarray
        int right = mid + 1; // Starting index for right subarray

        // Merging two sorted halves
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // Copy remaining elements from left subarray
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        // Copy remaining elements from right subarray
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // Copy merged elements back into original array
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    // Function to count reverse pairs
    public static int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int cnt = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && (long) arr[i] > 2L * arr[right]) right++;
            cnt += (right - (mid + 1));
        }
        return cnt;
    }

    // Merge Sort function that counts reverse pairs
    public static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high) return cnt;
        int mid = (low + high) / 2;

        // Recursively sort left and right halves
        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid + 1, high);

        // Count important reverse pairs
        cnt += countPairs(arr, low, mid, high);

        // Merge the sorted halves
        merge(arr, low, mid, high);

        return cnt;
    }

    // Function to find reverse pairs
    public int reversePairs(int[] nums) {
        int n = nums.length;
        return mergeSort(nums, 0, n - 1);
    }

    // Main function for user input and execution
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        ArraysPart3_ReversePairs solution = new ArraysPart3_ReversePairs();
        int result = solution.reversePairs(nums);

        System.out.println("Number of reverse pairs: " + result);

        scanner.close();
    }
}
