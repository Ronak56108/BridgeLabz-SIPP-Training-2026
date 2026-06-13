import java.util.Scanner;

public class SubstringWithCharAt {
    public static String substringUsingCharAt(String text, int start, int end) {
        if (text == null || start < 0 || end > text.length() || start > end) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = start; i < end; i++) {
            builder.append(text.charAt(i));
        }
        return builder.toString();
    }

    public static boolean compareUsingCharAt(String first, String second) {
        if (first == null || second == null || first.length() != second.length()) {
            return false;
        }
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.next();
        System.out.print("Enter start index: ");
        int start = scanner.nextInt();
        System.out.print("Enter end index: ");
        int end = scanner.nextInt();

        String substring1 = substringUsingCharAt(text, start, end);
        if (substring1 == null) {
            System.out.println("Invalid indices for substring extraction.");
            scanner.close();
            return;
        }

        String substring2;
        try {
            substring2 = text.substring(start, end);
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Invalid indices for built-in substring(): " + exception.getMessage());
            scanner.close();
            return;
        }

        boolean sameResult = compareUsingCharAt(substring1, substring2);

        System.out.println("Custom substring using charAt(): " + substring1);
        System.out.println("Built-in substring(): " + substring2);
        System.out.println("Comparison result: " + (sameResult ? "Same" : "Different"));

        scanner.close();
    }
}
