public class SelectionSortMovieRatings {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] ratings = {8, 5, 9, 7, 6, 10};
        selectionSort(ratings);
        System.out.print("Sorted movie ratings: ");
        for (int rating : ratings) {
            System.out.print(rating + " ");
        }
    }
}
