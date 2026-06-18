import java.util.Scanner;

/**
 * Problem 3: Custom Exception (User-defined Exception)
 * 
 * Create a custom exception called InvalidAgeException.
 * Write a method validateAge(int age) that throws InvalidAgeException 
 * if the age is below 18.
 */
public class AgeValidation {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();
            
            validateAge(age);
            System.out.println("Access granted!");
            
        } catch (InvalidAgeException e) {
            System.out.println("Age must be 18 or above");
        } finally {
            scanner.close();
        }
    }
    
    /**
     * Validates if age is 18 or above
     * @param age the age to validate
     * @throws InvalidAgeException if age is below 18
     */
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        }
    }
}
