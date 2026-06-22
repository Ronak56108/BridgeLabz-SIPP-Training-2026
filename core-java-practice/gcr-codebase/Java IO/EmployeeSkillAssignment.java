import java.io.*;
import java.util.*;

public class EmployeeSkillAssignment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee id: ");
        int id = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter department: ");
        String department = scanner.nextLine().trim();
        System.out.print("Enter salary: ");
        double salary = Double.parseDouble(scanner.nextLine().trim());

        System.out.print("Enter number of skill scores: ");
        int count = Integer.parseInt(scanner.nextLine().trim());
        int[] skills = new int[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Enter skill score " + (i + 1) + ": ");
            skills[i] = Integer.parseInt(scanner.nextLine().trim());
        }

        System.out.print("Enter target total skill score: ");
        int target = Integer.parseInt(scanner.nextLine().trim());

        Employee employee = new Employee(id, name, department, salary, skills);
        List<List<Integer>> teams = findTeams(skills, target);

        String fileName = "employee_data.ser";
        serializeEmployee(employee, fileName);
        System.out.println("Serialized employee to " + fileName);

        Employee recovered = deserializeEmployee(fileName);
        System.out.println("Recovered employee information:");
        System.out.println(recovered);

        System.out.println("Possible project teams with total skill " + target + ":");
        for (List<Integer> team : teams) {
            System.out.println(team);
        }
    }

    private static void serializeEmployee(Employee employee, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(employee);
        } catch (IOException e) {
            System.out.println("Serialization failed: " + e.getMessage());
        }
    }

    private static Employee deserializeEmployee(String fileName) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Employee) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization failed: " + e.getMessage());
            return null;
        }
    }

    private static List<List<Integer>> findTeams(int[] skills, int target) {
        List<List<Integer>> results = new ArrayList<>();
        findTeamsRec(skills, target, 0, new ArrayList<>(), results);
        return results;
    }

    private static void findTeamsRec(int[] skills, int target, int index, List<Integer> current, List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<>(current));
            return;
        }
        if (target < 0 || index >= skills.length) {
            return;
        }
        // include current skill
        current.add(skills[index]);
        findTeamsRec(skills, target - skills[index], index + 1, current, results);
        current.remove(current.size() - 1);
        // exclude current skill
        findTeamsRec(skills, target, index + 1, current, results);
    }
}

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String department;
    private double salary;
    private int[] skillScores;

    public Employee(int id, String name, String department, double salary, int[] skillScores) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.skillScores = skillScores;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', department='" + department + "', salary=" + salary + ", skills=" + Arrays.toString(skillScores) + '}';
    }
}
