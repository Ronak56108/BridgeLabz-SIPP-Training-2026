package recursion.level2;

/**
 * Sum of First N Natural Numbers
 * 
 * Description:
 * Find the sum of first N natural numbers using recursion.
 * 
 * Input: N = 5
 * Output: 15 (1+2+3+4+5)
 * 
 * Mathematical Formula: sum(n) = n*(n+1)/2
 * 
 * Approach:
 * - Base case: if n == 0, return 0
 * - Recursive case: sum(n) = n + sum(n-1)
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N) - due to recursion stack
 */
public class SumOfNNumbers {
    
    public static int sumOfNumbers(int n) {
        // Base case
        if (n == 0) {
            return 0;
        }
        
        // Recursive case: sum(n) = n + sum(n-1)
        return n + sumOfNumbers(n - 1);
    }
    
    public static void main(String[] args) {
        System.out.println("Sum of First N Natural Numbers");
        
        int n = 5;
        System.out.println("Sum of first " + n + " natural numbers: " + sumOfNumbers(n));
        
        n = 10;
        System.out.println("Sum of first " + n + " natural numbers: " + sumOfNumbers(n));
        
        n = 100;
        System.out.println("Sum of first " + n + " natural numbers: " + sumOfNumbers(n));
    }
}
