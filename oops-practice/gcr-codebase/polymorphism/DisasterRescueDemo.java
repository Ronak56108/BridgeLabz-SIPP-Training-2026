public class DisasterRescueDemo {
    public static void main(String[] args) {
        RescueTeamUnit[] teams = {
            new MedicalTeamUnit("M001", "Riverdale"),
            new FireRescueTeamUnit("F002", "Riverdale"),
            new FoodSupplyTeamUnit("S003", "Hillview"),
            new MedicalTeamUnit("M004", "Hillview"),
            new FireRescueTeamUnit("F005", "Riverside")
        };

        performTeamDuties(teams);
        System.out.println("\nTeams at Hillview:");
        displayTeamsByPrefix(teams, "H");
        System.out.println("Medical teams: " + countByType(teams, MedicalTeamUnit.class));
        System.out.println("Fire rescue teams: " + countByType(teams, FireRescueTeamUnit.class));
        System.out.println("Food supply teams: " + countByType(teams, FoodSupplyTeamUnit.class));
        System.out.println("Max deployment category: " + findMaxDeploymentCategory(teams));
    }

    public static void performTeamDuties(RescueTeamUnit[] teams) {
        for (RescueTeamUnit team : teams) {
            team.performDuty();
        }
    }

    public static void displayTeamsByPrefix(RescueTeamUnit[] teams, String prefix) {
        for (RescueTeamUnit team : teams) {
            if (team.getLocation().startsWith(prefix)) {
                System.out.println(team.getTeamId() + " at " + team.getLocation());
            }
        }
    }

    public static int countByType(RescueTeamUnit[] teams, Class<?> type) {
        int count = 0;
        for (RescueTeamUnit team : teams) {
            if (type.isInstance(team)) {
                count++;
            }
        }
        return count;
    }

    public static String findMaxDeploymentCategory(RescueTeamUnit[] teams) {
        int medical = countByType(teams, MedicalTeamUnit.class);
        int fire = countByType(teams, FireRescueTeamUnit.class);
        int food = countByType(teams, FoodSupplyTeamUnit.class);

        if (medical >= fire && medical >= food) {
            return "MedicalTeam";
        }
        if (fire >= medical && fire >= food) {
            return "FireRescueTeam";
        }
        return "FoodSupplyTeam";
    }
}

abstract class RescueTeamUnit {
    private String teamId;
    private String location;

    public RescueTeamUnit(String teamId, String location) {
        this.teamId = teamId;
        this.location = location;
    }

    public String getTeamId() {
        return teamId;
    }

    public String getLocation() {
        return location;
    }

    public abstract void performDuty();
}

class MedicalTeamUnit extends RescueTeamUnit {
    public MedicalTeamUnit(String teamId, String location) {
        super(teamId, location);
    }

    @Override
    public void performDuty() {
        System.out.println("Medical team " + getTeamId() + " is treating patients at " + getLocation() + ".");
    }
}

class FireRescueTeamUnit extends RescueTeamUnit {
    public FireRescueTeamUnit(String teamId, String location) {
        super(teamId, location);
    }

    @Override
    public void performDuty() {
        System.out.println("Fire rescue team " + getTeamId() + " is extinguishing fires at " + getLocation() + ".");
    }
}

class FoodSupplyTeamUnit extends RescueTeamUnit {
    public FoodSupplyTeamUnit(String teamId, String location) {
        super(teamId, location);
    }

    @Override
    public void performDuty() {
        System.out.println("Food supply team " + getTeamId() + " is distributing food at " + getLocation() + ".");
    }
}
