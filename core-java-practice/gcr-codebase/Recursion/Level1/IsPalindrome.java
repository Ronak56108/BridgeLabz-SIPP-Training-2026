package recursion.level2;

/**
 * Check if String is Palindrome
 * 
 * Description:
 * Write a recursive function to check if a string is a palindrome.
 * 
 * Input: "racecar"
 * Output: true
 * 
 * Input: "hello"
 * Output: false
 * 
 * Approach:
 * - Use two pointers: left and right
 * - Base case: if left >= right, it's a palindrome
 * - Recursive case: check if characters match and recurse inward
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N) - due to recursion stack
 */
public class IsPalindrome {
    
    public static boolean isPalindrome(String str) {
        return isPalindromeHelper(str, 0, str.length() - 1);
    }
    
    private static boolean isPalindromeHelper(String str, int left, int right) {
        // Base case: if pointers cross or meet, it's a palindrome
        if (left >= right) {
            return true;
        }
        
        // If characters don't match, it's not a palindrome
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }
        
        // Recursive case: check inner characters
        return isPalindromeHelper(str, left + 1, right - 1);
    }
    
    public static void main(String[] args) {
        System.out.println("Check if String is Palindrome");
        
        String[] testCases = {"racecar", "hello", "madam", "noon", "java", "a", "ab"};
        
        for (String test : testCases) {
            boolean result = isPalindrome(test);
            System.out.println("'" + test + "' is palindrome: " + result);
        }
    }
}
