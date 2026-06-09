

public class CodingGuild {
   

    public static void main(String[] args) {

        // Variables
        String name = "Ravi";
        int age = 22;
        char rank = 'A';
        double salary = 50000.0;
        float membershipFee = 1500.50f;

        // Bonus Calculation
        double annualBonus = salary * 0.12;
        int bonus = (int) annualBonus; // Type Casting

        // Welcome Card
        System.out.println("=================================");
        System.out.println("      WELCOME TO CODING GUILD    ");
        System.out.println("=================================");
        System.out.println("Name           : " + name);
        System.out.println("Age            : " + age);
        System.out.println("Rank           : " + rank);
        System.out.println("Salary         : " + salary);
        System.out.println("Membership Fee : " + membershipFee);
        System.out.println("Annual Bonus   : " + bonus);
        System.out.println("=================================");
    }
}

