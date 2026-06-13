import java.util.Scanner;

public class AnagramCheck {
    public static boolean areAnagrams(String first, String second) {
        String s1 = first.replaceAll("\\s+", "").toLowerCase();
        String s2 = second.replaceAll("\\s+", "").toLowerCase();
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] freq1 = new int[256];
        int[] freq2 = new int[256];
        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i)]++;
            freq2[s2.charAt(i)]++;
        }
        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first text: ");
        String first = scanner.nextLine();
        System.out.print("Enter second text: ");
        String second = scanner.nextLine();

        boolean result = areAnagrams(first, second);
        System.out.println("Anagram result: " + result);
        scanner.close();
    }
}
