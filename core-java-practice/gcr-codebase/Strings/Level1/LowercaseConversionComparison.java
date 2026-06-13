import java.util.Scanner;

public class LowercaseConversionComparison {
    public static String toLowerCaseUsingCharAt(String text) {
        if (text == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            if (current >= 'A' && current <= 'Z') {
                current = (char) (current + 32);
            }
            builder.append(current);
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
        System.out.print("Enter complete text: ");
        String text = scanner.nextLine();

        String customLower = toLowerCaseUsingCharAt(text);
        String builtInLower = text.toLowerCase();
        boolean sameResult = compareUsingCharAt(customLower, builtInLower);

        System.out.println("Custom lowercase conversion: " + customLower);
        System.out.println("Built-in toLowerCase(): " + builtInLower);
        System.out.println("Comparison result: " + (sameResult ? "Same" : "Different"));

        scanner.close();
    }
}
