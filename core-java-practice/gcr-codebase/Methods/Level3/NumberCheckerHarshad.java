import java.util.Arrays;

public class NumberCheckerHarshad {
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

    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    public static int sumOfSquares(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }
        return sum;
    }

    public static boolean isHarshadNumber(int number, int[] digits) {
        int sum = sumOfDigits(digits);
        return sum != 0 && number % sum == 0;
    }

    public static int[][] digitFrequency(int[] digits) {
        int[][] frequency = new int[10][2];
        for (int i = 0; i < 10; i++) {
            frequency[i][0] = i;
        }
        for (int digit : digits) {
            frequency[digit][1]++;
        }
        return frequency;
    }

    public static void main(String[] args) {
        int number = 21;
        int[] digits = digitsArray(number);
        System.out.println("Number: " + number);
        System.out.println("Digit count: " + countDigits(number));
        System.out.println("Digits array: " + Arrays.toString(digits));
        System.out.println("Sum of digits: " + sumOfDigits(digits));
        System.out.println("Sum of squares: " + sumOfSquares(digits));
        System.out.println("Harshad number: " + isHarshadNumber(number, digits));
        int[][] frequency = digitFrequency(digits);
        System.out.println("Digit frequencies:");
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i][1] > 0) {
                System.out.println(frequency[i][0] + " appears " + frequency[i][1] + " time(s)");
            }
        }
    }
}
