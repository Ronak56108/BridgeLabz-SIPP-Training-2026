import java.util.Scanner;

/**
 * Problem 9: Nested try-catch Block
 * 
 * Write a Java program that:
 * - Takes an array and a divisor as input.
 * - Tries to access an element at an index.
 * - Tries to divide that element by the divisor.
 * - Uses nested try-catch to handle both exceptions.
 */
public class NestedTryCatch {
    
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
            
            System.out.print("Enter index to access: ");
            int index = scanner.nextInt();
            
            System.out.print("Enter divisor: ");
            int divisor = scanner.nextInt();
            
            try {
                int element = array[index];
                System.out.println("Element at index " + index + ": " + element);
                
                try {
                    int result = element / divisor;
                    System.out.println("Division result: " + result);
                } catch (ArithmeticException e) {
                    System.out.println("Cannot divide by zero!");
                }
                
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            }
            
        } finally {
            scanner.close();
        }
    }
}
