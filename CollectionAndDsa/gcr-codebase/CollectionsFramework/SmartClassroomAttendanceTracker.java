import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmartClassroomAttendanceTracker {
    private final Map<String, List<String>> attendanceMap = new HashMap<>();

    public void markAttendance(String subject, String studentName) {
        attendanceMap.putIfAbsent(subject, new ArrayList<>());
        List<String> students = attendanceMap.get(subject);
        if (students.contains(studentName)) {
            System.out.println(studentName + " already marked present in " + subject + ".");
            return;
        }
        students.add(studentName);
        System.out.println("Marked present: " + studentName + " in " + subject + ".");
    }

    public void displayAttendance() {
        System.out.println("\nAttendance by Subject:");
        for (Map.Entry<String, List<String>> entry : attendanceMap.entrySet()) {
            System.out.println("Subject: " + entry.getKey() + " (" + entry.getValue().size() + " students)");
            for (String student : entry.getValue()) {
                System.out.println(" - " + student);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SmartClassroomAttendanceTracker tracker = new SmartClassroomAttendanceTracker();

        tracker.markAttendance("Mathematics", "Alice Parker");
        tracker.markAttendance("Mathematics", "Bob Carter");
        tracker.markAttendance("Science", "Alice Parker");
        tracker.markAttendance("Science", "Claire Mason");
        tracker.markAttendance("Mathematics", "Alice Parker");
        tracker.markAttendance("History", "David Lee");

        tracker.displayAttendance();
    }
}
