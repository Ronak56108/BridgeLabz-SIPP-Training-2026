import java.util.Scanner;

public class StudentGradeCard {
    public static int[][] generateRandomScores(int count) {
        int[][] scores = new int[count][3];
        for (int i = 0; i < count; i++) {
            scores[i][0] = 10 + (int) (Math.random() * 90);
            scores[i][1] = 10 + (int) (Math.random() * 90);
            scores[i][2] = 10 + (int) (Math.random() * 90);
        }
        return scores;
    }

    public static double[][] calculateTotalAveragePercentage(int[][] scores) {
        int count = scores.length;
        double[][] results = new double[count][3];
        for (int i = 0; i < count; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = average;
            results[i][0] = Math.round(total * 100.0) / 100.0;
            results[i][1] = Math.round(average * 100.0) / 100.0;
            results[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return results;
    }

    public static String[] calculateGrades(double[][] percentages) {
        String[] grades = new String[percentages.length];
        for (int i = 0; i < percentages.length; i++) {
            double percentage = percentages[i][2];
            if (percentage >= 90) {
                grades[i] = "A";
            } else if (percentage >= 80) {
                grades[i] = "B";
            } else if (percentage >= 70) {
                grades[i] = "C";
            } else if (percentage >= 60) {
                grades[i] = "D";
            } else {
                grades[i] = "F";
            }
        }
        return grades;
    }

    public static void displayScorecard(int[][] scores, double[][] totals, String[] grades) {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-12s %-10s%n", "Student", "Physics", "Chemistry", "Maths", "Total", "Average", "Grade");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf(
                    "%-10s %-10d %-10d %-10d %-10.0f %-12.2f %-10s%n",
                    "Student" + (i + 1),
                    scores[i][0],
                    scores[i][1],
                    scores[i][2],
                    totals[i][0],
                    totals[i][1],
                    grades[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int count = scanner.nextInt();
        if (count <= 0) {
            System.out.println("Student count must be positive.");
            scanner.close();
            return;
        }

        int[][] scores = generateRandomScores(count);
        double[][] totals = calculateTotalAveragePercentage(scores);
        String[] grades = calculateGrades(totals);
        displayScorecard(scores, totals, grades);

        scanner.close();
    }
}
