import java.util.HashSet;
import java.util.Set;

public class DuplicateSessionTokenDetection {
    public static boolean hasDuplicateToken(String[] tokens) {
        Set<String> seen = new HashSet<>();
        for (String token : tokens) {
            if (!seen.add(token)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] tokens = {"abc", "def", "ghi", "def"};
        System.out.println(hasDuplicateToken(tokens));
    }
}
