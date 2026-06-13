import java.util.Scanner;

public class FrequencyWithNestedLoops {
    public static String[] frequencyUsingNestedLoops(String text) {
        char[] chars = text.toCharArray();
        int length = chars.length;
        int[] frequencies = new int[length];

        for (int i = 0; i < length; i++) {
            if (chars[i] == '\u0000') {
                continue;
            }
            frequencies[i] = 1;
            for (int j = i + 1; j < length; j++) {
                if (chars[i] == chars[j]) {
                    frequencies[i]++;
                    chars[j] = '\u0000';
                }
            }
        }

        int resultCount = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i] != '\u0000') {
                resultCount++;
            }
        }

        String[] result = new String[resultCount];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i] != '\u0000') {
                result[index++] = chars[i] + ":" + frequencies[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[] frequencyResults = frequencyUsingNestedLoops(text);
        System.out.printf("%-12s %-10s%n", "Character", "Frequency");
        for (String row : frequencyResults) {
            String[] parts = row.split(":");
            System.out.printf("%-12s %-10s%n", parts[0], parts[1]);
        }
        scanner.close();
    }
}
