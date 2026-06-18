import java.util.Scanner;

/**
 * Problem 6: throw vs. throws (Exception Propagation)
 * 
 * Create a method calculateInterest(double amount, double rate, int years) that:
 * - Throws IllegalArgumentException if amount or rate is negative.
 * - Propagates the exception using throws and handles it in main().
 */
public class InterestCalculation {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter principal amount: ");
            double amount = scanner.nextDouble();
            
            System.out.print("Enter interest rate (%): ");
            double rate = scanner.nextDouble();
            
            System.out.print("Enter number of years: ");
            int years = scanner.nextInt();
            
            double interest = calculateInterest(amount, rate, years);
            System.out.println("Simple Interest: " + interest);
            
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: Amount and rate must be positive");
        } finally {
            scanner.close();
        }
    }
    
    /**
     * Calculates simple interest
     * @param amount the principal amount
     * @param rate the interest rate
     * @param years the number of years
     * @return the calculated interest
     * @throws IllegalArgumentException if amount or rate is negative
     */
    public static double calculateInterest(double amount, double rate, int years) 
            throws IllegalArgumentException {
        
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Amount and rate must be positive");
        }
        
        return (amount * rate * years) / 100;
    }
}
