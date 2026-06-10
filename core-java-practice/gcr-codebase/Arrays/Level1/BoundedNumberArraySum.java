import java.util.Scanner;

public class BoundedNumberArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = new double[10];
        int index = 0;

        while (true) {
            if (index >= numbers.length) {
                break;
            }

            System.out.print("Enter a positive number (0 or negative to stop): ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.close();
                return;
            }

            double value = scanner.nextDouble();
            if (value <= 0) {
                break;
            }

            numbers[index] = value;
            index++;
        }

        double total = 0.0;
        System.out.println("Numbers entered:");
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
            total += numbers[i];
        }

        System.out.println("Total = " + total);
        scanner.close();
    }
}
