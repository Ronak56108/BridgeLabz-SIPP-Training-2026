import java.util.Scanner;

public class MeanHeightCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] heights = new double[11];
        double sumOfHeights = 0.0;

        System.out.println("Enter heights for 11 players:");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Height " + (i + 1) + ": ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a numeric height.");
                scanner.close();
                return;
            }
            heights[i] = scanner.nextDouble();
            if (heights[i] < 0) {
                System.out.println("Invalid input. Height cannot be negative.");
                scanner.close();
                return;
            }
            sumOfHeights += heights[i];
        }

        double meanHeight = sumOfHeights / heights.length;
        System.out.println("Mean height = " + meanHeight);
        scanner.close();
    }
}
