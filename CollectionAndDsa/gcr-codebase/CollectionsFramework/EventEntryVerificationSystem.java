import java.util.HashSet;
import java.util.Set;

public class EventEntryVerificationSystem {
    private final Set<String> registeredEmails = new HashSet<>();

    public boolean registerParticipant(String email) {
        if (!registeredEmails.add(email)) {
            System.out.println("Duplicate registration rejected for: " + email);
            return false;
        }
        System.out.println("Registered successfully: " + email);
        return true;
    }

    public void displayRegisteredParticipants() {
        System.out.println("\nRegistered Participants (" + registeredEmails.size() + "): ");
        for (String email : registeredEmails) {
            System.out.println(email);
        }
    }

    public static void main(String[] args) {
        EventEntryVerificationSystem eventSystem = new EventEntryVerificationSystem();

        eventSystem.registerParticipant("alice@example.com");
        eventSystem.registerParticipant("bob@example.com");
        eventSystem.registerParticipant("alice@example.com");
        eventSystem.registerParticipant("claire@example.com");

        eventSystem.displayRegisteredParticipants();
    }
}
