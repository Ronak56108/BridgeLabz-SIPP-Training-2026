public class AirportSecurityDemo {
    public static void main(String[] args) {
        String[] passengerNames = {"Alice", "Bob", "Charlie"};
        String[] passportNumbers = {"P1234567", "INVALID", "P7654321"};

        AirportSecuritySystem securitySystem = new AirportSecuritySystem();
        for (int i = 0; i < passengerNames.length; i++) {
            System.out.println("Passenger: " + passengerNames[i]);
            System.out.println("Passport: " + passportNumbers[i]);
            if (AirportSecuritySystem.isPassportNumberValid(passportNumbers[i])) {
                System.out.println("Boarding status: Allowed\n");
            } else {
                System.out.println("Boarding status: Denied\n");
            }
        }
    }
}

interface LuggageScanner {
    default void displaySecurityGuidelines() {
        System.out.println("Luggage scanner guidelines: No liquids over 100ml.");
    }
}

interface PassportVerifier {
    static boolean isPassportNumberValid(String passportNo) {
        return passportNo != null && passportNo.matches("P\\d{7}");
    }

    default void displaySecurityGuidelines() {
        System.out.println("Passport verifier guidelines: Passport must be valid and not expired.");
    }
}

class AirportSecuritySystem implements LuggageScanner, PassportVerifier {
    @Override
    public void displaySecurityGuidelines() {
        System.out.println("Airport security guidelines:");
        LuggageScanner.super.displaySecurityGuidelines();
        PassportVerifier.super.displaySecurityGuidelines();
    }
}
