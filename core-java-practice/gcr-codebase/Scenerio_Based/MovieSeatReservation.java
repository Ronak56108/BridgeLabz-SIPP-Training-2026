import java.util.Scanner;

/**
 * Problem 3: Movie Seat Reservation
 * 
 * An array stores booked seat numbers.
 * int seats[] = {101,102,103,104,105};
 * 
 * Scenario: A customer requests a seat at position 8.
 * 
 * Task:
 * - Create a method getSeat(int index)
 * - Return seat number if valid
 * - Handle invalid access inside the method
 * - Return -1 when an exception occurs
 */
public class MovieSeatReservation {
    
    private int[] seats;
    private boolean[] isBooked;
    private String[] bookedBy;
    
    public MovieSeatReservation(int totalSeats) {
        this.seats = new int[totalSeats];
        this.isBooked = new boolean[totalSeats];
        this.bookedBy = new String[totalSeats];
        
        // Initialize seat numbers
        for (int i = 0; i < totalSeats; i++) {
            this.seats[i] = 101 + i;
            this.isBooked[i] = false;
        }
    }
    
    /**
     * Get seat number at specified index
     * Returns -1 if index is invalid
     * 
     * @param index the seat position
     * @return seat number if valid, -1 if invalid
     */
    public int getSeat(int index) {
        try {
            if (index < 0) {
                throw new ArrayIndexOutOfBoundsException("Index cannot be negative");
            }
            
            int seatNumber = seats[index];
            return seatNumber;
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid seat index " + index + 
                             ". Available seats: 0 to " + (seats.length - 1));
            return -1;
        }
    }
    
    /**
     * Book a seat for a customer
     */
    public void bookSeat(int index, String customerName) {
        try {
            if (index < 0 || index >= seats.length) {
                throw new ArrayIndexOutOfBoundsException("Invalid seat index");
            }
            
            if (isBooked[index]) {
                System.out.println("Error: Seat " + seats[index] + " is already booked!");
                return;
            }
            
            isBooked[index] = true;
            bookedBy[index] = customerName;
            System.out.println("✓ Seat " + seats[index] + " booked successfully for " + customerName);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid seat index");
        }
    }
    
    /**
     * Display available seats
     */
    public void displayAvailableSeats() {
        System.out.println("\n--- Available Seats ---");
        boolean foundAvailable = false;
        
        for (int i = 0; i < seats.length; i++) {
            if (!isBooked[i]) {
                System.out.print(seats[i] + " ");
                foundAvailable = true;
            }
        }
        
        if (!foundAvailable) {
            System.out.println("No seats available!");
        } else {
            System.out.println();
        }
    }
    
    /**
     * Display booked seats
     */
    public void displayBookedSeats() {
        System.out.println("\n--- Booked Seats ---");
        boolean foundBooked = false;
        
        for (int i = 0; i < seats.length; i++) {
            if (isBooked[i]) {
                System.out.println(seats[i] + " - Booked by: " + bookedBy[i]);
                foundBooked = true;
            }
        }
        
        if (!foundBooked) {
            System.out.println("No seats booked yet!");
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieSeatReservation theater = new MovieSeatReservation(5);
        
        System.out.println("=== Movie Seat Reservation System ===");
        theater.displayAvailableSeats();
        
        // Test: Get valid seat
        System.out.println("\n--- Testing getSeat() method ---");
        System.out.println("Seat at index 0: " + theater.getSeat(0));
        System.out.println("Seat at index 2: " + theater.getSeat(2));
        
        // Test: Get invalid seat (out of bounds)
        System.out.println("Seat at index 8: " + theater.getSeat(8));
        System.out.println("Seat at index -1: " + theater.getSeat(-1));
        
        // Interactive menu
        boolean running = true;
        while (running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Book a seat");
            System.out.println("2. View available seats");
            System.out.println("3. View booked seats");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear newline
                
                switch (choice) {
                    case 1:
                        System.out.print("Enter seat index (0-4): ");
                        int index = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter customer name: ");
                        String name = scanner.nextLine();
                        theater.bookSeat(index, name);
                        break;
                        
                    case 2:
                        theater.displayAvailableSeats();
                        break;
                        
                    case 3:
                        theater.displayBookedSeats();
                        break;
                        
                    case 4:
                        running = false;
                        System.out.println("Thank you for using our reservation system!");
                        break;
                        
                    default:
                        System.out.println("Invalid option!");
                }
            } catch (Exception e) {
                System.out.println("Error: Invalid input");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
}
