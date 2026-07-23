import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Astronaut {
    String astronautId;
    String name;
    String specialization;

    Astronaut(String astronautId, String name, String specialization) {
        this.astronautId = astronautId;
        this.name = name;
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - %s", name, astronautId, specialization);
    }
}

public class SpaceMissionCrewManagementSystem {
    private final Map<String, List<Astronaut>> missionCrew = new HashMap<>();
    private final Map<String, Set<String>> missionCrewIds = new HashMap<>();

    public void addMission(String missionName) {
        missionCrew.putIfAbsent(missionName, new ArrayList<>());
        missionCrewIds.putIfAbsent(missionName, new HashSet<>());
    }

    public void assignAstronaut(String missionName, Astronaut astronaut) {
        addMission(missionName);
        Set<String> assignedIds = missionCrewIds.get(missionName);
        if (!assignedIds.add(astronaut.astronautId)) {
            System.out.println("Astronaut " + astronaut.name + " is already assigned to " + missionName + ".");
            return;
        }
        missionCrew.get(missionName).add(astronaut);
        System.out.println("Assigned " + astronaut.name + " to mission " + missionName + ".");
    }

    public void displayMissions() {
        System.out.println("\nMission Crew Assignments:");
        for (Map.Entry<String, List<Astronaut>> entry : missionCrew.entrySet()) {
            System.out.println("Mission: " + entry.getKey() + " (" + entry.getValue().size() + " crew members)");
            for (Astronaut astronaut : entry.getValue()) {
                System.out.println(" - " + astronaut);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SpaceMissionCrewManagementSystem system = new SpaceMissionCrewManagementSystem();

        Astronaut a1 = new Astronaut("AST001", "Alice Parker", "Pilot");
        Astronaut a2 = new Astronaut("AST002", "Bob Carter", "Engineer");
        Astronaut a3 = new Astronaut("AST003", "Claire Mason", "Scientist");

        system.assignAstronaut("Lunar Explorer", a1);
        system.assignAstronaut("Lunar Explorer", a2);
        system.assignAstronaut("Orbital Lab", a3);
        system.assignAstronaut("Lunar Explorer", a2);

        system.displayMissions();
    }
}
