public class TollManagementSystemDemo {
    public static void main(String[] args) {
        TollVehicle[] vehicles = {
            new TollCar("C101", "Alice"),
            new TollBus("B202", "Bob"),
            new TollTruck("T303", "Charlie")
        };

        System.out.println("Total Revenue: " + calculateTotalRevenue(vehicles));
        System.out.println("Vehicle with highest toll: " + findHighestTollVehicle(vehicles).getVehicleNumber());
        System.out.println("Cars: " + countByType(vehicles, TollCar.class));
        System.out.println("Buses: " + countByType(vehicles, TollBus.class));
        System.out.println("Trucks: " + countByType(vehicles, TollTruck.class));
    }

    public static double calculateTotalRevenue(TollVehicle[] vehicles) {
        double total = 0;
        for (TollVehicle vehicle : vehicles) {
            total += vehicle.calculateToll();
        }
        return total;
    }

    public static TollVehicle findHighestTollVehicle(TollVehicle[] vehicles) {
        TollVehicle max = vehicles[0];
        for (TollVehicle vehicle : vehicles) {
            if (vehicle.calculateToll() > max.calculateToll()) {
                max = vehicle;
            }
        }
        return max;
    }

    public static int countByType(TollVehicle[] vehicles, Class<?> type) {
        int count = 0;
        for (TollVehicle vehicle : vehicles) {
            if (type.isInstance(vehicle)) {
                count++;
            }
        }
        return count;
    }
}

abstract class TollVehicle {
    private String vehicleNumber;
    private String ownerName;

    public TollVehicle(String vehicleNumber, String ownerName) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public abstract double calculateToll();
}

class TollCar extends TollVehicle {
    public TollCar(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    @Override
    public double calculateToll() {
        return 100;
    }
}

class TollBus extends TollVehicle {
    public TollBus(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    @Override
    public double calculateToll() {
        return 200;
    }
}

class TollTruck extends TollVehicle {
    public TollTruck(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    @Override
    public double calculateToll() {
        return 300;
    }
}
