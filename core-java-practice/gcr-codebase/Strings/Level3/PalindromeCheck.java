import java.util.Scanner;

public class PalindromeCheck {
    public static boolean isPalindromeIterative(String text) {
        int start = 0;
        int end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    public static char[] reverseUsingCharAt(String text) {
        int length = text.length();
        char[] reversed = new char[length];
        for (int i = 0; i < length; i++) {
            reversed[i] = text.charAt(length - 1 - i);
        }
        return reversed;
    }

    public static boolean isPalindromeUsingArrays(String text) {
        char[] original = text.toCharArray();
        char[] reversed = reverseUsingCharAt(text);
        if (original.length != reversed.length) {
            return false;
        }
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        boolean iterativeResult = isPalindromeIterative(text);
        boolean recursiveResult = isPalindromeRecursive(text, 0, text.length() - 1);
        boolean arrayResult = isPalindromeUsingArrays(text);

        System.out.println("Iterative result: " + iterativeResult);
        System.out.println("Recursive result: " + recursiveResult);
        System.out.println("Array comparison result: " + arrayResult);
        scanner.close();
    }
}
