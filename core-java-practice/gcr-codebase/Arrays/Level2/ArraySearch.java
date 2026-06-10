import java.util.Scanner;

public class ArraySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();
        boolean found = false;

        for (int value : arr) {
            if (value == target) {
                found = true;
                break;
            }
        }

        System.out.println(found ? "Found" : "Not Found");
        sc.close();
    }
}
