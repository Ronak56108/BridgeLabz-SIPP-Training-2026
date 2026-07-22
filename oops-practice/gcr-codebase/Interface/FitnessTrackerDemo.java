public class FitnessTrackerDemo {
    public static void main(String[] args) {
        FitnessDevice device = new FitnessDevice();
        device.logActivity("Running", 45);
        device.sendAlert("Low battery");
        System.out.println(device.generateReport());
        device.resetData();
    }
}

interface Trackable {
    void logActivity(String activity, int durationMinutes);

    default void resetData() {
        System.out.println("Data reset to default state.");
    }
}

interface Reportable {
    String generateReport();
}

interface Notifiable {
    void sendAlert(String message);
}

class FitnessDevice implements Trackable, Reportable, Notifiable {
    @Override
    public void logActivity(String activity, int durationMinutes) {
        System.out.println("Logged activity: " + activity + " for " + durationMinutes + " minutes.");
    }

    @Override
    public String generateReport() {
        return "Today's fitness report: 1 activity logged.";
    }

    @Override
    public void sendAlert(String message) {
        System.out.println("Alert: " + message);
    }
}
