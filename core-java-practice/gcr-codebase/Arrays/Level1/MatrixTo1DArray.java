import java.util.Scanner;

public class MatrixTo1DArray {
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

        if (rows <= 0 || columns <= 0) {
            System.out.println("Invalid input. Rows and columns must be positive.");
            scanner.close();
            return;
        }

        int[][] matrix = new int[rows][columns];

        System.out.println("Enter matrix elements:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Matrix elements must be integers.");
                    scanner.close();
                    return;
                }
                matrix[i][j] = scanner.nextInt();
            }
        }

        int[] array = new int[rows * columns];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[index++] = matrix[i][j];
            }
        }

        System.out.println("1D array elements:");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();

        scanner.close();
    }
}
