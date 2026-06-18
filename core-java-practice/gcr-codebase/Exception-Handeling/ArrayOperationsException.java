import java.util.Scanner;

/**
 * Problem 4: Array Operations Exception Handling
 * 
 * Create a Java program that performs array operations.
 * Accept an integer array and an index number.
 * Handle ArrayIndexOutOfBoundsException and NullPointerException.
 */
public class ArrayOperationsException {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter array size: ");
            int size = scanner.nextInt();
            int[] array = new int[size];
            
            System.out.println("Enter array elements:");
            for (int i = 0; i < size; i++) {
                System.out.print("Element " + (i + 1) + ": ");
                array[i] = scanner.nextInt();
            }
            
            System.out.print("Enter index to retrieve: ");
            int index = scanner.nextInt();
            
            retrieveElement(array, index);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        } finally {
            scanner.close();
        }
    }
    
    /**
     * Retrieves and prints the element at the specified index
     * @param array the array
     * @param index the index to retrieve
     */
    public static void retrieveElement(int[] array, int index) {
        if (array == null) {
            throw new NullPointerException("Array is null");
        }
        
        int value = array[index];
        System.out.println("Value at index " + index + ": " + value);
    }
}
