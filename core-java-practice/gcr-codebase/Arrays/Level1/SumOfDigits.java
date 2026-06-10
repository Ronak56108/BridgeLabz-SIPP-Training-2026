import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a number
        System.out.print("Enter a non-negative integer: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer number.");
            scanner.close();
            return;
        }

        int number = scanner.nextInt();

        // Validate the user input
        if (number < 0) {
            System.out.println("Invalid input. Number must be non-negative.");
            scanner.close();
            return;
        }

        // Count digits in the number
        int temp = number;
        int digitCount = 1;
        if (temp == 0) {
            digitCount = 1;
        } else {
            digitCount = 0;
            while (temp > 0) {
                digitCount++;
                temp /= 10;
            }
        }

        // Save digits in an array
        int[] digits = new int[digitCount];
        temp = number;
        for (int i = digitCount - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }

        // Calculate the sum of digits
        int sumOfDigits = 0;
        for (int digit : digits) {
            sumOfDigits += digit;
        }

        System.out.println("Sum of digits = " + sumOfDigits);
        scanner.close();
    }
}