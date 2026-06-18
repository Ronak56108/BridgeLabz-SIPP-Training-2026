import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Problem 2: Unchecked Exception (Runtime Exception)
 * 
 * Write a Java program that asks the user to enter two numbers and divides them.
 * Handle ArithmeticException if division by zero occurs.
 * Handle InputMismatchException if the user enters a non-numeric value.
 */
public class DivisionAndInputException {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();
            
            if (num2 == 0) {
                throw new ArithmeticException("Cannot divide by zero");
            }
            
            double result = num1 / num2;
            System.out.println("Result: " + result);
            
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed");
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter valid numeric values");
        } finally {
            scanner.close();
        }
    }
}
