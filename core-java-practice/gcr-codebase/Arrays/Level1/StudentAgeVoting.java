import java.util.Scanner;

public class StudentAgeVoting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] ages = new int[10];

        System.out.println("Enter the ages of 10 students:");
        for (int index = 0; index < ages.length; index++) {
            System.out.print("Age for student " + (index + 1) + ": ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Age must be an integer.");
                scanner.close();
                return;
            }
            ages[index] = scanner.nextInt();
        }

        for (int age : ages) {
            if (age < 0) {
                System.out.println("Invalid age: " + age);
            } else if (age >= 18) {
                System.out.println("The student with the age " + age + " can vote.");
            } else {
                System.out.println("The student with the age " + age + " cannot vote.");
            }
        }

        scanner.close();
    }
}