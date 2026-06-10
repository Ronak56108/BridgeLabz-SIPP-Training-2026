import java.util.Scanner;

public class Level2Programs {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Uncomment any one method to run

        // oddEven();
        // employeeBonus();
        // multiplicationTable();
        // fizzBuzzFor();
        // fizzBuzzWhile();
        // youngestAndTallest();
        // factorsFor();
        // factorsWhile();
        // greatestFactorFor();
        // greatestFactorWhile();
        // multiplesBelow100For();
        // powerFor();
        // multiplesBelow100While();
        powerWhile();
    }

    // 1. Odd and Even Numbers
    static void oddEven() {
        int number = sc.nextInt();

        if (number <= 0) {
            System.out.println("Not a Natural Number");
            return;
        }

        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0)
                System.out.println(i + " is Even");
            else
                System.out.println(i + " is Odd");
        }
    }

    // 2. Employee Bonus
    static void employeeBonus() {
        double salary = sc.nextDouble();
        int years = sc.nextInt();

        double bonus = 0;

        if (years > 5)
            bonus = salary * 0.05;

        System.out.println("Bonus Amount = " + bonus);
    }

    // 3. Multiplication Table (6 to 9)
    static void multiplicationTable() {
        int number = sc.nextInt();

        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + (number * i));
        }
    }

    // 4. FizzBuzz using For Loop
    static void fizzBuzzFor() {
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Enter Positive Integer");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0)
                System.out.println("FizzBuzz");
            else if (i % 3 == 0)
                System.out.println("Fizz");
            else if (i % 5 == 0)
                System.out.println("Buzz");
            else
                System.out.println(i);
        }
    }

    // 5. FizzBuzz using While Loop
    static void fizzBuzzWhile() {
        int n = sc.nextInt();
        int i = 1;

        while (i <= n) {
            if (i % 3 == 0 && i % 5 == 0)
                System.out.println("FizzBuzz");
            else if (i % 3 == 0)
                System.out.println("Fizz");
            else if (i % 5 == 0)
                System.out.println("Buzz");
            else
                System.out.println(i);

            i++;
        }
    }

    // 6. Youngest and Tallest Friend
    static void youngestAndTallest() {

        int amarAge = sc.nextInt();
        int akbarAge = sc.nextInt();
        int anthonyAge = sc.nextInt();

        double amarHeight = sc.nextDouble();
        double akbarHeight = sc.nextDouble();
        double anthonyHeight = sc.nextDouble();

        int minAge = Math.min(amarAge,
                Math.min(akbarAge, anthonyAge));

        double maxHeight = Math.max(amarHeight,
                Math.max(akbarHeight, anthonyHeight));

        if (minAge == amarAge)
            System.out.println("Youngest: Amar");
        else if (minAge == akbarAge)
            System.out.println("Youngest: Akbar");
        else
            System.out.println("Youngest: Anthony");

        if (maxHeight == amarHeight)
            System.out.println("Tallest: Amar");
        else if (maxHeight == akbarHeight)
            System.out.println("Tallest: Akbar");
        else
            System.out.println("Tallest: Anthony");
    }

    // 7. Factors using For Loop
    static void factorsFor() {
        int number = sc.nextInt();

        for (int i = 1; i < number; i++) {
            if (number % i == 0)
                System.out.print(i + " ");
        }
    }

    // 8. Factors using While Loop
    static void factorsWhile() {
        int number = sc.nextInt();
        int i = 1;

        while (i < number) {
            if (number % i == 0)
                System.out.print(i + " ");

            i++;
        }
    }

    // 9. Greatest Factor using For Loop
    static void greatestFactorFor() {
        int number = sc.nextInt();
        int greatestFactor = 1;

        for (int i = number - 1; i >= 1; i--) {
            if (number % i == 0) {
                greatestFactor = i;
                break;
            }
        }

        System.out.println(greatestFactor);
    }

    // 10. Greatest Factor using While Loop
    static void greatestFactorWhile() {
        int number = sc.nextInt();
        int greatestFactor = 1;

        int counter = number - 1;

        while (counter >= 1) {
            if (number % counter == 0) {
                greatestFactor = counter;
                break;
            }
            counter--;
        }

        System.out.println(greatestFactor);
    }

    // 11. Multiples Below 100 using For Loop
    static void multiplesBelow100For() {
        int number = sc.nextInt();

        if (number <= 0 || number >= 100)
            return;

        for (int i = 100; i >= 1; i--) {
            if (i % number == 0)
                System.out.print(i + " ");
        }
    }

    // 12. Power using For Loop
    static void powerFor() {
        int number = sc.nextInt();
        int power = sc.nextInt();

        long result = 1;

        for (int i = 1; i <= power; i++) {
            result *= number;
        }

        System.out.println(result);
    }

    // 13. Multiples Below 100 using While Loop
    static void multiplesBelow100While() {
        int number = sc.nextInt();

        int counter = 100;

        while (counter >= 1) {
            if (counter % number == 0)
                System.out.print(counter + " ");

            counter--;
        }
    }

    // 14. Power using While Loop
    static void powerWhile() {
        int number = sc.nextInt();
        int power = sc.nextInt();

        long result = 1;
        int counter = 0;

        while (counter < power) {
            result *= number;
            counter++;
        }

        System.out.println(result);
    }
}
