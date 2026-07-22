public class BankAccountDemo {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("A001", "Alice", 1000.0);
        BankAccount account2 = new BankAccount("A002", "Bob", 2000.0);
        BankAccount account3 = new BankAccount("A003", "Charlie", 1500.0);

        account1.deposit(500);
        account1.withdraw(300);
        account1.withdraw(1500);
        account1.deposit(200);
        account1.withdraw(100);

        account2.withdraw(250);
        account2.deposit(1000);
        account2.withdraw(3000);
        account2.deposit(150);
        account2.withdraw(100);

        account3.deposit(250);
        account3.withdraw(100);
        account3.withdraw(500);
        account3.deposit(1000);
        account3.withdraw(200);

        System.out.println();
        account1.getStatement();
        System.out.println();
        account2.getStatement();
        System.out.println();
        account3.getStatement();

        System.out.println();
        System.out.println("Total accounts created: " + BankAccount.getTotalAccounts());
    }
}

class BankAccount {
    private String accountNumber;
    private String holder;
    private double balance;
    private static int totalAccounts = 0;

    public BankAccount(String accountNumber, String holder, double balance) {
        this.accountNumber = accountNumber;
        this.holder = holder;
        this.balance = balance;
        totalAccounts++;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(holder + " deposited " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (amount > balance) {
            System.out.println("Overdraft prevented for " + holder + ". Requested: " + amount + ", available: " + balance);
        } else {
            balance -= amount;
            System.out.println(holder + " withdrew " + amount + ". Remaining balance: " + balance);
        }
    }

    public void getStatement() {
        System.out.println("Account Statement for " + holder + ":");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holder);
        System.out.println("Balance: " + balance);
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }
}
