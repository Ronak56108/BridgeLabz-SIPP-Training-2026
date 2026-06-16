import java.util.Arrays;

public class NumberCheckerBasic {
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

    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isArmstrongNumber(int number, int[] digits) {
        int power = digits.length;
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, power);
        }
        return sum == number;
    }

    public static int[] largestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int digit : digits) {
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest && digit != largest) {
                secondLargest = digit;
            }
        }
        return new int[]{largest, secondLargest};
    }

    public static int[] smallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int digit : digits) {
            if (digit < smallest) {
                secondSmallest = smallest;
                smallest = digit;
            } else if (digit < secondSmallest && digit != smallest) {
                secondSmallest = digit;
            }
        }
        return new int[]{smallest, secondSmallest};
    }

    public static void main(String[] args) {
        int number = 153;
        int[] digits = digitsArray(number);
        System.out.println("Number: " + number);
        System.out.println("Digit count: " + countDigits(number));
        System.out.println("Digits array: " + Arrays.toString(digits));
        System.out.println("Duck number: " + isDuckNumber(digits));
        System.out.println("Armstrong number: " + isArmstrongNumber(number, digits));
        System.out.println("Largest and second largest: " + Arrays.toString(largestAndSecondLargest(digits)));
        System.out.println("Smallest and second smallest: " + Arrays.toString(smallestAndSecondSmallest(digits)));
    }
}
