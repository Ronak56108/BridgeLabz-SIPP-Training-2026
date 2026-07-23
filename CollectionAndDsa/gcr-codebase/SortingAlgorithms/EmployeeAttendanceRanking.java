import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeAttendanceRanking {
    private static class Employee {
        int id;
        int attendance;

        Employee(int id, int attendance) {
            this.id = id;
            this.attendance = attendance;
        }
    }

    public static int[] topKEmployees(int[] employeeIds, int[] attendance, int k) {
        int n = employeeIds.length;
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            employees.add(new Employee(employeeIds[i], attendance[i]));
        }
        employees.sort(Comparator
                .comparingInt((Employee e) -> -e.attendance)
                .thenComparingInt(e -> e.id));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = employees.get(i).id;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] employeeIds = {101, 102, 103, 104, 105};
        int[] attendance = {92, 85, 98, 92, 80};
        int k = 3;
        int[] topEmployees = topKEmployees(employeeIds, attendance, k);
        System.out.print("Top " + k + " employees: ");
        for (int id : topEmployees) {
            System.out.print(id + " ");
        }
    }
}
