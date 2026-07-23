public class BubbleSortProductPrices {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] prices = {450, 120, 780, 300, 250, 600};
        bubbleSort(prices);
        System.out.print("Sorted product prices: ");
        for (int price : prices) {
            System.out.print(price + " ");
        }
    }
}
