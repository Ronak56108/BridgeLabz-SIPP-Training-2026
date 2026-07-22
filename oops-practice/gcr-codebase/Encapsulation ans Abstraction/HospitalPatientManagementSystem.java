public class HospitalPatientManagementSystem {
    public static void main(String[] args) {
        InPatient inPatient = new InPatient("P001", "Alice", 35, 2000, 5000);
        OutPatient outPatient = new OutPatient("P002", "Bob", 28, 800, 1500);

        inPatient.displayPatientDetails();
        System.out.println("Bill Amount: " + inPatient.calculateBill() + "\n");

        outPatient.displayPatientDetails();
        System.out.println("Bill Amount: " + outPatient.calculateBill());
    }
}

abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void displayPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public abstract double calculateBill();
}

class InPatient extends Patient {
    private double roomCharges;
    private double treatmentCharges;

    public InPatient(String patientId, String name, int age, double roomCharges, double treatmentCharges) {
        setPatientId(patientId);
        setName(name);
        setAge(age);
        this.roomCharges = roomCharges;
        this.treatmentCharges = treatmentCharges;
    }

    public double getRoomCharges() {
        return roomCharges;
    }

    public void setRoomCharges(double roomCharges) {
        this.roomCharges = roomCharges;
    }

    public double getTreatmentCharges() {
        return treatmentCharges;
    }

    public void setTreatmentCharges(double treatmentCharges) {
        this.treatmentCharges = treatmentCharges;
    }

    @Override
    public double calculateBill() {
        return roomCharges + treatmentCharges;
    }
}

class OutPatient extends Patient {
    private double consultationFees;
    private double treatmentCharges;

    public OutPatient(String patientId, String name, int age, double consultationFees, double treatmentCharges) {
        setPatientId(patientId);
        setName(name);
        setAge(age);
        this.consultationFees = consultationFees;
        this.treatmentCharges = treatmentCharges;
    }

    public double getConsultationFees() {
        return consultationFees;
    }

    public void setConsultationFees(double consultationFees) {
        this.consultationFees = consultationFees;
    }

    public double getTreatmentCharges() {
        return treatmentCharges;
    }

    public void setTreatmentCharges(double treatmentCharges) {
        this.treatmentCharges = treatmentCharges;
    }

    @Override
    public double calculateBill() {
        return consultationFees + treatmentCharges;
    }
}
