import java.util.Scanner;

public class UniqueCharacterFrequency {
    public static char[] uniqueCharacters(String text) {
        char[] unique = new char[text.length()];
        int uniqueCount = 0;
        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            boolean found = false;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == current) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                unique[uniqueCount++] = current;
            }
        }
        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = unique[i];
        }
        return result;
    }

    public static String[][] frequencyUsingUniqueChars(String text) {
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }
        char[] unique = uniqueCharacters(text);
        String[][] table = new String[unique.length][2];
        for (int i = 0; i < unique.length; i++) {
            table[i][0] = String.valueOf(unique[i]);
            table[i][1] = String.valueOf(freq[unique[i]]);
        }
        return table;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[][] table = frequencyUsingUniqueChars(text);
        System.out.printf("%-12s %-10s%n", "Character", "Frequency");
        for (String[] row : table) {
            System.out.printf("%-12s %-10s%n", row[0], row[1]);
        }
        scanner.close();
    }
}
