/**
 * Custom Exception for Hospital Billing System
 * Thrown when there are insufficient funds for payment
 */
public class InsufficientFundsException extends Exception {
    
    public InsufficientFundsException(String message) {
        super(message);
    }
    
    public InsufficientFundsException(String message, Throwable cause) {
        super(message, cause);
    }
}
