import java.util.Scanner;

public class CollinearPointsChecker {
    public static boolean areCollinearSlope(int x1, int y1, int x2, int y2, int x3, int y3) {
        int dx1 = x2 - x1;
        int dy1 = y2 - y1;
        int dx2 = x3 - x2;
        int dy2 = y3 - y2;
        return dx1 * dy2 == dy1 * dx2;
    }

    public static boolean areCollinearArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        int areaTimesTwo = x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2);
        return areaTimesTwo == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x1: ");
        int x1 = scanner.nextInt();
        System.out.print("Enter y1: ");
        int y1 = scanner.nextInt();
        System.out.print("Enter x2: ");
        int x2 = scanner.nextInt();
        System.out.print("Enter y2: ");
        int y2 = scanner.nextInt();
        System.out.print("Enter x3: ");
        int x3 = scanner.nextInt();
        System.out.print("Enter y3: ");
        int y3 = scanner.nextInt();

        System.out.println("Collinear by slopes: " + areCollinearSlope(x1, y1, x2, y2, x3, y3));
        System.out.println("Collinear by area: " + areCollinearArea(x1, y1, x2, y2, x3, y3));
        scanner.close();
    }
}
