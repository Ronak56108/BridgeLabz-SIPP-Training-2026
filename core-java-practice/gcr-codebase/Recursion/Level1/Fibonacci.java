package recursion.level2;

/**
 * Generate Fibonacci Sequence
 * 
 * Description:
 * Write a recursive function to calculate the Nth Fibonacci number.
 * 
 * Input: 6
 * Output: 8 (Fibonacci sequence: 0, 1, 1, 2, 3, 5, 8)
 * 
 * Approach:
 * - Base case: if n <= 0 return 0, if n == 1 return 1
 * - Recursive case: fib(n) = fib(n-1) + fib(n-2)
 * 
 * Time Complexity: O(2^N) - exponential (simple implementation for learning)
 * Space Complexity: O(N) - due to recursion stack
 */
public class Fibonacci {
    
    public static int fibonacci(int n) {
        // Base cases
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        
        // Recursive case: fib(n) = fib(n-1) + fib(n-2)
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    public static void main(String[] args) {
        System.out.println("Generate Fibonacci Sequence");
        
        System.out.println("Fibonacci numbers:");
        for (int i = 0; i <= 10; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
        
        System.out.println("\nSpecific test:");
        System.out.println("fibonacci(6) = " + fibonacci(6));
        System.out.println("fibonacci(8) = " + fibonacci(8));
    }
}
