import java.util.Scanner;

public class StringLengthWithoutLength {
    public static int getStringLength(String text) {
        int count = 0;
        while (true) {
            try {
                text.charAt(count);
                count++;
            } catch (IndexOutOfBoundsException exception) {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.next();

        int customLength = getStringLength(text);
        int builtInLength = text.length();

        System.out.println("Length using charAt() loop: " + customLength);
        System.out.println("Length using built-in length(): " + builtInLength);
        System.out.println("Results match: " + (customLength == builtInLength));

        scanner.close();
    }
}
