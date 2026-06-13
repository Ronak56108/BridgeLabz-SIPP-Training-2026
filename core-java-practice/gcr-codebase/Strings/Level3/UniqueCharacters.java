import java.util.Scanner;

public class UniqueCharacters {
    public static int getStringLength(String text) {
        int count = 0;
        while (true) {
            try {
                text.charAt(count);
                count++;
            } catch (IndexOutOfBoundsException exception) {
                break;
            }
        }
        return count;
    }

    public static char[] uniqueCharacters(String text) {
        int length = getStringLength(text);
        char[] unique = new char[length];
        int uniqueCount = 0;

        for (int i = 0; i < length; i++) {
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        char[] unique = uniqueCharacters(text);
        System.out.println("Unique characters:");
        for (char ch : unique) {
            System.out.print(ch + " ");
        }
        System.out.println();
        scanner.close();
    }
}
