import java.util.Scanner;

public class CharacterFrequency {
    public static String[][] frequencyTable(String text) {
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        int distinctCount = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                distinctCount++;
            }
        }

        String[][] table = new String[distinctCount][2];
        int index = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                table[index][0] = String.valueOf((char) i);
                table[index][1] = String.valueOf(freq[i]);
                index++;
            }
        }
        return table;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[][] table = frequencyTable(text);
        System.out.printf("%-12s %-10s%n", "Character", "Frequency");
        for (String[] row : table) {
            System.out.printf("%-12s %-10s%n", row[0], row[1]);
        }
        scanner.close();
    }
}
