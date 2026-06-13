public class NullPointerExceptionDemo {
    public static void generateNullPointerException() {
        String text = null;
        System.out.println("Generating NullPointerException...");
        System.out.println("Text length: " + text.length());
    }

    public static void handleNullPointerException() {
        String text = null;
        System.out.println("Handling NullPointerException...");
        try {
            System.out.println("Text length: " + text.length());
        } catch (NullPointerException exception) {
            System.out.println("Caught NullPointerException: " + exception.getMessage());
        } catch (RuntimeException exception) {
            System.out.println("Caught RuntimeException: " + exception.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("--- NullPointerException Demo ---");
        try {
            generateNullPointerException();
        } catch (NullPointerException exception) {
            System.out.println("Exception caught in main(): " + exception);
        }

        handleNullPointerException();
    }
}
