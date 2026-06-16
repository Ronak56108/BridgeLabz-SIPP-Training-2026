public class SpringSeason {
    public static boolean isSpringSeason(int month, int day) {
        if (month < 3 || month > 6 || day < 1 || day > 31) {
            return false;
        }
        if (month == 3 && day < 20) {
            return false;
        }
        if (month == 6 && day > 20) {
            return false;
        }
        return month > 3 && month < 6 || month == 3 || month == 6;
    }

    public static void main(String[] args) {
        int month;
        int day;
        if (args.length >= 2) {
            month = Integer.parseInt(args[0]);
            day = Integer.parseInt(args[1]);
        } else {
            System.out.println("Please run with month and day arguments, e.g. java SpringSeason 4 15");
            return;
        }

        boolean isSpring = isSpringSeason(month, day);
        if (isSpring) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}
