package ArraysPart2;

import java.util.*;

public class ArraysPart2_MergeOverlappingSubintervals {

    // Function to merge overlapping intervals
    public int[][] merge(int[][] intervals){
        int n = intervals.length;

        // Sort intervals based on the start value
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });

        List<int[]> ans = new ArrayList<>();

        // Iterate through intervals and merge overlapping ones
        for (int i = 0; i < n; i++){
            if (ans.isEmpty() || intervals[i][0] > ans.get(ans.size() - 1)[1]){
                ans.add(new int[]{intervals[i][0], intervals[i][1]});
            }
            else{
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], intervals[i][1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    // Main function to handle user input and output
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of intervals: ");
        int n = scanner.nextInt();

        int[][] intervals = new int[n][2];

        System.out.println("Enter the intervals (start and end points):");
        for (int i = 0; i < n; i++){
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
        }

        ArraysPart2_MergeOverlappingSubintervals solution = new ArraysPart2_MergeOverlappingSubintervals();
        int[][] mergedIntervals = solution.merge(intervals);

        System.out.println("Merged intervals:");
        for (int[] interval : mergedIntervals){
            System.out.println(interval[0] + " " + interval[1]);
        }

        scanner.close();
    }
}
