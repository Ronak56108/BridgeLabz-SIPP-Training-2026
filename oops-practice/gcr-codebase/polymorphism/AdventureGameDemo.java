public class AdventureGameDemo {
    public static void main(String[] args) {
        BattleCharacter[] characters = {
            new WarriorCharacter("Aragorn"),
            new MageCharacter("Gandalf"),
            new ArcherCharacter("Legolas"),
            new WarriorCharacter("Boromir"),
            new MageCharacter("Merlin")
        };

        startBattle(characters);
    }

    public static void startBattle(BattleCharacter[] characters) {
        int warriorCount = 0;
        int mageCount = 0;
        int archerCount = 0;

        for (BattleCharacter character : characters) {
            character.performAttack();
            if (character instanceof WarriorCharacter) {
                warriorCount++;
            } else if (character instanceof MageCharacter) {
                mageCount++;
            } else if (character instanceof ArcherCharacter) {
                archerCount++;
            }
        }

        System.out.println("\nWarriors: " + warriorCount);
        System.out.println("Mages: " + mageCount);
        System.out.println("Archers: " + archerCount);
    }
}

class BattleCharacter {
    private String characterName;

    public BattleCharacter(String characterName) {
        this.characterName = characterName;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void performAttack() {
        System.out.println(characterName + " performs a basic attack.");
    }
}

class WarriorCharacter extends BattleCharacter {
    public WarriorCharacter(String characterName) {
        super(characterName);
    }

    @Override
    public void performAttack() {
        System.out.println(getCharacterName() + " swings a mighty sword.");
    }
}

class MageCharacter extends BattleCharacter {
    public MageCharacter(String characterName) {
        super(characterName);
    }

    @Override
    public void performAttack() {
        System.out.println(getCharacterName() + " casts a powerful spell.");
    }
}

class ArcherCharacter extends BattleCharacter {
    public ArcherCharacter(String characterName) {
        super(characterName);
    }

    @Override
    public void performAttack() {
        System.out.println(getCharacterName() + " releases a precise arrow.");
    }
}
