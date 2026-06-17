package recursion.level2;

/**
 * Calculate Factorial
 * 
 * Description:
 * Write a recursive function to calculate the factorial of a number.
 * 
 * Input: 5
 * Output: 120
 * 
 * Formula: n! = n * (n-1) * (n-2) * ... * 1
 * 
 * Approach:
 * - Base case: if n == 0 or n == 1, return 1
 * - Recursive case: n! = n * (n-1)!
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N) - due to recursion stack
 */
public class Factorial {
    
    public static int factorial(int n) {
        // Base case
        if (n == 0 || n == 1) {
            return 1;
        }
        
        // Recursive case: n! = n * (n-1)!
        return n * factorial(n - 1);
    }
    
    public static void main(String[] args) {
        System.out.println("Calculate Factorial");
        
        for (int i = 0; i <= 6; i++) {
            System.out.println(i + "! = " + factorial(i));
        }
        
        System.out.println("\nSpecific test:");
        System.out.println("5! = " + factorial(5));
    }
}
