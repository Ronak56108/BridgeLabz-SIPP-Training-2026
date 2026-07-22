public class SmartTVDemo {
    public static void main(String[] args) {
        SmartTV smartTV = new SmartTV();
        smartTV.showSubscriptionDetails();
        smartTV.displayContent();
    }
}

interface StreamingService {
    void streamMovie(String movie);

    default void showSubscriptionDetails() {
        System.out.println("Streaming subscription: Premium plan.");
    }
}

interface GamingService {
    void playGame(String game);

    default void showSubscriptionDetails() {
        System.out.println("Gaming subscription: Gamer package.");
    }
}

class SmartTV implements StreamingService, GamingService {
    private String[] movies = {"Inception", "The Matrix", "Interstellar"};
    private String[] games = {"FIFA 23", "Minecraft", "Call of Duty"};

    @Override
    public void showSubscriptionDetails() {
        System.out.println("SmartTV subscriptions:");
        StreamingService.super.showSubscriptionDetails();
        GamingService.super.showSubscriptionDetails();
    }

    @Override
    public void streamMovie(String movie) {
        System.out.println("Streaming movie: " + movie);
    }

    @Override
    public void playGame(String game) {
        System.out.println("Playing game: " + game);
    }

    public void displayContent() {
        System.out.println("Available movies:");
        for (String movie : movies) {
            System.out.println("- " + movie);
        }
        System.out.println("Available games:");
        for (String game : games) {
            System.out.println("- " + game);
        }
    }
}
