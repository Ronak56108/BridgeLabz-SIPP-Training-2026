import java.util.Scanner;

/**
 * LeetCode Problem 4: Add Binary - Problem 67
 * 
 * Given two binary strings a and b, return their sum as a binary string.
 * 
 * Example 1: a = "11", b = "1" → Output: "100"
 * Example 2: a = "1010", b = "1011" → Output: "10101"
 */
public class AddBinary {
    
    /**
     * Add two binary strings and return result as binary string
     * Time Complexity: O(max(len(a), len(b)))
     * Space Complexity: O(max(len(a), len(b)))
     */
    public static String addBinary(String a, String b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Input strings cannot be null");
        }
        
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            
            result.append(sum % 2);
            carry = sum / 2;
        }
        
        return result.reverse().toString();
    }
    
    /**
     * Validate binary string
     */
    public static boolean isValidBinary(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        
        for (char c : s.toCharArray()) {
            if (c != '0' && c != '1') {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Convert binary string to decimal
     */
    public static long binaryToDecimal(String binary) {
        return Long.parseLong(binary, 2);
    }
    
    /**
     * Convert decimal to binary string
     */
    public static String decimalToBinary(long decimal) {
        if (decimal < 0) {
            throw new IllegalArgumentException("Decimal value cannot be negative");
        }
        return Long.toBinaryString(decimal);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter first binary number: ");
            String a = scanner.nextLine().trim();
            
            System.out.print("Enter second binary number: ");
            String b = scanner.nextLine().trim();
            
            // Validate inputs
            if (!isValidBinary(a)) {
                throw new IllegalArgumentException("First input is not a valid binary string");
            }
            
            if (!isValidBinary(b)) {
                throw new IllegalArgumentException("Second input is not a valid binary string");
            }
            
            String sum = addBinary(a, b);
            
            System.out.println("\n--- Result ---");
            System.out.println("Binary addition:");
            System.out.println(a + " + " + b + " = " + sum);
            
            // Show decimal equivalents
            long decimalA = binaryToDecimal(a);
            long decimalB = binaryToDecimal(b);
            long decimalSum = binaryToDecimal(sum);
            
            System.out.println("\nDecimal equivalents:");
            System.out.println(decimalA + " + " + decimalB + " = " + decimalSum);
            
            // Test cases
            System.out.println("\n--- Test Cases ---");
            
            String test1a = "11";
            String test1b = "1";
            System.out.println("Test 1: \"" + test1a + "\" + \"" + test1b + "\" = \"" + 
                             addBinary(test1a, test1b) + "\"");
            
            String test2a = "1010";
            String test2b = "1011";
            System.out.println("Test 2: \"" + test2a + "\" + \"" + test2b + "\" = \"" + 
                             addBinary(test2a, test2b) + "\"");
            
            String test3a = "1111";
            String test3b = "1111";
            System.out.println("Test 3: \"" + test3a + "\" + \"" + test3b + "\" = \"" + 
                             addBinary(test3a, test3b) + "\"");
            
            String test4a = "0";
            String test4b = "0";
            System.out.println("Test 4: \"" + test4a + "\" + \"" + test4b + "\" = \"" + 
                             addBinary(test4a, test4b) + "\"");
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
