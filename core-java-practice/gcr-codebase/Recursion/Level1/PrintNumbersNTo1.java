package recursion.level2;

/**
 * Print Numbers from N to 1
 * 
 * Description:
 * Write a recursive function to print numbers from N to 1.
 * 
 * Input: N = 5
 * Output: 5 4 3 2 1
 * 
 * Approach:
 * - Base case: if n == 0, return
 * - Print current number n
 * - Recursively call with n-1
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N) - due to recursion stack
 */
public class PrintNumbersNTo1 {
    
    public static void printNumbers(int n) {
        // Base case
        if (n == 0) {
            return;
        }
        
        // Print current number
        System.out.print(n + " ");
        
        // Recursive call
        printNumbers(n - 1);
    }
    
    public static void main(String[] args) {
        System.out.println("Print Numbers from N to 1");
        System.out.print("Output (N=5): ");
        printNumbers(5);
        System.out.println();
        
        System.out.print("Output (N=10): ");
        printNumbers(10);
        System.out.println();
    }
}
