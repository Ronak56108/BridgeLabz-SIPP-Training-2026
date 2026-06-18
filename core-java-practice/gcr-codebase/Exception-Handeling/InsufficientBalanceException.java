/**
 * Custom Exception for Insufficient Balance
 * Used in Problem 10: Bank Transaction System
 */
public class InsufficientBalanceException extends Exception {
    
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
