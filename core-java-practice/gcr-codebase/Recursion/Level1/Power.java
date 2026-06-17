package recursion.level2;

/**
 * Calculate Power (x^n)
 * 
 * Description:
 * Write a recursive function to calculate x raised to power n (x^n).
 * 
 * Input: x = 2, n = 5
 * Output: 32 (2^5 = 2*2*2*2*2)
 * 
 * Input: x = 2, n = -3
 * Output: 0.125 (2^-3 = 1/8)
 * 
 * Approach:
 * - Base case: if n == 0, return 1
 * - Handle negative exponent: return 1 / power(x, -n)
 * - Recursive case: power(x, n) = x * power(x, n-1)
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N) - due to recursion stack
 */
public class Power {
    
    public static double power(int x, int n) {
        // Base case
        if (n == 0) {
            return 1;
        }
        
        // Handle negative exponent
        if (n < 0) {
            return 1.0 / power(x, -n);
        }
        
        // Recursive case: x^n = x * x^(n-1)
        return x * power(x, n - 1);
    }
    
    public static void main(String[] args) {
        System.out.println("Calculate Power (x^n)");
        
        System.out.println("Positive exponents:");
        System.out.println("2^5 = " + power(2, 5));
        System.out.println("3^4 = " + power(3, 4));
        System.out.println("5^3 = " + power(5, 3));
        
        System.out.println("\nZero exponent:");
        System.out.println("7^0 = " + power(7, 0));
        
        System.out.println("\nNegative exponents:");
        System.out.println("2^-3 = " + power(2, -3));
        System.out.println("10^-2 = " + power(10, -2));
    }
}
