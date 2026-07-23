import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SmartCityTrafficMonitoringSystem {
    private final Map<String, Integer> roadTraffic = new HashMap<>();

    public void addOrUpdateRoad(String roadName, int vehicleCount) {
        roadTraffic.merge(roadName, vehicleCount, Integer::sum);
        System.out.println("Updated " + roadName + " with " + vehicleCount + " vehicles.");
    }

    public void displayTrafficReport() {
        TreeMap<String, Integer> sortedRoadTraffic = new TreeMap<>(roadTraffic);
        System.out.println("\nTraffic Report (sorted by road name):");
        for (Map.Entry<String, Integer> entry : sortedRoadTraffic.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " vehicles");
        }
    }

    public void displayBusiestRoad() {
        if (roadTraffic.isEmpty()) {
            System.out.println("No roads monitored yet.");
            return;
        }
        String busiestRoad = null;
        int maxVehicles = -1;
        for (Map.Entry<String, Integer> entry : roadTraffic.entrySet()) {
            if (entry.getValue() > maxVehicles) {
                busiestRoad = entry.getKey();
                maxVehicles = entry.getValue();
            }
        }
        System.out.println("\nBusiest road: " + busiestRoad + " with " + maxVehicles + " vehicles.");
    }

    public void displayTotalRoads() {
        System.out.println("Total roads monitored: " + roadTraffic.size());
    }

    public static void main(String[] args) {
        SmartCityTrafficMonitoringSystem trafficSystem = new SmartCityTrafficMonitoringSystem();

        trafficSystem.addOrUpdateRoad("Main Street", 250);
        trafficSystem.addOrUpdateRoad("Oak Avenue", 180);
        trafficSystem.addOrUpdateRoad("Main Street", 120);
        trafficSystem.addOrUpdateRoad("Park Road", 300);

        trafficSystem.displayTrafficReport();
        trafficSystem.displayBusiestRoad();
        trafficSystem.displayTotalRoads();
    }
}
