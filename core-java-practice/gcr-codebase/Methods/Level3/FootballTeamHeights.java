import java.util.Arrays;
import java.util.Random;

public class FootballTeamHeights {
    public static int[] generateHeights(int size) {
        int[] heights = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            heights[i] = 150 + random.nextInt(101); // 150 to 250 inclusive
        }
        return heights;
    }

    public static int sum(int[] values) {
        int total = 0;
        for (int value : values) {
            total += value;
        }
        return total;
    }

    public static double mean(int[] values) {
        return (double) sum(values) / values.length;
    }

    public static int shortest(int[] values) {
        int min = values[0];
        for (int value : values) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    public static int tallest(int[] values) {
        int max = values[0];
        for (int value : values) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] heights = generateHeights(11);
        System.out.println("Player heights (cm): " + Arrays.toString(heights));
        System.out.println("Shortest height: " + shortest(heights) + " cm");
        System.out.println("Tallest height: " + tallest(heights) + " cm");
        System.out.printf("Mean height: %.2f cm%n", mean(heights));
    }
}
