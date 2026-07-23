import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    private final String title;

    protected JobRole(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

class SoftwareEngineer extends JobRole {
    SoftwareEngineer() {
        super("Software Engineer");
    }
}

class DataScientist extends JobRole {
    DataScientist() {
        super("Data Scientist");
    }
}

class ProductManager extends JobRole {
    ProductManager() {
        super("Product Manager");
    }
}

class Resume<T extends JobRole> {
    private final String candidateName;
    private final T role;

    public Resume(String candidateName, T role) {
        this.candidateName = candidateName;
        this.role = role;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public T getRole() {
        return role;
    }

    @Override
    public String toString() {
        return String.format("Resume{candidate='%s', role=%s}", candidateName, role.getTitle());
    }
}

public class AIResumeScreeningSystem {
    public static void processResumes(List<? extends JobRole> roles) {
        System.out.println("Processing resumes for roles:");
        for (JobRole role : roles) {
            System.out.println(" - " + role.getTitle());
        }
    }

    public static void main(String[] args) {
        Resume<SoftwareEngineer> resume1 = new Resume<>("Alice Parker", new SoftwareEngineer());
        Resume<DataScientist> resume2 = new Resume<>("Bob Carter", new DataScientist());
        Resume<ProductManager> resume3 = new Resume<>("Claire Mason", new ProductManager());

        List<JobRole> roles = new ArrayList<>();
        roles.add(new SoftwareEngineer());
        roles.add(new DataScientist());
        roles.add(new ProductManager());

        processResumes(roles);
        System.out.println("\nResumes:");
        System.out.println(resume1);
        System.out.println(resume2);
        System.out.println(resume3);
    }
}
