import java.util.Scanner;

public class CardDeckDistribution {
    public static String[] initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] deck = new String[suits.length * ranks.length];
        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    public static String[] shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int) (Math.random() * (n - i));
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
        return deck;
    }

    public static String[][] distributeCards(String[] deck, int totalCards, int players) {
        if (totalCards > deck.length || totalCards % players != 0) {
            return null;
        }
        int cardsPerPlayer = totalCards / players;
        String[][] hands = new String[players][cardsPerPlayer];
        for (int i = 0; i < players; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                hands[i][j] = deck[i * cardsPerPlayer + j];
            }
        }
        return hands;
    }

    public static void printHands(String[][] hands) {
        for (int i = 0; i < hands.length; i++) {
            System.out.println("Player " + (i + 1) + ":");
            for (String card : hands[i]) {
                System.out.println("  " + card);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of cards to distribute: ");
        int totalCards = scanner.nextInt();
        System.out.print("Enter number of players: ");
        int players = scanner.nextInt();

        String[] deck = initializeDeck();
        String[] shuffledDeck = shuffleDeck(deck);
        String[][] hands = distributeCards(shuffledDeck, totalCards, players);

        if (hands == null) {
            System.out.println("Cannot distribute " + totalCards + " cards evenly among " + players + " players.");
        } else {
            printHands(hands);
        }
        scanner.close();
    }
}
