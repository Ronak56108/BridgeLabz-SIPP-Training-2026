import java.util.Scanner;

public class VowelConsonantMapping {
    public static String getCharType(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            }
            return "Consonant";
        }
        return "Not a Letter";
    }

    public static String[][] mapCharacters(String text) {
        String[][] table = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            table[i][0] = String.valueOf(text.charAt(i));
            table[i][1] = getCharType(text.charAt(i));
        }
        return table;
    }

    public static void displayTable(String[][] table) {
        System.out.printf("%-10s %-15s%n", "Character", "Type");
        for (String[] row : table) {
            System.out.printf("%-10s %-15s%n", row[0], row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[][] table = mapCharacters(text);
        displayTable(table);

        scanner.close();
    }
}
