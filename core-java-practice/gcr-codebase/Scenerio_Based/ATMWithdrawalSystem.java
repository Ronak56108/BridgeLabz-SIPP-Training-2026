import java.util.Scanner;

/**
 * Problem 2: ATM Withdrawal System
 * 
 * A customer attempts to withdraw money.
 * Account balance = ₹5,000
 * Withdrawal request = ₹8,000
 * 
 * Create InsufficientBalanceException with proper information handling.
 */
public class ATMWithdrawalSystem {
    
    private double accountBalance;
    private String accountHolder;
    private String accountNumber;
    
    public ATMWithdrawalSystem(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.accountBalance = initialBalance;
    }
    
    /**
     * Withdraw money from account
     * @param amount the amount to withdraw
     * @throws InsufficientBalanceException if balance is insufficient
     */
    public void withdraw(double amount) throws InsufficientBalanceException {
        
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        
        if (amount > accountBalance) {
            throw new InsufficientBalanceException(amount, accountBalance);
        }
        
        accountBalance -= amount;
        System.out.println("✓ Withdrawal successful!");
        System.out.println("  Amount withdrawn: ₹" + amount);
        System.out.println("  Remaining balance: ₹" + accountBalance);
    }
    
    /**
     * Deposit money into account
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Deposit amount must be positive");
            return;
        }
        
        accountBalance += amount;
        System.out.println("✓ Deposit successful!");
        System.out.println("  Amount deposited: ₹" + amount);
        System.out.println("  New balance: ₹" + accountBalance);
    }
    
    /**
     * Check account balance
     */
    public void checkBalance() {
        System.out.println("\n--- Account Information ---");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: ₹" + accountBalance);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Create ATM with initial balance of ₹5,000
        ATMWithdrawalSystem atm = new ATMWithdrawalSystem("1234567890", "Raj Kumar", 5000);
        
        boolean running = true;
        while (running) {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            
            int choice = scanner.nextInt();
            
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter withdrawal amount (₹): ");
                        double withdrawAmount = scanner.nextDouble();
                        atm.withdraw(withdrawAmount);
                        break;
                        
                    case 2:
                        System.out.print("Enter deposit amount (₹): ");
                        double depositAmount = scanner.nextDouble();
                        atm.deposit(depositAmount);
                        break;
                        
                    case 3:
                        atm.checkBalance();
                        break;
                        
                    case 4:
                        running = false;
                        System.out.println("Thank you for using our ATM. Goodbye!");
                        break;
                        
                    default:
                        System.out.println("Invalid option! Please try again.");
                }
            } catch (InsufficientBalanceException e) {
                System.out.println("\n✗ Withdrawal Failed!");
                System.out.println("  Message: " + e.getMessage());
                System.out.println("  Shortfall: ₹" + e.getShortfall());
                System.out.println("  Please enter a smaller amount or deposit money first.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: Invalid input. Please enter valid numbers.");
                scanner.nextLine(); // Clear invalid input
            }
        }
        
        scanner.close();
    }
}
