public class CouponValidatorDemo {
    public static void main(String[] args) {
        String[] coupons = {"SAVE10", "DISCOUNT50", "OFF"};
        ShoppingCart cart = new ShoppingCart();

        for (String coupon : coupons) {
            System.out.println(coupon + ": " + (cart.validateCoupon(coupon) ? "Valid" : "Invalid"));
        }
    }
}

interface CouponValidator {
    boolean validateCoupon(String code);

    static boolean isLengthValid(String code) {
        return code != null && code.length() >= 5 && code.length() <= 12;
    }
}

class ShoppingCart implements CouponValidator {
    @Override
    public boolean validateCoupon(String code) {
        return (CouponValidator.isLengthValid(code) && (code.startsWith("SAVE") || code.startsWith("DISCOUNT")));
    }
}
