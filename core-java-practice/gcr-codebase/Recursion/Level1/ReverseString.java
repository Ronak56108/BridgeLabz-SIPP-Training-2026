package recursion.level2;

/**
 * Reverse a String
 * 
 * Description:
 * Write a recursive function to reverse a string.
 * 
 * Input: "hello"
 * Output: "olleh"
 * 
 * Approach:
 * - Base case: if string length <= 1, return the string
 * - Recursive case: reverse(rest) + first_character
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N) - due to recursion stack and string concatenation
 */
public class ReverseString {
    
    public static String reverseString(String str) {
        // Base case
        if (str.length() <= 1) {
            return str;
        }
        
        // Recursive case: reverse(substring) + first_character
        return reverseString(str.substring(1)) + str.charAt(0);
    }
    
    public static void main(String[] args) {
        System.out.println("Reverse a String");
        
        String[] testCases = {"hello", "java", "recursion", "a", ""};
        
        for (String test : testCases) {
            String reversed = reverseString(test);
            System.out.println("'" + test + "' -> '" + reversed + "'");
        }
    }
}
