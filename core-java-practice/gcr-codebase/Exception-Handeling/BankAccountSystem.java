import java.util.Scanner;

/**
 * Problem 10: Bank Transaction System (Checked + Custom Exception)
 * 
 * Develop a Bank Account System where:
 * - withdraw(double amount) method throws InsufficientBalanceException 
 *   if withdrawal amount exceeds balance.
 * - Throws IllegalArgumentException if the amount is negative.
 */
public class BankAccountSystem {
    
    private double balance;
    private String accountHolder;
    
    /**
     * Constructor to initialize bank account
     * @param accountHolder the name of the account holder
     * @param initialBalance the initial balance
     */
    public BankAccountSystem(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }
    
    /**
     * Deposits money into the account
     * @param amount the amount to deposit
     * @throws IllegalArgumentException if amount is negative
     */
    public void deposit(double amount) throws IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }
        balance += amount;
        System.out.println("Deposit successful, new balance: " + balance);
    }
    
    /**
     * Withdraws money from the account
     * @param amount the amount to withdraw
     * @throws IllegalArgumentException if amount is negative
     * @throws InsufficientBalanceException if balance is insufficient
     */
    public void withdraw(double amount) 
            throws IllegalArgumentException, InsufficientBalanceException {
        
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }
        
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        
        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }
    
    /**
     * Gets the current balance
     * @return the current balance
     */
    public double getBalance() {
        return balance;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        
        BankAccountSystem account = new BankAccountSystem(name, initialBalance);
        
        boolean running = true;
        while (running) {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            
            int choice = scanner.nextInt();
            
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        break;
                        
                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                        break;
                        
                    case 3:
                        System.out.println("Current balance: " + account.getBalance());
                        break;
                        
                    case 4:
                        running = false;
                        System.out.println("Thank you!");
                        break;
                        
                    default:
                        System.out.println("Invalid option!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid amount!");
            } catch (InsufficientBalanceException e) {
                System.out.println("Insufficient balance!");
            }
        }
        
        scanner.close();
    }
}
