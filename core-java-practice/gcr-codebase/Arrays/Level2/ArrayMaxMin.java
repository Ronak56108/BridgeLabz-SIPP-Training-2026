import java.util.Scanner;

public class ArrayMaxMin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Array must contain at least one element.");
            sc.close();
            return;
        }

        int first = sc.nextInt();
        int max = first;
        int min = first;

        for (int i = 1; i < n; i++) {
            int value = sc.nextInt();
            if (value > max) {
                max = value;
            }
            if (value < min) {
                min = value;
            }
        }

        System.out.println("Max = " + max);
        System.out.println("Min = " + min);
        sc.close();
    }
}
