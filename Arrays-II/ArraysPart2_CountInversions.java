package ArraysPart2;

import java.util.*;

public class ArraysPart2_CountInversions {

    // Function to count the number of inversions in the array
    public static long getInversions(long arr[], int n){
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = (int)arr[i];
        }
        return mergeSort(a, 0, n - 1);
    }

    // Merge function to count inversions and sort the array
    private static int merge(int[] arr, int low, int mid, int high){
        ArrayList<Integer> temp = new ArrayList<>(); // Temporary array
        int left = low;      // Starting index of left half of arr
        int right = mid + 1; // Starting index of right half of arr
        int cnt = 0;         // Count of inversions

        // Merge the two halves while counting inversions
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
                cnt += (mid - left + 1); // Counting inversions
                right++;
            }
        }

        // Add remaining elements from the left half
        while(left <= mid){
            temp.add(arr[left]);
            left++;
        }

        // Add remaining elements from the right half
        while(right <= high){
            temp.add(arr[right]);
            right++;
        }

        // Copy the sorted elements back to the original array
        for(int i = low; i <= high; i++){
            arr[i] = temp.get(i - low);
        }
        return cnt;
    }

    // Recursive merge sort function
    public static int mergeSort(int[] arr, int low, int high){
        int cnt = 0;
        if(low >= high) return cnt;
        int mid = (low + high) / 2;
        cnt += mergeSort(arr, low, mid);       // Sort left half
        cnt += mergeSort(arr, mid + 1, high); // Sort right half
        cnt += merge(arr, low, mid, high);    // Merge and count inversions
        return cnt;
    }

    // Main function to take user input and display the result
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        long[] arr = new long[n];
        System.out.println("Enter the elements of the array: ");
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextLong();
        }

        long inversions = getInversions(arr, n);
        System.out.println("Number of inversions in the array: " + inversions);

        scanner.close();
    }
}

