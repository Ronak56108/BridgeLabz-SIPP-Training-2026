import java.util.Scanner;

/**
 * Problem 1: Hospital Billing System
 * 
 * A hospital billing system must never crash. Wrap division-by-zero
 * (bills with zero items), array out-of-bounds (invalid patient index),
 * and number format exceptions (bad input) with meaningful messages.
 * Create a custom InsufficientFundsException for payment failures.
 */
public class HospitalBillingSystem {
    
    private double[] patientBills;
    private String[] patientNames;
    
    public HospitalBillingSystem(int numberOfPatients) {
        this.patientBills = new double[numberOfPatients];
        this.patientNames = new String[numberOfPatients];
    }
    
    /**
     * Add patient to the system
     */
    public void addPatient(int index, String name, double billAmount) {
        try {
            if (billAmount < 0) {
                throw new IllegalArgumentException("Bill amount cannot be negative");
            }
            patientNames[index] = name;
            patientBills[index] = billAmount;
            System.out.println("Patient added: " + name + " | Bill: ₹" + billAmount);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid patient index " + index);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    /**
     * Calculate average bill amount
     */
    public void calculateAverageBill(int numberOfItems) {
        try {
            if (numberOfItems == 0) {
                throw new ArithmeticException("Cannot divide by zero items");
            }
            
            double totalBill = 0;
            for (double bill : patientBills) {
                totalBill += bill;
            }
            
            double averageBill = totalBill / numberOfItems;
            System.out.println("Average bill per item: ₹" + averageBill);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    /**
     * Process payment with exception handling
     */
    public void processPayment(int patientIndex, double paymentAmount) {
        try {
            if (patientIndex < 0 || patientIndex >= patientBills.length) {
                throw new ArrayIndexOutOfBoundsException("Invalid patient index");
            }
            
            if (paymentAmount < 0) {
                throw new NumberFormatException("Payment amount cannot be negative");
            }
            
            double billAmount = patientBills[patientIndex];
            
            if (paymentAmount < billAmount) {
                throw new InsufficientFundsException(
                    "Payment failed: Required ₹" + billAmount + 
                    ", but ₹" + paymentAmount + " provided"
                );
            }
            
            double change = paymentAmount - billAmount;
            System.out.println("Payment successful for " + patientNames[patientIndex]);
            System.out.println("Bill: ₹" + billAmount + " | Change: ₹" + change);
            patientBills[patientIndex] = 0; // Bill cleared
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid payment amount - " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HospitalBillingSystem hospital = new HospitalBillingSystem(5);
        
        // Add some patients
        hospital.addPatient(0, "John Doe", 5000);
        hospital.addPatient(1, "Jane Smith", 7500);
        hospital.addPatient(2, "Mike Johnson", 3000);
        
        System.out.println("\n--- Processing Payments ---");
        hospital.processPayment(0, 5000);  // Exact amount
        hospital.processPayment(1, 6000);  // Insufficient amount
        hospital.processPayment(2, 4000);  // Valid payment with change
        hospital.processPayment(5, 2000);  // Invalid index
        
        System.out.println("\n--- Calculating Average ---");
        hospital.calculateAverageBill(3);
        hospital.calculateAverageBill(0);  // Division by zero
        
        scanner.close();
    }
}
