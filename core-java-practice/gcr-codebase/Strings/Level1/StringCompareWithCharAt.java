import java.util.Scanner;

public class StringCompareWithCharAt {
    public static boolean compareUsingCharAt(String first, String second) {
        if (first == null || second == null || first.length() != second.length()) {
            return false;
        }
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String first = scanner.next();
        System.out.print("Enter second string: ");
        String second = scanner.next();

        boolean charAtResult = compareUsingCharAt(first, second);
        boolean equalsResult = first.equals(second);

        System.out.println("Compare using charAt(): " + charAtResult);
        System.out.println("Compare using equals(): " + equalsResult);
        System.out.println("Final result: " + (charAtResult == equalsResult ? "Same result" : "Different result"));

        scanner.close();
    }
}
