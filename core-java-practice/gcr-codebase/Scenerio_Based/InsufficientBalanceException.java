/**
 * Custom Exception for ATM System
 * Thrown when account balance is insufficient for withdrawal
 */
public class InsufficientBalanceException extends Exception {
    
    private double requiredAmount;
    private double availableBalance;
    
    public InsufficientBalanceException(double requiredAmount, double availableBalance) {
        super("Insufficient balance! Required: ₹" + requiredAmount + 
              ", Available: ₹" + availableBalance);
        this.requiredAmount = requiredAmount;
        this.availableBalance = availableBalance;
    }
    
    public double getRequiredAmount() {
        return requiredAmount;
    }
    
    public double getAvailableBalance() {
        return availableBalance;
    }
    
    public double getShortfall() {
        return requiredAmount - availableBalance;
    }
}
