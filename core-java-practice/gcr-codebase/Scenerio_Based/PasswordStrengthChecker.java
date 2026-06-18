import java.util.Scanner;

/**
 * Additional Problem 3: Password Strength Checker
 * 
 * A method checks whether a password is strong.
 * 
 * Password Rules:
 * 1. The first character must be uppercase.
 * 2. The last character must be a digit.
 * 3. Password length must be at least 8 characters.
 * 4. Password must contain at least one special character (@, #, $, %, &, *).
 * 
 * Scenario - The user may enter:
 * - An empty string ("")
 * - A password shorter than 8 characters
 * - A password without a special character
 * - A password whose first character is not uppercase
 * - A password whose last character is not a digit
 * - null
 * 
 * Task: Write a method checkPassword(String password) that:
 * - Validates all password rules
 * - Handles possible exceptions gracefully
 * - Displays meaningful error messages instead of crashing
 */
public class PasswordStrengthChecker {
    
    private static final String SPECIAL_CHARS = "@#$%&*";
    private static final int MIN_LENGTH = 8;
    
    /**
     * Custom Exception for Password Validation
     */
    public static class InvalidPasswordException extends Exception {
        public InvalidPasswordException(String message) {
            super(message);
        }
    }
    
    /**
     * Validate password strength with detailed error handling
     */
    public static boolean checkPassword(String password) throws InvalidPasswordException {
        
        // Handle null password
        if (password == null) {
            throw new InvalidPasswordException("Password cannot be null");
        }
        
        // Handle empty password
        if (password.isEmpty()) {
            throw new InvalidPasswordException("Password cannot be empty");
        }
        
        // Rule 3: Check length
        if (password.length() < MIN_LENGTH) {
            throw new InvalidPasswordException("Password must be at least " + MIN_LENGTH + 
                                             " characters long. Current length: " + 
                                             password.length());
        }
        
        // Rule 1: Check first character is uppercase
        if (!Character.isUpperCase(password.charAt(0))) {
            throw new InvalidPasswordException("First character must be uppercase. " +
                                             "You entered: '" + password.charAt(0) + "'");
        }
        
        // Rule 2: Check last character is digit
        if (!Character.isDigit(password.charAt(password.length() - 1))) {
            throw new InvalidPasswordException("Last character must be a digit. " +
                                             "You entered: '" + 
                                             password.charAt(password.length() - 1) + "'");
        }
        
        // Rule 4: Check for special character
        boolean hasSpecialChar = false;
        for (char c : password.toCharArray()) {
            if (SPECIAL_CHARS.indexOf(c) != -1) {
                hasSpecialChar = true;
                break;
            }
        }
        
        if (!hasSpecialChar) {
            throw new InvalidPasswordException("Password must contain at least one special " +
                                             "character (@, #, $, %, &, *)");
        }
        
        return true;
    }
    
    /**
     * Get password strength feedback
     */
    public static void getPasswordFeedback(String password) {
        try {
            if (checkPassword(password)) {
                System.out.println("✓ Password is STRONG! All rules satisfied.");
                
                // Display password strength details
                System.out.println("\n--- Password Analysis ---");
                System.out.println("Length: " + password.length() + " characters");
                System.out.println("First character: '" + password.charAt(0) + "' (Uppercase)");
                System.out.println("Last character: '" + password.charAt(password.length() - 1) + 
                                 "' (Digit)");
                
                // Count special characters
                int specialCharCount = 0;
                for (char c : password.toCharArray()) {
                    if (SPECIAL_CHARS.indexOf(c) != -1) {
                        specialCharCount++;
                    }
                }
                System.out.println("Special characters: " + specialCharCount);
                
                // Count digits
                int digitCount = 0;
                for (char c : password.toCharArray()) {
                    if (Character.isDigit(c)) {
                        digitCount++;
                    }
                }
                System.out.println("Total digits: " + digitCount);
            }
            
        } catch (InvalidPasswordException e) {
            System.out.println("✗ Password is WEAK!");
            System.out.println("Reason: " + e.getMessage());
            
            System.out.println("\n--- Password Requirements ---");
            System.out.println("1. First character must be UPPERCASE");
            System.out.println("2. Last character must be a DIGIT");
            System.out.println("3. Minimum length: " + MIN_LENGTH + " characters");
            System.out.println("4. Must contain special characters (@, #, $, %, &, *)");
        } catch (Exception e) {
            System.out.println("Error: Unexpected exception - " + e.getMessage());
        }
    }
    
    /**
     * Display password rules
     */
    public static void displayPasswordRules() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║    PASSWORD STRENGTH REQUIREMENTS       ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("✓ Minimum length: " + MIN_LENGTH + " characters");
        System.out.println("✓ First character: UPPERCASE letter");
        System.out.println("✓ Last character: DIGIT (0-9)");
        System.out.println("✓ Must include: Special character (@, #, $, %, &, *)");
        System.out.println("╚════════════════════════════════════════╝\n");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        displayPasswordRules();
        
        boolean checking = true;
        while (checking) {
            System.out.print("Enter password (or 'quit' to exit): ");
            String password = scanner.nextLine();
            
            if (password.equalsIgnoreCase("quit")) {
                System.out.println("Thank you for using Password Strength Checker!");
                break;
            }
            
            getPasswordFeedback(password);
            System.out.println();
        }
        
        // Test cases
        System.out.println("\n--- Test Cases ---");
        String[] testPasswords = {
            null,                    // null test
            "",                      // empty test
            "abc",                   // too short
            "abcdefg1",              // no uppercase first
            "Abcdefgh",              // no digit last
            "Abcdefg@",              // no digit last
            "Abcdefgh1",             // no special character
            "Abcdefg@1",             // valid password
            "MyPass@2024",           // valid password
            "Strong#123"             // valid password
        };
        
        System.out.println("\nTesting various passwords:");
        for (String testPass : testPasswords) {
            System.out.println("\nPassword: " + (testPass == null ? "null" : "\"" + testPass + "\""));
            getPasswordFeedback(testPass);
        }
        
        scanner.close();
    }
}
