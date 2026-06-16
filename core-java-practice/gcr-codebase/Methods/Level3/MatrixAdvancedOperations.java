import java.util.Random;

public class MatrixAdvancedOperations {
    public static int[][] createRandomMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(10);
            }
        }
        return matrix;
    }

    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposed = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    public static int determinant2x2(int[][] matrix) {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    public static int determinant3x3(int[][] matrix) {
        return matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1])
                - matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0])
                + matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
    }

    public static double[][] inverse2x2(int[][] matrix) {
        double det = determinant2x2(matrix);
        double[][] inverse = new double[2][2];
        inverse[0][0] = matrix[1][1] / det;
        inverse[0][1] = -matrix[0][1] / det;
        inverse[1][0] = -matrix[1][0] / det;
        inverse[1][1] = matrix[0][0] / det;
        return inverse;
    }

    public static double[][] inverse3x3(int[][] matrix) {
        int det = determinant3x3(matrix);
        double[][] inverse = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                inverse[j][i] = cofactor(matrix, i, j) / (double) det;
            }
        }
        return inverse;
    }

    private static int cofactor(int[][] matrix, int row, int col) {
        int[][] minor = new int[2][2];
        int r = 0;
        for (int i = 0; i < 3; i++) {
            if (i == row) continue;
            int c = 0;
            for (int j = 0; j < 3; j++) {
                if (j == col) continue;
                minor[r][c++] = matrix[i][j];
            }
            r++;
        }
        int det = minor[0][0] * minor[1][1] - minor[0][1] * minor[1][0];
        return ((row + col) % 2 == 0 ? 1 : -1) * det;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%4d", value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.printf("%8.2f", value);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix2x2 = createRandomMatrix(2, 2);
        int[][] matrix3x3 = createRandomMatrix(3, 3);

        System.out.println("2x2 matrix:");
        printMatrix(matrix2x2);
        System.out.println("Transpose:");
        printMatrix(transpose(matrix2x2));
        System.out.println("Determinant: " + determinant2x2(matrix2x2));
        System.out.println("Inverse:");
        printMatrix(inverse2x2(matrix2x2));

        System.out.println("3x3 matrix:");
        printMatrix(matrix3x3);
        System.out.println("Transpose:");
        printMatrix(transpose(matrix3x3));
        System.out.println("Determinant: " + determinant3x3(matrix3x3));
        System.out.println("Inverse:");
        printMatrix(inverse3x3(matrix3x3));
    }
}
