import java.util.Scanner;

public class IllegalArgumentExceptionDemo {
    public static void generateIllegalArgumentException(String text, int start, int end) {
        if (start > end) {
            throw new IllegalArgumentException("Start index is greater than end index");
        }
        System.out.println("Substring: " + text.substring(start, end));
    }

    public static void handleIllegalArgumentException(String text, int start, int end) {
        System.out.println("Handling IllegalArgumentException...");
        try {
            if (start > end) {
                throw new IllegalArgumentException("Start index is greater than end index");
            }
            System.out.println("Substring: " + text.substring(start, end));
        } catch (IllegalArgumentException exception) {
            System.out.println("Caught IllegalArgumentException: " + exception.getMessage());
        } catch (RuntimeException exception) {
            System.out.println("Caught RuntimeException: " + exception.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.next();
        System.out.print("Enter start index: ");
        int start = scanner.nextInt();
        System.out.print("Enter end index: ");
        int end = scanner.nextInt();

        if (start <= end) {
            System.out.println("To generate IllegalArgumentException, adjusting start index to be greater than end index.");
            start = end + 1;
        }

        try {
            generateIllegalArgumentException(text, start, end);
        } catch (IllegalArgumentException exception) {
            System.out.println("Exception caught in main(): " + exception.getMessage());
        }

        handleIllegalArgumentException(text, start, end);
        scanner.close();
    }
}
