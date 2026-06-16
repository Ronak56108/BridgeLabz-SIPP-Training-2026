import java.util.Arrays;

public class NumberCheckerPalindrome {
    public static int countDigits(int number) {
        return String.valueOf(Math.abs(number)).length();
    }

    public static int[] digitsArray(int number) {
        String digits = String.valueOf(Math.abs(number));
        int[] result = new int[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            result[i] = Character.getNumericValue(digits.charAt(i));
        }
        return result;
    }

    public static int[] reverseDigits(int[] digits) {
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }

    public static boolean arraysEqual(int[] array1, int[] array2) {
        return Arrays.equals(array1, array2);
    }

    public static boolean isPalindromeNumber(int[] digits) {
        int[] reversed = reverseDigits(digits);
        return arraysEqual(digits, reversed);
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int number = 121;
        int[] digits = digitsArray(number);
        int[] reversed = reverseDigits(digits);
        System.out.println("Number: " + number);
        System.out.println("Digits array: " + Arrays.toString(digits));
        System.out.println("Reversed array: " + Arrays.toString(reversed));
        System.out.println("Arrays equal: " + arraysEqual(digits, reversed));
        System.out.println("Palindrome number: " + isPalindromeNumber(digits));
        System.out.println("Duck number: " + isDuckNumber(digits));
    }
}
