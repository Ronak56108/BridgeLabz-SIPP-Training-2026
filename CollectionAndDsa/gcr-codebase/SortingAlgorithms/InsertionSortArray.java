public class InsertionSortArray {
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {12, 11, 13, 5, 6};
        int[] nums2 = {5, 4, 3, 2, 1};

        insertionSort(nums1);
        insertionSort(nums2);

        System.out.print("Sorted nums1: ");
        for (int num : nums1) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("Sorted nums2: ");
        for (int num : nums2) {
            System.out.print(num + " ");
        }
    }
}
