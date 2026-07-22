public class ChargingStationDemo {
    public static void main(String[] args) {
        ChargingStation station1 = new ChargingStation("S001", 120);
        ChargingStation station2 = new ChargingStation("S002", 80);
        ChargingStation station3 = new ChargingStation("S003", 150);
        ChargingStation station4 = new ChargingStation("S004", 60);
        ChargingStation station5 = new ChargingStation("S005", 200);

        ChargingStation.setElectricityRate(22.5);

        station1.displayStationDetails();
        station1.calculateBill();
        System.out.println();
        station2.displayStationDetails();
        station2.calculateBill();
        System.out.println();
        station3.displayStationDetails();
        station3.calculateBill();
        System.out.println();
        station4.displayStationDetails();
        station4.calculateBill();
        System.out.println();
        station5.displayStationDetails();
        station5.calculateBill();

        System.out.println();
        System.out.println("Total charging stations created: " + ChargingStation.getTotalStations());
    }
}

class ChargingStation {
    private String stationId;
    private int unitsConsumed;
    private static int totalStations = 0;
    private static double electricityRate = 20.0;

    public ChargingStation(String stationId, int unitsConsumed) {
        this.stationId = stationId;
        this.unitsConsumed = unitsConsumed;
        totalStations++;
    }

    public static void setElectricityRate(double newRate) {
        electricityRate = newRate;
        System.out.println("Electricity rate updated to " + electricityRate + " per unit for all stations.");
    }

    public void calculateBill() {
        double billAmount = unitsConsumed * electricityRate;
        System.out.println("Bill for station " + stationId + ": " + billAmount);
    }

    public void displayStationDetails() {
        System.out.println("Charging Station ID: " + stationId);
        System.out.println("Units Consumed: " + unitsConsumed);
        System.out.println("Current Electricity Rate: " + electricityRate);
    }

    public static int getTotalStations() {
        return totalStations;
    }
}
