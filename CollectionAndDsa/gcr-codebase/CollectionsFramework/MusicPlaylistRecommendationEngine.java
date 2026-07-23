import java.util.LinkedList;

public class MusicPlaylistRecommendationEngine {
    private static final int MAX_HISTORY = 10;
    private final LinkedList<String> recentlyPlayed = new LinkedList<>();

    public void playSong(String songTitle) {
        recentlyPlayed.remove(songTitle);
        recentlyPlayed.addFirst(songTitle);
        if (recentlyPlayed.size() > MAX_HISTORY) {
            String removed = recentlyPlayed.removeLast();
            System.out.println("Removed oldest song from history: " + removed);
        }
        System.out.println("Played song: " + songTitle);
    }

    public boolean searchSong(String songTitle) {
        return recentlyPlayed.contains(songTitle);
    }

    public void displayHistory() {
        System.out.println("\nRecently Played Songs:");
        for (String song : recentlyPlayed) {
            System.out.println(song);
        }
    }

    public static void main(String[] args) {
        MusicPlaylistRecommendationEngine engine = new MusicPlaylistRecommendationEngine();

        engine.playSong("Shape of You");
        engine.playSong("Bohemian Rhapsody");
        engine.playSong("Blinding Lights");
        engine.playSong("Levitating");
        engine.playSong("Heat Waves");
        engine.playSong("Bad Guy");
        engine.playSong("Old Town Road");
        engine.playSong("Havana");
        engine.playSong("Peaches");
        engine.playSong("Sunflower");
        engine.playSong("Save Your Tears");

        engine.displayHistory();
        System.out.println("\nSearch for 'Havana': " + engine.searchSong("Havana"));
    }
}
