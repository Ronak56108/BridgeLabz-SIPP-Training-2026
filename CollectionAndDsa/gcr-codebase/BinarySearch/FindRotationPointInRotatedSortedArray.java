public class FindRotationPointInRotatedSortedArray {
    public static int findRotationPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] rotated = {15, 18, 22, 25, 1, 5, 9, 12};
        int index = findRotationPoint(rotated);
        System.out.println("Rotation point index: " + index);
        System.out.println("Rotation point value: " + rotated[index]);
    }
}
