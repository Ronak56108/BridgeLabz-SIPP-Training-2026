import java.util.Scanner;

public class ArrayEvenOddCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int evenCount = 0;
        int oddCount = 0;

        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            if (value % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("Even = " + evenCount);
        System.out.println("Odd = " + oddCount);
        sc.close();
    }
}
