public class FleetManagementDemo {
    public static void main(String[] args) {
        FleetVehicle[] fleet = {
            new FleetCar("Car-101", 15.0),
            new FleetBus("Bus-202", 8.0),
            new FleetBike("Bike-303", 2.5)
        };

        double km = 120;
        for (FleetVehicle vehicle : fleet) {
            printFuelDetails(vehicle, km);
        }

        System.out.println("\n-- Adding ElectricCar without changing existing cost logic --");
        FleetVehicle electricCar = new FleetElectricCar("ECar-404", 0.20);
        printFuelDetails(electricCar, km);
    }

    private static void printFuelDetails(FleetVehicle vehicle, double km) {
        System.out.println("Vehicle: " + vehicle.getVehicleNumber() + " (" + vehicle.getType() + ")");
        System.out.println("Fuel cost for " + km + " km: " + vehicle.fuelCost(km));

        if (vehicle instanceof FleetCar) {
            FleetCar car = (FleetCar) vehicle;
            System.out.println("Fuel price per km: " + car.getFuelPricePerKm());
        } else if (vehicle instanceof FleetBus) {
            FleetBus bus = (FleetBus) vehicle;
            System.out.println("Fuel price per km: " + bus.getFuelPricePerKm());
        } else if (vehicle instanceof FleetBike) {
            FleetBike bike = (FleetBike) vehicle;
            System.out.println("Fuel price per km: " + bike.getFuelPricePerKm());
        }

        System.out.println();
    }
}

abstract class FleetVehicle {
    private String vehicleNumber;

    public FleetVehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public abstract double fuelCost(double km);
    public abstract String getType();
}

class FleetCar extends FleetVehicle {
    private double fuelPricePerKm;

    public FleetCar(String vehicleNumber, double fuelPricePerKm) {
        super(vehicleNumber);
        this.fuelPricePerKm = fuelPricePerKm;
    }

    public double getFuelPricePerKm() {
        return fuelPricePerKm;
    }

    @Override
    public double fuelCost(double km) {
        return km * fuelPricePerKm;
    }

    @Override
    public String getType() {
        return "Car";
    }
}

class FleetBus extends FleetVehicle {
    private double fuelPricePerKm;

    public FleetBus(String vehicleNumber, double fuelPricePerKm) {
        super(vehicleNumber);
        this.fuelPricePerKm = fuelPricePerKm;
    }

    public double getFuelPricePerKm() {
        return fuelPricePerKm;
    }

    @Override
    public double fuelCost(double km) {
        return km * fuelPricePerKm * 1.1;
    }

    @Override
    public String getType() {
        return "Bus";
    }
}

class FleetBike extends FleetVehicle {
    private double fuelPricePerKm;

    public FleetBike(String vehicleNumber, double fuelPricePerKm) {
        super(vehicleNumber);
        this.fuelPricePerKm = fuelPricePerKm;
    }

    public double getFuelPricePerKm() {
        return fuelPricePerKm;
    }

    @Override
    public double fuelCost(double km) {
        return km * fuelPricePerKm * 0.8;
    }

    @Override
    public String getType() {
        return "Bike";
    }
}

class FleetElectricCar extends FleetVehicle {
    private double electricityRatePerKm;

    public FleetElectricCar(String vehicleNumber, double electricityRatePerKm) {
        super(vehicleNumber);
        this.electricityRatePerKm = electricityRatePerKm;
    }

    @Override
    public double fuelCost(double km) {
        return km * electricityRatePerKm;
    }

    @Override
    public String getType() {
        return "ElectricCar";
    }
}
