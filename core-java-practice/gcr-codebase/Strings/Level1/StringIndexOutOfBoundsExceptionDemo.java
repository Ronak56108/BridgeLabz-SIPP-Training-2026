import java.util.Scanner;

public class StringIndexOutOfBoundsExceptionDemo {
    public static void generateStringIndexOutOfBoundsException(String text) {
        System.out.println("Generating StringIndexOutOfBoundsException...");
        System.out.println("Invalid char: " + text.charAt(text.length()));
    }

    public static void handleStringIndexOutOfBoundsException(String text) {
        System.out.println("Handling StringIndexOutOfBoundsException...");
        try {
            System.out.println("Invalid char: " + text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException exception) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + exception.getMessage());
        } catch (RuntimeException exception) {
            System.out.println("Caught RuntimeException: " + exception.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.next();

        try {
            generateStringIndexOutOfBoundsException(text);
        } catch (StringIndexOutOfBoundsException exception) {
            System.out.println("Exception caught in main(): " + exception.getMessage());
        }

        handleStringIndexOutOfBoundsException(text);
        scanner.close();
    }
}
