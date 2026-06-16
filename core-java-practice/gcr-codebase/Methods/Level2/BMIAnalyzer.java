import java.util.Scanner;

public class BMIAnalyzer {
    public static double calculateBMI(double weightKg, double heightCm) {
        double heightMeters = heightCm / 100.0;
        return weightKg / (heightMeters * heightMeters);
    }

    public static String determineBMIStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        }
        if (bmi < 24.9) {
            return "Normal weight";
        }
        if (bmi < 29.9) {
            return "Overweight";
        }
        return "Obese";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] data = new double[10][3];

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            data[i][0] = scanner.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            data[i][1] = scanner.nextDouble();
            data[i][2] = calculateBMI(data[i][0], data[i][1]);
        }

        for (int i = 0; i < 10; i++) {
            double bmi = data[i][2];
            System.out.println("Person " + (i + 1) + ": Weight=" + data[i][0] + "kg, Height=" + data[i][1] + "cm, BMI=" + bmi + ", Status=" + determineBMIStatus(bmi));
        }
        scanner.close();
    }
}
