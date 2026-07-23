public class CPUSpikeDetectionSlidingWindow {
    public static int maxSubarrayOfSizeK(int[] cpuLoad, int k) {
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        for (int end = 0; end < cpuLoad.length; end++) {
            windowSum += cpuLoad[end];
            if (end >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= cpuLoad[start];
                start++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] cpuLoad = {20, 30, 50, 10, 40, 60, 55};
        int k = 5;
        System.out.println("Max CPU load over " + k + " seconds: " + maxSubarrayOfSizeK(cpuLoad, k));
    }
}
