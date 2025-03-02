package Arrays;

import java.util.*;

public class Arrays_PascalsTriangle {

    // Generates Pascal's Triangle up to a given number of rows
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= numRows; i++){
            ans.add(generateRow(i));
        }
        return ans;
    }

    // Generates a specific row of Pascal's Triangle
    public List<Integer> generateRow(int row){
        int ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(ans);
        for (int col = 1; col < row; col++){
            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add(ans);
        }
        return ansRow;
    }

    // Main method to test the triangle generation
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Arrays_PascalsTriangle solution = new Arrays_PascalsTriangle();
        System.out.print(" Enter no. of rows : ");
        System.out.println();
        int numRows = sc.nextInt(); // Number of rows to generate

        List<List<Integer>> triangle = solution.generate(numRows);

        // Print the generated triangle
        for (List<Integer> row : triangle){
            System.out.println(row);
        }
    }
}
