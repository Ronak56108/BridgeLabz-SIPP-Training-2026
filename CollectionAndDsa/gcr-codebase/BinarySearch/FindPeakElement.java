public class FindPeakElement {
    public static int findPeak(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] values = {1, 3, 20, 4, 1, 0};
        int peakIndex = findPeak(values);
        System.out.println("Peak element index: " + peakIndex);
        System.out.println("Peak element value: " + values[peakIndex]);
    }
}
