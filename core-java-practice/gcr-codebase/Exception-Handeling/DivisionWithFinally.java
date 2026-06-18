import java.util.Scanner;

/**
 * Problem 7: finally Block Execution
 * 
 * Write a program that performs integer division and demonstrates 
 * the finally block execution.
 * - Ensure "Operation completed" is always printed using finally.
 */
public class DivisionWithFinally {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();
            
            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();
            
            if (num2 == 0) {
                throw new ArithmeticException("Cannot divide by zero");
            }
            
            int result = num1 / num2;
            System.out.println("Result: " + result);
            
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero");
        } finally {
            System.out.println("Operation completed");
        }
    }
}
