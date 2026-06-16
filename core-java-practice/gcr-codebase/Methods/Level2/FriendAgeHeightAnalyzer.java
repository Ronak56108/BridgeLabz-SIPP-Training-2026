import java.util.Scanner;

public class FriendAgeHeightAnalyzer {
    public static int findYoungestIndex(int[] ages) {
        int youngestIndex = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
        }
        return youngestIndex;
    }

    public static int findTallestIndex(double[] heights) {
        int tallestIndex = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }
        return tallestIndex;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ages = new int[3];
        double[] heights = new double[3];
        String[] names = {"Amar", "Akbar", "Anthony"};

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age for " + names[i] + ": ");
            ages[i] = scanner.nextInt();
            System.out.print("Enter height in cm for " + names[i] + ": ");
            heights[i] = scanner.nextDouble();
        }

        int youngestIndex = findYoungestIndex(ages);
        int tallestIndex = findTallestIndex(heights);

        System.out.println("Youngest friend: " + names[youngestIndex] + " with age " + ages[youngestIndex]);
        System.out.println("Tallest friend: " + names[tallestIndex] + " with height " + heights[tallestIndex] + " cm");
        scanner.close();
    }
}
