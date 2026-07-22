public class ParkingManagement {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[10];

        vehicles[0] = new Vehicle("V001", "Alice", "Car");
        vehicles[1] = new Vehicle("V002", "Bob", "Bike");
        vehicles[2] = new Vehicle("V003", "Charlie", "Car");
        vehicles[3] = new Vehicle("V004", "David", "Bike");
        vehicles[4] = new Vehicle("V005", "Eva", "Car");
        vehicles[5] = new Vehicle("V006", "Farah", "Bike");
        vehicles[6] = new Vehicle("V007", "Gabe", "Car");
        vehicles[7] = new Vehicle("V008", "Hina", "Bike");
        vehicles[8] = new Vehicle("V009", "Ian", "Car");
        vehicles[9] = new Vehicle("V010", "Jaya", "Bike");

        displayCars(vehicles);
        System.out.println();
        displayBikes(vehicles);
    }

    public static void displayCars(Vehicle[] vehicles) {
        System.out.println("Cars parked in the mall:");
        for (Vehicle vehicle : vehicles) {
            if (vehicle != null && "Car".equalsIgnoreCase(vehicle.getVehicleType())) {
                System.out.println(vehicle);
            }
        }
    }

    public static void displayBikes(Vehicle[] vehicles) {
        System.out.println("Bikes parked in the mall:");
        for (Vehicle vehicle : vehicles) {
            if (vehicle != null && "Bike".equalsIgnoreCase(vehicle.getVehicleType())) {
                System.out.println(vehicle);
            }
        }
    }
}

class Vehicle {
    private String vehicleNumber;
    private String ownerName;
    private String vehicleType;

    public Vehicle(String vehicleNumber, String ownerName, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    @Override
    public String toString() {
        return "VehicleNumber=" + vehicleNumber + ", Owner=" + ownerName + ", Type=" + vehicleType;
    }
}
