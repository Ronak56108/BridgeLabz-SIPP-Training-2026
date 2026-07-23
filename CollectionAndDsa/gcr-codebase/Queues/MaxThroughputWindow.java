import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaxThroughputWindow {
    public static int[] maxThroughputWindow(int[] readings, int k) {
        int n = readings.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && readings[deque.peekLast()] <= readings[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                result[i - k + 1] = readings[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] readings = {10, 20, 5, 25, 15, 30};
        int[] result = maxThroughputWindow(readings, 3);
        System.out.println(Arrays.toString(result));
    }
}
