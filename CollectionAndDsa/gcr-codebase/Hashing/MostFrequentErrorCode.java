import java.util.HashMap;
import java.util.Map;

public class MostFrequentErrorCode {
    public static int mostFrequentErrorCode(int[] codes) {
        Map<Integer, Integer> freq = new HashMap<>();
        int bestCode = codes[0];
        int bestCount = 0;
        for (int code : codes) {
            int count = freq.merge(code, 1, Integer::sum);
            if (count > bestCount) {
                bestCount = count;
                bestCode = code;
            }
        }
        return bestCode;
    }

    public static void main(String[] args) {
        int[] codes = {500, 404, 500, 503, 500, 404};
        System.out.println(mostFrequentErrorCode(codes));
    }
}
