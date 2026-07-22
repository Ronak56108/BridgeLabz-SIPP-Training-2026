public class ContentModerationDemo {
    public static void main(String[] args) {
        String[] posts = {
            "Buy cheap watches now",
            "This is an offensive post with bad words",
            "Hello everyone, welcome to the community"
        };

        ContentModerator moderator = new ContentModerator();
        for (String post : posts) {
            System.out.println("Post: " + post);
            if (ContentModerator.containsRestrictedWords(post)) {
                System.out.println("Result: Offensive post\n");
            } else if (moderator.isSpam(post)) {
                System.out.println("Result: Spam post\n");
            } else {
                System.out.println("Result: Valid post\n");
            }
        }
    }
}

interface TextModeration {
    boolean isOffensive(String post);

    default void displayModerationPolicy() {
        System.out.println("Text moderation policy: No abusive language allowed.");
    }
}

interface SpamDetection {
    boolean isSpam(String post);

    default void displayModerationPolicy() {
        System.out.println("Spam detection policy: No promotional or repetitive spam allowed.");
    }
}

class ContentModerator implements TextModeration, SpamDetection {
    @Override
    public boolean isOffensive(String post) {
        return post.toLowerCase().contains("offensive") || post.toLowerCase().contains("bad words");
    }

    @Override
    public boolean isSpam(String post) {
        return post.toLowerCase().contains("buy cheap") || post.toLowerCase().contains("discount");
    }

    @Override
    public void displayModerationPolicy() {
        System.out.println("Content moderation policy:");
        TextModeration.super.displayModerationPolicy();
        SpamDetection.super.displayModerationPolicy();
    }

    public static boolean containsRestrictedWords(String post) {
        return post.toLowerCase().contains("offensive") || post.toLowerCase().contains("bad words");
    }
}
