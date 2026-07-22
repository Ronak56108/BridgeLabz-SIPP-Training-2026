public class DroneDeliverySystem {
    public static void main(String[] args) {
        Drone drone1 = new Drone("D001", 85);
        Drone drone2 = new Drone("D002", 70);
        Drone drone3 = new Drone("D003", 95);

        drone1.startDelivery();
        drone2.displayStatus();
        drone3.startDelivery();

        System.out.println();
        System.out.println("Company name shared by all drones: " + Drone.getCompanyName());
        System.out.println("Drone 1 company: " + drone1.getCompanyName());
        System.out.println("Drone 2 company: " + drone2.getCompanyName());
        System.out.println("Drone 3 company: " + drone3.getCompanyName());
    }
}

class Drone {
    private String droneId;
    private int batteryPercentage;
    private static String companyName = "SkyCourier";

    public Drone(String droneId, int batteryPercentage) {
        this.droneId = droneId;
        this.batteryPercentage = batteryPercentage;
    }

    public void startDelivery() {
        System.out.println("Drone " + droneId + " is starting delivery. Battery: " + batteryPercentage + "%");
    }

    public void displayStatus() {
        System.out.println("Drone " + droneId + " status -> Battery: " + batteryPercentage + "% | Company: " + companyName);
    }

    public static String getCompanyName() {
        return companyName;
    }
}
