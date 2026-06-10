import java.util.Scanner;

public class Level3Programs {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Uncomment the program you want to run

        // checkPrime();
        // checkArmstrong();
        // countDigits();
    }

    // 1. Prime Number Check
    static void checkPrime() {

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        boolean isPrime = true;

        if (number <= 1) {
            isPrime = false;
        } else {

            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        if (isPrime) {
            System.out.println(number + " is a Prime Number");
        } else {
            System.out.println(number + " is not a Prime Number");
        }
    }

    // 2. Armstrong Number Check
    static void checkArmstrong() {

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int originalNumber = number;
        int sum = 0;

        while (originalNumber != 0) {

            int digit = originalNumber % 10;

            sum = sum + (digit * digit * digit);

            originalNumber = originalNumber / 10;
        }

        if (sum == number) {
            System.out.println(number + " is an Armstrong Number");
        } else {
            System.out.println(number + " is not an Armstrong Number");
        }
    }

    // 3. Count Digits in Integer
    static void countDigits() {

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int count = 0;

        if (number == 0) {
            count = 1;
        } else {

            number = Math.abs(number);

            while (number != 0) {
                number = number / 10;
                count++;
            }
        }

        System.out.println("Number of digits = " + count);
    }
}