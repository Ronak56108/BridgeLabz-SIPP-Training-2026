import java.util.Scanner;

public class SplitTextCompareSplit {
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

    public static String[] splitTextUsingCharAt(String text) {
        int length = getStringLength(text);
        if (length == 0) {
            return new String[0];
        }

        int wordCount = 0;
        boolean inWord = false;
        for (int i = 0; i < length; i++) {
            char c = text.charAt(i);
            if (c != ' ' && !inWord) {
                wordCount++;
                inWord = true;
            } else if (c == ' ') {
                inWord = false;
            }
        }

        String[] words = new String[wordCount];
        int wordIndex = 0;
        int start = -1;
        for (int i = 0; i <= length; i++) {
            if (i < length && text.charAt(i) != ' ') {
                if (start == -1) {
                    start = i;
                }
            } else if (start != -1) {
                StringBuilder builder = new StringBuilder();
                for (int j = start; j < i; j++) {
                    builder.append(text.charAt(j));
                }
                words[wordIndex++] = builder.toString();
                start = -1;
            }
        }

        return words;
    }

    public static boolean compareStringArrays(String[] first, String[] second) {
        if (first == null || second == null || first.length != second.length) {
            return false;
        }
        for (int i = 0; i < first.length; i++) {
            if (!first[i].equals(second[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[] customWords = splitTextUsingCharAt(text);
        String[] builtInWords = text.trim().isEmpty() ? new String[0] : text.split("\\s+");
        boolean sameResult = compareStringArrays(customWords, builtInWords);

        System.out.println("Custom split result:");
        for (String word : customWords) {
            System.out.println(word);
        }
        System.out.println("Built-in split result:");
        for (String word : builtInWords) {
            System.out.println(word);
        }
        System.out.println("Arrays match: " + sameResult);

        scanner.close();
    }
}
