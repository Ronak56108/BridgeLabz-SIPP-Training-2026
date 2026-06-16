public class NumberCheckerPerfectAbundantDeficient {
    public static int sumOfProperDivisors(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static boolean isPerfect(int number) {
        return number > 0 && sumOfProperDivisors(number) == number;
    }

    public static boolean isAbundant(int number) {
        return number > 0 && sumOfProperDivisors(number) > number;
    }

    public static boolean isDeficient(int number) {
        return number > 0 && sumOfProperDivisors(number) < number;
    }

    public static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static boolean isStrong(int number) {
        int sum = 0;
        int temp = Math.abs(number);
        while (temp > 0) {
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }
        return sum == number;
    }

    public static void main(String[] args) {
        int number = 145;
        System.out.println("Number: " + number);
        System.out.println("Perfect: " + isPerfect(number));
        System.out.println("Abundant: " + isAbundant(number));
        System.out.println("Deficient: " + isDeficient(number));
        System.out.println("Strong: " + isStrong(number));
    }
}
