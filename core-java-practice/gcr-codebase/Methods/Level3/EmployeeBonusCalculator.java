import java.util.Random;

public class EmployeeBonusCalculator {
    public static double[][] generateSalaryAndService(int employees) {
        double[][] data = new double[employees][2];
        Random random = new Random();
        for (int i = 0; i < employees; i++) {
            data[i][0] = 10000 + random.nextInt(90000); // salary between 10000 and 99999
            data[i][1] = random.nextInt(11); // years of service 0-10
        }
        return data;
    }

    public static double[][] calculateNewSalaryAndBonus(double[][] data) {
        double[][] result = new double[data.length][3];
        for (int i = 0; i < data.length; i++) {
            double salary = data[i][0];
            double years = data[i][1];
            double bonusRate = years > 5 ? 0.05 : 0.02;
            double bonus = salary * bonusRate;
            double newSalary = salary + bonus;
            result[i][0] = salary;
            result[i][1] = bonus;
            result[i][2] = newSalary;
        }
        return result;
    }

    public static void displaySummary(double[][] data, double[][] result) {
        double sumOld = 0;
        double sumBonus = 0;
        double sumNew = 0;
        System.out.println("Employee\tOld Salary\tYears\tBonus\tNew Salary");
        for (int i = 0; i < data.length; i++) {
            sumOld += data[i][0];
            sumBonus += result[i][1];
            sumNew += result[i][2];
            System.out.printf("%d\t%.2f\t%.0f\t%.2f\t%.2f%n", i + 1, data[i][0], data[i][1], result[i][1], result[i][2]);
        }
        System.out.printf("Total\t%.2f\t--\t%.2f\t%.2f%n", sumOld, sumBonus, sumNew);
    }

    public static void main(String[] args) {
        double[][] data = generateSalaryAndService(10);
        double[][] result = calculateNewSalaryAndBonus(data);
        displaySummary(data, result);
    }
}
