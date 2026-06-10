import java.util.Scanner;

public class FiveNumberClassification {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[5];

        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.close();
                return;
            }
            numbers[i] = scanner.nextInt();
        }

        for (int currentNumber : numbers) {
            if (currentNumber > 0) {
                if (currentNumber % 2 == 0) {
                    System.out.println(currentNumber + " is positive and even.");
                } else {
                    System.out.println(currentNumber + " is positive and odd.");
                }
            } else if (currentNumber < 0) {
                System.out.println(currentNumber + " is negative.");
            } else {
                System.out.println(currentNumber + " is zero.");
            }
        }

        if (numbers[0] == numbers[numbers.length - 1]) {
            System.out.println("First and last elements are equal.");
        } else if (numbers[0] > numbers[numbers.length - 1]) {
            System.out.println("First element is greater than last element.");
        } else {
            System.out.println("First element is less than last element.");
        }

        scanner.close();
    }
}