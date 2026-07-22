public class SpaceTourismReservation {
    public static void main(String[] args) {
        SpaceTourist tourist1 = new SpaceTourist("Alice", 1, "LunarVoyage");
        SpaceTourist tourist2 = new SpaceTourist("Bob", 2, "LunarVoyage");
        SpaceTourist tourist3 = new SpaceTourist("Charlie", 3, "LunarVoyage");

        tourist1.updateSeatNumber(10).updateSeatNumber(15);
        tourist2.updateSeatNumber(5);
        tourist3.updateSeatNumber(8);

        tourist1.displayTouristDetails();
        System.out.println();
        tourist2.displayTouristDetails();
        System.out.println();
        tourist3.displayTouristDetails();

        System.out.println();
        System.out.println("Total reservations: " + SpaceTourist.getTotalReservations());
    }
}

class SpaceTourist {
    private String touristName;
    private int seatNumber;
    private String missionName;
    private static int totalReservations = 0;

    public SpaceTourist(String touristName, int seatNumber, String missionName) {
        this.touristName = touristName;
        this.seatNumber = seatNumber;
        this.missionName = missionName;
        totalReservations++;
    }

    public SpaceTourist updateSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
        return this;
    }

    public void displayTouristDetails() {
        System.out.println("Tourist Name: " + touristName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Mission Name: " + missionName);
    }

    public static int getTotalReservations() {
        return totalReservations;
    }
}
