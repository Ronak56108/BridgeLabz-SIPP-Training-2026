import java.util.Scanner;

public class Level1Programs {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Uncomment the program you want to run

        // divisibleBy5();
        // firstSmallest();
        // largestOfThree();
        // naturalNumberSum();
        // votingEligibility();
        // positiveNegativeZero();
        // springSeason();
        // countdownWhile();
        // countdownFor();
        // sumUntilZero();
        // sumUntilNegativeOrZero();
        // naturalSumWhile();
        // naturalSumFor();
        // factorialWhile();
        // factorialFor();
        // oddEvenNumbers();
        // employeeBonus();
        multiplicationTable();
    }

    // 1. Divisible by 5
    static void divisibleBy5() {
        System.out.print("Enter number: ");
        int number = sc.nextInt();

        System.out.println("Is the number " + number +
                " divisible by 5? " + (number % 5 == 0));
    }

    // 2. First number smallest
    static void firstSmallest() {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        System.out.println("Is the first number the smallest? "
                + (a < b && a < c));
    }

    // 3. Largest of three
    static void largestOfThree() {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        System.out.println("Is the first number the largest? " + (a > b && a > c));
        System.out.println("Is the second number the largest? " + (b > a && b > c));
        System.out.println("Is the third number the largest? " + (c > a && c > b));
    }

    // 4. Natural number sum
    static void naturalNumberSum() {
        int n = sc.nextInt();

        if (n >= 1) {
            int sum = n * (n + 1) / 2;
            System.out.println("The sum of " + n + " natural numbers is " + sum);
        } else {
            System.out.println("The number " + n + " is not a natural number");
        }
    }

    // 5. Voting eligibility
    static void votingEligibility() {
        int age = sc.nextInt();

        if (age >= 18)
            System.out.println("The person's age is " + age + " and can vote.");
        else
            System.out.println("The person's age is " + age + " and cannot vote.");
    }

    // 6. Positive Negative Zero
    static void positiveNegativeZero() {
        int number = sc.nextInt();

        if (number > 0)
            System.out.println("Positive");
        else if (number < 0)
            System.out.println("Negative");
        else
            System.out.println("Zero");
    }

    // 7. Spring Season
    static void springSeason() {
        int month = sc.nextInt();
        int day = sc.nextInt();

        if ((month == 3 && day >= 20) ||
                (month == 4 || month == 5) ||
                (month == 6 && day <= 20))
            System.out.println("Its a Spring Season");
        else
            System.out.println("Not a Spring Season");
    }

    // 8. Countdown using while
    static void countdownWhile() {
        int counter = sc.nextInt();

        while (counter >= 1) {
            System.out.println(counter);
            counter--;
        }
    }

    // 9. Countdown using for
    static void countdownFor() {
        int counter = sc.nextInt();

        for (int i = counter; i >= 1; i--) {
            System.out.println(i);
        }
    }

    // 10. Sum until user enters 0
    static void sumUntilZero() {
        double total = 0;
        double num;

        do {
            num = sc.nextDouble();
            total += num;
        } while (num != 0);

        System.out.println("Total = " + total);
    }

    // 11. Sum until 0 or negative
    static void sumUntilNegativeOrZero() {
        double total = 0;

        while (true) {
            double num = sc.nextDouble();

            if (num <= 0)
                break;

            total += num;
        }

        System.out.println("Total = " + total);
    }

    // 12. Sum of n natural numbers using while
    static void naturalSumWhile() {
        int n = sc.nextInt();

        if (n < 1) {
            System.out.println("Not a Natural Number");
            return;
        }

        int sum = 0;
        int i = 1;

        while (i <= n) {
            sum += i;
            i++;
        }

        int formula = n * (n + 1) / 2;

        System.out.println("While Sum = " + sum);
        System.out.println("Formula Sum = " + formula);
        System.out.println("Both are equal? " + (sum == formula));
    }

    // 13. Sum using for
    static void naturalSumFor() {
        int n = sc.nextInt();

        if (n < 1) {
            System.out.println("Not a Natural Number");
            return;
        }

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        int formula = n * (n + 1) / 2;

        System.out.println("For Sum = " + sum);
        System.out.println("Formula Sum = " + formula);
        System.out.println("Both are equal? " + (sum == formula));
    }

    // 14. Factorial using while
    static void factorialWhile() {
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Invalid Input");
            return;
        }

        long fact = 1;
        int i = 1;

        while (i <= n) {
            fact *= i;
            i++;
        }

        System.out.println("Factorial = " + fact);
    }

    // 15. Factorial using for
    static void factorialFor() {
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Invalid Input");
            return;
        }

        long fact = 1;

        for (int i = 1; i <= n; i++) {
            fact *= i;
        }

        System.out.println("Factorial = " + fact);
    }

    // 16. Odd and Even numbers
    static void oddEvenNumbers() {
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0)
                System.out.println(i + " is Even");
            else
                System.out.println(i + " is Odd");
        }
    }

    // 17. Employee Bonus
    static void employeeBonus() {
        double salary = sc.nextDouble();
        int years = sc.nextInt();

        double bonus = 0;

        if (years > 5)
            bonus = salary * 0.05;

        System.out.println("Bonus Amount = " + bonus);
    }

    // 18. Multiplication table from 6 to 9
    static void multiplicationTable() {
        int number = sc.nextInt();

        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + (number * i));
        }
    }
}
