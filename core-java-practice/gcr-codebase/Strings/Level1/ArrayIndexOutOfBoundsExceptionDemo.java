import java.util.Scanner;

public class ArrayIndexOutOfBoundsExceptionDemo {
    public static void generateArrayIndexOutOfBoundsException(String[] names) {
        System.out.println("Generating ArrayIndexOutOfBoundsException...");
        System.out.println("Accessing invalid index: " + names[names.length]);
    }

    public static void handleArrayIndexOutOfBoundsException(String[] names) {
        System.out.println("Handling ArrayIndexOutOfBoundsException...");
        try {
            System.out.println("Accessing invalid index: " + names[names.length]);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + exception.getMessage());
        } catch (RuntimeException exception) {
            System.out.println("Caught RuntimeException: " + exception.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of names: ");
        int count = scanner.nextInt();
        if (count < 1) {
            System.out.println("At least one name is required.");
            scanner.close();
            return;
        }

        String[] names = new String[count];
        for (int i = 0; i < names.length; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = scanner.next();
        }

        try {
            generateArrayIndexOutOfBoundsException(names);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Exception caught in main(): " + exception.getMessage());
        }

        handleArrayIndexOutOfBoundsException(names);
        scanner.close();
    }
}
