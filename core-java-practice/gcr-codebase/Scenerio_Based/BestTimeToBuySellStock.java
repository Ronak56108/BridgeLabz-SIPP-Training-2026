import java.util.Scanner;

/**
 * LeetCode Problem 3: Best Time to Buy and Sell Stock - Problem 121
 * 
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * Find the maximum profit you can achieve. You may complete at most one transaction
 * (buy one and sell one share of the stock).
 * 
 * Example 1: prices = [7,1,5,3,6,4] → Output: 5 (buy at 1, sell at 6)
 * Example 2: prices = [7,6,4,3,1] → Output: 0 (no profit possible)
 */
public class BestTimeToBuySellStock {
    
    /**
     * Find maximum profit using single pass approach
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        
        int minPrice = prices[0];
        int maxProfit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, profit);
            minPrice = Math.min(minPrice, prices[i]);
        }
        
        return maxProfit;
    }
    
    /**
     * Get buy and sell days for maximum profit
     */
    public static int[] getBuySellDays(int[] prices) {
        if (prices == null || prices.length < 2) {
            return new int[]{-1, -1};
        }
        
        int minPrice = prices[0];
        int minDay = 0;
        int maxProfit = 0;
        int buyDay = -1, sellDay = -1;
        
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - minPrice;
            
            if (profit > maxProfit) {
                maxProfit = profit;
                buyDay = minDay;
                sellDay = i;
            }
            
            if (prices[i] < minPrice) {
                minPrice = prices[i];
                minDay = i;
            }
        }
        
        return new int[]{buyDay, sellDay};
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter number of days: ");
            int days = scanner.nextInt();
            
            if (days < 1) {
                throw new IllegalArgumentException("Number of days must be positive");
            }
            
            int[] prices = new int[days];
            System.out.println("Enter stock prices for each day:");
            
            for (int i = 0; i < days; i++) {
                System.out.print("Day " + (i + 1) + " price: ");
                prices[i] = scanner.nextInt();
                
                if (prices[i] < 0) {
                    throw new IllegalArgumentException("Price cannot be negative");
                }
            }
            
            int profit = maxProfit(prices);
            int[] days_info = getBuySellDays(prices);
            
            System.out.println("\nMaximum profit: ₹" + profit);
            
            if (days_info[0] != -1) {
                System.out.println("Buy on day " + (days_info[0] + 1) + " at ₹" + prices[days_info[0]]);
                System.out.println("Sell on day " + (days_info[1] + 1) + " at ₹" + prices[days_info[1]]);
            } else {
                System.out.println("No profitable transaction possible");
            }
            
            // Test cases
            System.out.println("\n--- Test Cases ---");
            
            int[] test1 = {7, 1, 5, 3, 6, 4};
            System.out.println("Test 1: [7, 1, 5, 3, 6, 4]");
            System.out.println("Maximum profit: ₹" + maxProfit(test1));
            
            int[] test2 = {7, 6, 4, 3, 1};
            System.out.println("\nTest 2: [7, 6, 4, 3, 1]");
            System.out.println("Maximum profit: ₹" + maxProfit(test2));
            
            int[] test3 = {2, 4, 1, 7, 5, 11};
            System.out.println("\nTest 3: [2, 4, 1, 7, 5, 11]");
            System.out.println("Maximum profit: ₹" + maxProfit(test3));
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter valid integers.");
        } finally {
            scanner.close();
        }
    }
}
