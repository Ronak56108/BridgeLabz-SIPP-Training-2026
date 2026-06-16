import java.util.HashSet;
import java.util.Set;

public class OTPGenerator {
    public static int generateOTP() {
        return 100000 + (int) (Math.random() * 900000);
    }

    public static boolean uniqueOTPs(int[] otps) {
        Set<Integer> set = new HashSet<>();
        for (int otp : otps) {
            set.add(otp);
        }
        return set.size() == otps.length;
    }

    public static void main(String[] args) {
        int[] otps = new int[10];
        for (int i = 0; i < otps.length; i++) {
            otps[i] = generateOTP();
            System.out.println("OTP " + (i + 1) + ": " + otps[i]);
        }
        System.out.println("All OTPs unique: " + uniqueOTPs(otps));
    }
}
