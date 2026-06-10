import java.util.Scanner;

public class MatrixSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Rows must be an integer.");
            scanner.close();
            return;
        }
        int rows = scanner.nextInt();

        System.out.print("Enter number of columns: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Columns must be an integer.");
            scanner.close();
            return;
        }
        int columns = scanner.nextInt();

        // Validate the dimensions
        if (rows <= 0 || columns <= 0) {
            System.out.println("Invalid input. Rows and columns must be positive.");
            scanner.close();
            return;
        }

        int[][] matrix = new int[rows][columns];
        int totalSum = 0;

        System.out.println("Enter the elements of the matrix:");
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Matrix elements must be integers.");
                    scanner.close();
                    return;
                }
                matrix[row][col] = scanner.nextInt();
                totalSum += matrix[row][col];
            }
        }

        System.out.println("Matrix elements:");
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

        System.out.println("Sum of matrix elements = " + totalSum);
        scanner.close();
    }
}