import java.io.*;
import java.util.*;

public class DailyExpenseLogger {
    public static void main(String[] args) {
        String outputFile = "expenses.txt";
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many expense entries do you want to add? ");
        int n = Integer.parseInt(scanner.nextLine().trim());

        List<String> entries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter expense category: ");
            String category = scanner.nextLine().trim();
            System.out.print("Enter amount: ");
            String amount = scanner.nextLine().trim();
            entries.add(category + " - " + amount);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true))) {
            for (String entry : entries) {
                writer.write(entry);
                writer.newLine();
            }
            System.out.println("Expenses appended to " + outputFile);
        } catch (IOException e) {
            System.out.println("Failed to write expenses: " + e.getMessage());
        }
    }
}
