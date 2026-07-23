import java.util.ArrayList;
import java.util.List;

public class SmartParkingSlotManager {
    private final List<String> parkedVehicles = new ArrayList<>();

    public void enterVehicle(String registrationNumber) {
        if (parkedVehicles.contains(registrationNumber)) {
            System.out.println(registrationNumber + " is already parked.");
            return;
        }
        parkedVehicles.add(registrationNumber);
        System.out.println(registrationNumber + " entered the parking area.");
    }

    public void exitVehicle(String registrationNumber) {
        if (parkedVehicles.remove(registrationNumber)) {
            System.out.println(registrationNumber + " exited the parking area.");
        } else {
            System.out.println(registrationNumber + " is not currently parked.");
        }
    }

    public boolean searchVehicle(String registrationNumber) {
        return parkedVehicles.contains(registrationNumber);
    }

    public void displayParkedVehicles() {
        System.out.println("\nParked Vehicles (" + parkedVehicles.size() + " slots occupied):");
        for (String reg : parkedVehicles) {
            System.out.println(reg);
        }
    }

    public static void main(String[] args) {
        SmartParkingSlotManager parkingManager = new SmartParkingSlotManager();

        parkingManager.enterVehicle("KA01AB1234");
        parkingManager.enterVehicle("MH12CD5678");
        parkingManager.enterVehicle("DL5CAF0001");

        parkingManager.displayParkedVehicles();

        System.out.println("\nSearching for MH12CD5678: " + parkingManager.searchVehicle("MH12CD5678"));
        System.out.println("Searching for TN09XY4321: " + parkingManager.searchVehicle("TN09XY4321"));

        parkingManager.exitVehicle("MH12CD5678");
        parkingManager.displayParkedVehicles();
    }
}}