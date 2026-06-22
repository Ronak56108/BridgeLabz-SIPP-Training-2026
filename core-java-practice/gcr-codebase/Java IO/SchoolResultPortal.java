import java.io.*;
import java.util.*;

public class SchoolResultPortal {
    public static void main(String[] args) {
        String inputFile = "student_results.txt";
        String outputFile = "report_cards.txt";

        try {
            List<String> reportLines = generateReport(inputFile);
            appendToFile(outputFile, reportLines);
            System.out.println("Report cards written to " + outputFile);
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found: " + inputFile);
        } catch (IOException e) {
            System.out.println("An I/O error occurred: " + e.getMessage());
        }
    }

    private static List<String> generateReport(String inputFile) throws FileNotFoundException {
        File file = new File(inputFile);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }

        List<String> reportLines = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] parts = line.split("\\s*,\\s*|\\s+-\\s+|\\s+");
                if (parts.length < 2) {
                    continue;
                }
                String name = parts[0];
                double sum = 0;
                int count = 0;
                for (int i = 1; i < parts.length; i++) {
                    try {
                        sum += Double.parseDouble(parts[i]);
                        count++;
                    } catch (NumberFormatException ignored) {
                    }
                }
                if (count == 0) {
                    continue;
                }
                double average = sum / count;
                reportLines.add("Student: " + name);
                reportLines.add("Marks: " + joinMarks(parts));
                reportLines.add(String.format("Average: %.2f", average));
                reportLines.add("-------------------------");
            }
        }
        return reportLines;
    }

    private static String joinMarks(String[] parts) {
        if (parts.length <= 1) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < parts.length; i++) {
            builder.append(parts[i]);
            if (i < parts.length - 1) {
                builder.append(", ");
            }
        }
        return builder.toString();
    }

    private static void appendToFile(String outputFile, List<String> lines) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }
    }
}
