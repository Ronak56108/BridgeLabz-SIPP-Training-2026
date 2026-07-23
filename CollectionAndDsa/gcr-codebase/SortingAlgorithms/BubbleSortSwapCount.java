public class BubbleSortSwapCount {
    public static int bubbleSortAndCount(int[] arr) {
        int n = arr.length;
        int swapCount = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapCount++;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return swapCount;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 3, 2, 1};
        int[] nums2 = {1, 2, 3};

        System.out.println("Swaps for [4,3,2,1]: " + bubbleSortAndCount(nums1));
        System.out.println("Swaps for [1,2,3]: " + bubbleSortAndCount(nums2));
    }
}
