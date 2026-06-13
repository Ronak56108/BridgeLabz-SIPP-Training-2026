import java.util.Scanner;

public class ShortestLongestWord {
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

    public static String[][] wordLengthsTable(String[] words) {
        String[][] table = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            table[i][0] = words[i];
            table[i][1] = String.valueOf(getStringLength(words[i]));
        }
        return table;
    }

    public static int[] findShortestAndLongest(String[][] wordLengths) {
        if (wordLengths.length == 0) {
            return new int[] {-1, -1};
        }
        int shortestIndex = 0;
        int longestIndex = 0;
        int shortestLength = Integer.parseInt(wordLengths[0][1]);
        int longestLength = shortestLength;

        for (int i = 1; i < wordLengths.length; i++) {
            int currentLength = Integer.parseInt(wordLengths[i][1]);
            if (currentLength < shortestLength) {
                shortestLength = currentLength;
                shortestIndex = i;
            }
            if (currentLength > longestLength) {
                longestLength = currentLength;
                longestIndex = i;
            }
        }

        return new int[] {shortestIndex, longestIndex};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[] words = splitTextUsingCharAt(text);
        String[][] table = wordLengthsTable(words);
        int[] indices = findShortestAndLongest(table);

        if (indices[0] == -1) {
            System.out.println("No words found.");
        } else {
            System.out.println("Shortest word: " + table[indices[0]][0] + " (length=" + table[indices[0]][1] + ")");
            System.out.println("Longest word: " + table[indices[1]][0] + " (length=" + table[indices[1]][1] + ")");
        }

        scanner.close();
    }
}
