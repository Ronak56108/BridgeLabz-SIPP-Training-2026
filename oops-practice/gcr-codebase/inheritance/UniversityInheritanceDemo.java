public class UniversityInheritanceDemo {
    public static void main(String[] args) {
        GradStudent gradStudent = new GradStudent("P001", "Alice", 3.8, "AI Research", "S001");

        System.out.println(gradStudent);
        System.out.println("GradStudent is a Student: " + (gradStudent instanceof Student));
        System.out.println("GradStudent is a Person: " + (gradStudent instanceof Person));

        Student student = gradStudent;
        Person person = gradStudent;

        System.out.println("student.toString(): " + student);
        System.out.println("person.toString(): " + person);
    }
}

class Person {
    private String personId;
    private String name;

    public Person(String personId, String name) {
        this.personId = personId;
        this.name = name;
    }

    public String getPersonId() {
        return personId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person[id=" + personId + ", name=" + name + "]";
    }
}

class Student extends Person {
    private String studentId;
    private double gpa;

    public Student(String personId, String name, double gpa, String studentId) {
        super(personId, name);
        this.studentId = studentId;
        this.gpa = gpa;
    }

    public final String getStudentId() {
        return studentId;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return "Student[id=" + getStudentId() + ", name=" + getName() + ", gpa=" + gpa + "]";
    }
}

class GradStudent extends Student {
    private String thesis;

    public GradStudent(String personId, String name, double gpa, String thesis, String studentId) {
        super(personId, name, gpa, studentId);
        this.thesis = thesis;
    }

    public String getThesis() {
        return thesis;
    }

    @Override
    public String toString() {
        return "GradStudent[id=" + getStudentId() + ", name=" + getName() + ", gpa=" + getGpa() + ", thesis=" + thesis + "]";
    }
}
