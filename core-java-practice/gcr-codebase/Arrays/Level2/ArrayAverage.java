import java.util.Scanner;

public class ArrayAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Array must contain at least one element.");
            sc.close();
            return;
        }

        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += sc.nextDouble();
        }

        double average = sum / n;
        System.out.println(average);
        sc.close();
    }
}
