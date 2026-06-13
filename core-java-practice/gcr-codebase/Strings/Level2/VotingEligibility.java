import java.util.Scanner;

public class VotingEligibility {
    public static int[] generateRandomAges(int count) {
        int[] ages = new int[count];
        for (int i = 0; i < count; i++) {
            ages[i] = 10 + (int) (Math.random() * 90);
        }
        return ages;
    }

    public static String[][] evaluateVoting(int[] ages) {
        String[][] table = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            boolean canVote = ages[i] >= 18 && ages[i] >= 0;
            table[i][0] = String.valueOf(ages[i]);
            table[i][1] = String.valueOf(canVote);
        }
        return table;
    }

    public static void displayTable(String[][] table) {
        System.out.printf("%-10s %-10s%n", "Age", "CanVote");
        for (String[] row : table) {
            System.out.printf("%-10s %-10s%n", row[0], row[1]);
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

        int[] ages = generateRandomAges(count);
        String[][] results = evaluateVoting(ages);
        displayTable(results);

        scanner.close();
    }
}
