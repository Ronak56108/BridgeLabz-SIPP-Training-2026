import java.util.Scanner;

public class BMICalculator {
    public static String getBMIStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static String[][] computeBmiAndStatus(double weight, double heightCm) {
        double heightM = heightCm / 100.0;
        double bmi = weight / (heightM * heightM);
        String status = getBMIStatus(bmi);
        return new String[][] {{String.valueOf(weight), String.valueOf(heightCm), String.format("%.2f", bmi), status}};
    }

    public static String[][] buildBmiTable(double[][] records) {
        String[][] table = new String[records.length][4];
        for (int i = 0; i < records.length; i++) {
            String weight = String.valueOf(records[i][0]);
            String height = String.valueOf(records[i][1]);
            String[][] bmiEntry = computeBmiAndStatus(records[i][0], records[i][1]);
            table[i][0] = height;
            table[i][1] = weight;
            table[i][2] = bmiEntry[0][2];
            table[i][3] = bmiEntry[0][3];
        }
        return table;
    }

    public static void displayBmiTable(String[][] table) {
        System.out.printf("%-10s %-10s %-10s %-12s%n", "Height(cm)", "Weight(kg)", "BMI", "Status");
        for (String[] row : table) {
            System.out.printf("%-10s %-10s %-10s %-12s%n", row[0], row[1], row[2], row[3]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] records = new double[10][2];
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            records[i][0] = scanner.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            records[i][1] = scanner.nextDouble();
        }

        String[][] result = buildBmiTable(records);
        displayBmiTable(result);
        scanner.close();
    }
}
