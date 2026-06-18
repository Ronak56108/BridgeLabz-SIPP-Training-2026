/**
 * Problem 8: Exception Propagation in Methods
 * 
 * Create a Java program with three methods:
 * - method1(): Throws an ArithmeticException (10 / 0).
 * - method2(): Calls method1().
 * - main(): Calls method2() and handles the exception.
 */
public class ExceptionPropagation {
    
    public static void main(String[] args) {
        try {
            method2();
        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main");
        }
    }
    
    /**
     * Method 2: Calls method1()
     */
    public static void method2() {
        method1();
    }
    
    /**
     * Method 1: Throws ArithmeticException
     */
    public static void method1() {
        int result = 10 / 0;  // This will throw ArithmeticException
    }
}
