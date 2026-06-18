package recursion.scenerio_based;

/**
 * Username Validator
 *
 * A platform requires usernames to contain only lowercase letters.
 * Task: Recursively verify whether a username is valid.
 *
 * Example:
 * Input: "abcdxyz"
 * Output: true
 *
 * Input: "abcD123"
 * Output: false
 */
public class UsernameValidator {

    public static boolean isValidUsername(String username) {
        return isValidUsername(username, 0);
    }

    private static boolean isValidUsername(String username, int index) {
        if (index >= username.length()) {
            return true;
        }
        char ch = username.charAt(index);
        if (ch < 'a' || ch > 'z') {
            return false;
        }
        return isValidUsername(username, index + 1);
    }

    public static void main(String[] args) {
        System.out.println(isValidUsername("abcdxyz"));
        System.out.println(isValidUsername("abcD123"));
    }
}
