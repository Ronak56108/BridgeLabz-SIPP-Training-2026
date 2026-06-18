package recursion.scenerio_based;

import java.util.ArrayList;
import java.util.List;

/**
 * Employee Skill Assignment
 *
 * An employee can work on multiple projects.
 * Given an array of employee skill scores, find all possible project teams
 * whose total skill score equals a target value.
 *
 * Example:
 * Input: [2, 3, 5, 7], Target = 10
 * Output: [3, 7]
 *         [2, 3, 5]
 */
public class EmployeeSkillAssignment {

    public static List<List<Integer>> findTeams(int[] skills, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findTeams(skills, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void findTeams(int[] skills, int target, int index, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (index >= skills.length || target < 0) {
            return;
        }

        current.add(skills[index]);
        findTeams(skills, target - skills[index], index + 1, current, result);
        current.remove(current.size() - 1);

        findTeams(skills, target, index + 1, current, result);
    }

    public static void main(String[] args) {
        int[] skills = {2, 3, 5, 7};
        int target = 10;
        List<List<Integer>> teams = findTeams(skills, target);
        for (List<Integer> team : teams) {
            System.out.println(team);
        }
    }
}
