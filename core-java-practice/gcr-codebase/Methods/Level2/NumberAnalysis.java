import java.util.Scanner;

public class NumberAnalysis {
    public static boolean isPositive(int number) {
        return number >= 0;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int compare(int number1, int number2) {
        if (number1 > number2) {
            return 1;
        }
        if (number1 < number2) {
            return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        for (int number : numbers) {
            if (!isPositive(number)) {
                System.out.println(number + " is negative.");
            } else {
                System.out.print(number + " is positive");
                if (isEven(number)) {
                    System.out.println(" and even.");
                } else {
                    System.out.println(" and odd.");
                }
            }
        }

        int compareResult = compare(numbers[0], numbers[numbers.length - 1]);
        if (compareResult == 1) {
            System.out.println("First element is greater than last element.");
        } else if (compareResult == -1) {
            System.out.println("First element is less than last element.");
        } else {
            System.out.println("First element is equal to last element.");
        }
        scanner.close();
    }
}
