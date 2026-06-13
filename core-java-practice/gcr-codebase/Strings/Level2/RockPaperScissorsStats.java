import java.util.Scanner;

public class RockPaperScissorsStats {
    public static String getComputerChoice() {
        int value = (int) (Math.random() * 3);
        switch (value) {
            case 0:
                return "rock";
            case 1:
                return "paper";
            default:
                return "scissors";
        }
    }

    public static String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "Tie";
        }
        if (userChoice.equals("rock") && computerChoice.equals("scissors")
                || userChoice.equals("paper") && computerChoice.equals("rock")
                || userChoice.equals("scissors") && computerChoice.equals("paper")) {
            return "User";
        }
        return "Computer";
    }

    public static String[][] computeStats(int userWins, int computerWins, int ties, int totalGames) {
        String[][] stats = new String[4][2];
        stats[0][0] = "Total games";
        stats[0][1] = String.valueOf(totalGames);
        stats[1][0] = "User wins";
        stats[1][1] = String.valueOf(userWins);
        stats[2][0] = "Computer wins";
        stats[2][1] = String.valueOf(computerWins);
        double userPercent = totalGames == 0 ? 0 : (userWins * 100.0) / totalGames;
        double computerPercent = totalGames == 0 ? 0 : (computerWins * 100.0) / totalGames;
        stats[3][0] = "User win %";
        stats[3][1] = String.format("%.2f", userPercent);
        return stats;
    }

    public static void displayResults(String[][] rounds, String[][] summary) {
        System.out.printf("%-10s %-15s %-15s %-10s%n", "Game", "User", "Computer", "Winner");
        for (String[] row : rounds) {
            System.out.printf("%-10s %-15s %-15s %-10s%n", row[0], row[1], row[2], row[3]);
        }
        System.out.println("\nSummary:");
        for (String[] row : summary) {
            System.out.printf("%-15s %-10s%n", row[0], row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of games: ");
        int games = scanner.nextInt();
        scanner.nextLine();

        if (games <= 0) {
            System.out.println("Number of games must be positive.");
            scanner.close();
            return;
        }

        String[][] rounds = new String[games][4];
        int userWins = 0;
        int computerWins = 0;

        for (int i = 0; i < games; i++) {
            System.out.print("Enter your choice (rock, paper, scissors) for game " + (i + 1) + ": ");
            String userChoice = scanner.nextLine().trim().toLowerCase();
            String computerChoice = getComputerChoice();
            String winner = determineWinner(userChoice, computerChoice);

            if (winner.equals("User")) {
                userWins++;
            } else if (winner.equals("Computer")) {
                computerWins++;
            }

            rounds[i][0] = String.valueOf(i + 1);
            rounds[i][1] = userChoice;
            rounds[i][2] = computerChoice;
            rounds[i][3] = winner;
        }

        String[][] summary = computeStats(userWins, computerWins, games - userWins - computerWins, games);
        displayResults(rounds, summary);

        scanner.close();
    }
}
