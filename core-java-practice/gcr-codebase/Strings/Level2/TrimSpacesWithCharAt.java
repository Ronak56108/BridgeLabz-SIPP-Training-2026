import java.util.Scanner;

public class TrimSpacesWithCharAt {
    public static int[] trimIndices(String text) {
        int start = 0;
        int end = text.length();

        while (start < end && text.charAt(start) == ' ') {
            start++;
        }
        while (end > start && text.charAt(end - 1) == ' ') {
            end--;
        }
        return new int[] {start, end};
    }

    public static String substringUsingCharAt(String text, int start, int end) {
        StringBuilder builder = new StringBuilder();
        for (int i = start; i < end; i++) {
            builder.append(text.charAt(i));
        }
        return builder.toString();
    }

    public static boolean compareUsingCharAt(String first, String second) {
        if (first.length() != second.length()) {
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
        System.out.print("Enter text with leading/trailing spaces: ");
        String text = scanner.nextLine();

        int[] bounds = trimIndices(text);
        String customTrim = substringUsingCharAt(text, bounds[0], bounds[1]);
        String builtInTrim = text.trim();
        boolean sameResult = compareUsingCharAt(customTrim, builtInTrim);

        System.out.println("Custom trimmed text: '" + customTrim + "'");
        System.out.println("Built-in trim() text: '" + builtInTrim + "'");
        System.out.println("Results match: " + sameResult);

        scanner.close();
    }
}
