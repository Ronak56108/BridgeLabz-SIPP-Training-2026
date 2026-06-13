import java.util.Scanner;

public class NumberFormatExceptionDemo {
    public static void generateNumberFormatException(String text) {
        System.out.println("Generating NumberFormatException...");
        int number = Integer.parseInt(text);
        System.out.println("Parsed number: " + number);
    }

    public static void handleNumberFormatException(String text) {
        System.out.println("Handling NumberFormatException...");
        try {
            int number = Integer.parseInt(text);
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException exception) {
            System.out.println("Caught NumberFormatException: " + exception.getMessage());
        } catch (RuntimeException exception) {
            System.out.println("Caught RuntimeException: " + exception.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text to parse as integer: ");
        String text = scanner.next();

        try {
            generateNumberFormatException(text);
        } catch (NumberFormatException exception) {
            System.out.println("Exception caught in main(): " + exception.getMessage());
        }

        handleNumberFormatException(text);
        scanner.close();
    }
}
