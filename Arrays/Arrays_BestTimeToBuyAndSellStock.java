package Arrays;

import java.util.Scanner;

public class Arrays_BestTimeToBuyAndSellStock{

    // Method to calculate the maximum profit
    public int maxProfit(int[] prices){
        int n = prices.length;
        int maxProfit = 0;
        int minPrice = prices[0];

        // Iterate through the array to find the maximum profit
        for (int i = 0; i < n; i++){
            int profit = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, profit);
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of days:");
        int n = scanner.nextInt();

        int[] prices = new int[n];
        System.out.println("Enter the stock prices:");

        for (int i = 0; i < n; i++){
            prices[i] = scanner.nextInt();
        }

        Arrays_BestTimeToBuyAndSellStock solution = new Arrays_BestTimeToBuyAndSellStock();
        int maxProfit = solution.maxProfit(prices);

        System.out.println("Maximum Profit: " + maxProfit);

        scanner.close();
    }
}
