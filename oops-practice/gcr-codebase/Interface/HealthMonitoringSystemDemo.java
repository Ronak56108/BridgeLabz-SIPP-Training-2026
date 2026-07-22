public class HealthMonitoringSystemDemo {
    public static void main(String[] args) {
        String[] patientNames = {"Alice", "Bob", "Charlie"};
        String[] patientIds = {"PID001", "INVALID", "PID003"};
        int[] heartRates = {72, 95, 60};
        double[] temperatures = {36.5, 38.2, 37.0};

        HealthMonitoringSystem system = new HealthMonitoringSystem();
        for (int i = 0; i < patientNames.length; i++) {
            System.out.println("Patient: " + patientNames[i]);
            if (!HealthMonitoringSystem.isPatientIdValid(patientIds[i])) {
                System.out.println("Invalid patient ID: " + patientIds[i] + "\n");
                continue;
            }
            system.displayHealthTips();
            system.displayHealthReading(patientNames[i], heartRates[i], temperatures[i]);
            System.out.println();
        }
    }
}

interface HeartRateMonitor {
    default void displayHealthTips() {
        System.out.println("Heart rate tip: Maintain a steady pace and avoid sudden spikes.");
    }
}

interface TemperatureMonitor {
    default void displayHealthTips() {
        System.out.println("Temperature tip: Keep hydrated and rest if feverish.");
    }
}

class HealthMonitoringSystem implements HeartRateMonitor, TemperatureMonitor {
    public static boolean isPatientIdValid(String patientId) {
        return patientId != null && patientId.matches("PID\\d{3}");
    }

    @Override
    public void displayHealthTips() {
        System.out.println("Combined health tips:");
        HeartRateMonitor.super.displayHealthTips();
        TemperatureMonitor.super.displayHealthTips();
    }

    public void displayHealthReading(String name, int heartRate, double temperature) {
        System.out.println("Patient: " + name);
        System.out.println("Heart Rate: " + heartRate + " bpm");
        System.out.println("Temperature: " + temperature + " °C");
    }
}
