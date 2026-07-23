import java.util.PriorityQueue;

public class EmergencyTriageQueue {
    static class Patient {
        int priority;
        String name;

        Patient(int priority, String name) {
            this.priority = priority;
            this.name = name;
        }

        @Override
        public String toString() {
            return name + "(" + priority + ")";
        }
    }

    private final PriorityQueue<Patient> triageQueue = new PriorityQueue<>((a, b) -> a.priority - b.priority);

    public void admitPatient(Patient p) {
        triageQueue.offer(p);
    }

    public Patient callNextPatient() {
        return triageQueue.poll();
    }

    public static void main(String[] args) {
        EmergencyTriageQueue queue = new EmergencyTriageQueue();
        queue.admitPatient(new Patient(4, "Alice"));
        queue.admitPatient(new Patient(1, "Bob"));
        queue.admitPatient(new Patient(2, "Claire"));
        System.out.println(queue.callNextPatient());
        System.out.println(queue.callNextPatient());
    }
}
