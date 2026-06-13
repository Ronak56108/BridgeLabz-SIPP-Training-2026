import java.util.Arrays;
import java.util.Scanner;

public class CharArrayComparison {
    public static char[] toCharArrayUsingCharAt(String text) {
        if (text == null) {
            return new char[0];
        }
        char[] result = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            result[i] = text.charAt(i);
        }
        return result;
    }

    public static boolean compareCharArrays(char[] first, char[] second) {
        if (first == null || second == null || first.length != second.length) {
            return false;
        }
        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.next();

        char[] customChars = toCharArrayUsingCharAt(text);
        char[] builtInChars = text.toCharArray();
        boolean arraysMatch = compareCharArrays(customChars, builtInChars);

        System.out.println("Custom char array: " + Arrays.toString(customChars));
        System.out.println("Built-in char array: " + Arrays.toString(builtInChars));
        System.out.println("Arrays comparison result: " + (arraysMatch ? "Same" : "Different"));

        scanner.close();
    }
}
