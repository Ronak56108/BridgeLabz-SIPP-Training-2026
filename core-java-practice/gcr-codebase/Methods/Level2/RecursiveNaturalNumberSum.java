import java.util.Scanner;

public class RecursiveNaturalNumberSum {
    public static int recursiveSum(int n) {
        if (n <= 0) {
            return 0;
        }
        return n + recursiveSum(n - 1);
    }

    public static int formulaSum(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();

        if (n < 1) {
            System.out.println("Please enter a natural number (positive integer). ");
            scanner.close();
            return;
        }

        int recursiveResult = recursiveSum(n);
        int formulaResult = formulaSum(n);

        System.out.println("Recursive sum: " + recursiveResult);
        System.out.println("Formula sum: " + formulaResult);
        System.out.println("Results match: " + (recursiveResult == formulaResult));
        scanner.close();
    }
}
