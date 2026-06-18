import java.util.Scanner;

/**
 * LeetCode Problem 1: Sqrt(x) - Problem 69
 * 
 * Given a non-negative integer x, compute and return the square root of x.
 * Since the returned integer's square root must be the floor of the real square root.
 * 
 * Example 1: Input: x = 4, Output: 2
 * Example 2: Input: x = 8, Output: 2 (floor of sqrt(8) = 2.82...)
 */
public class Sqrt_X {
    
    /**
     * Calculate square root using binary search
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static int mySqrt(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        
        long left = 1, right = x;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return (int) right; // Return floor of square root
    }
    
    /**
     * Newton's method approach
     */
    public static int mySqrtNewton(int x) {
        if (x < 2) return x;
        
        long num = x;
        while (num * num > x) {
            num = (num + x / num) / 2;
        }
        
        return (int) num;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter a non-negative integer: ");
            int x = scanner.nextInt();
            
            if (x < 0) {
                throw new IllegalArgumentException("Input must be non-negative");
            }
            
            int result = mySqrt(x);
            System.out.println("Square root of " + x + " is: " + result);
            System.out.println("Verification: " + result + "² = " + (result * result));
            
            // Test cases
            System.out.println("\n--- Test Cases ---");
            System.out.println("sqrt(4) = " + mySqrt(4));
            System.out.println("sqrt(8) = " + mySqrt(8));
            System.out.println("sqrt(1) = " + mySqrt(1));
            System.out.println("sqrt(0) = " + mySqrt(0));
            System.out.println("sqrt(2147395600) = " + mySqrt(2147395600));
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter a valid integer.");
        } finally {
            scanner.close();
        }
    }
}
