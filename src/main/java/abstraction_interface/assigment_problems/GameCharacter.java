package abstraction_interface.assigment_problems;

// Abstract base class representing a game character with an assigned character ID.
public abstract class GameCharacter {
    private static int characterCounter = 0;
    private final String characterId;

    public GameCharacter() {
        characterCounter++;
        this.characterId = "CHR-" + (1000 + characterCounter);
    }

    public abstract String getSpecialMove();

    public String getCharacterId() {
        return characterId;
    }
}
