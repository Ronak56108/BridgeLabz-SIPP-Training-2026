package recursion.scenerio_based;

/**
 * Consecutive Sensor Readings
 *
 * A sensor records temperature readings every minute.
 * Task: Recursively determine whether the readings are strictly increasing.
 *
 * Example:
 * Input: [12, 15, 18, 22, 30]
 * Output: true
 *
 * Input: [12, 15, 14, 22]
 * Output: false
 */
public class ConsecutiveSensorReadings {

    public static boolean areReadingsStrictlyIncreasing(int[] readings) {
        return areReadingsStrictlyIncreasing(readings, 1);
    }

    private static boolean areReadingsStrictlyIncreasing(int[] readings, int index) {
        if (index >= readings.length) {
            return true;
        }
        if (readings[index] <= readings[index - 1]) {
            return false;
        }
        return areReadingsStrictlyIncreasing(readings, index + 1);
    }

    public static void main(String[] args) {
        int[] input1 = {12, 15, 18, 22, 30};
        System.out.println(areReadingsStrictlyIncreasing(input1));

        int[] input2 = {12, 15, 14, 22};
        System.out.println(areReadingsStrictlyIncreasing(input2));
    }
}
