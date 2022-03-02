package IC02_GameCharacterInheritance;
import java.sql.SQLOutput;
import java.util.Random;

public class GameCharacter {

    // Fields = attributes, instance variables, properties or characteristics
    protected String mName;
    protected int mHealthPoints;
    protected int mLevel;
    protected int mMagic;
    protected int mGold;

    Random rng = new Random();

    // Constructor method = instantiates a new object (new GameCharacter)
    public GameCharacter(String name, int level) {
        mName = name;
        mLevel = level;
        mHealthPoints = mLevel * 100;
        mMagic = mLevel * 100;
        mGold = mLevel * 100;
    }

    // Second constructor with name only (start at level 1)
    public GameCharacter(String name) {

        this(name, 1);
    }

    // Getters and Setters
    // Getter = retrieves the value of a field
    public String getName() {

        return mName;
    }

    // Setter = modifies the value of a field
    public void setName(String newName) {

        mName = newName;
    }

    public void attack(GameCharacter other) {
        System.out.println(mName+" does not attack.I'm peaceful :)");
    }


    public void assist(GameCharacter other) {
        System.out.println(mName+" cannot assist.");
    }

    // toString method = converts an object into a String for display
    @Override
    public String toString() {
        // Game Character{Name='Paladin Paulding', Level=5, Health Points=500, Gold=500,
        // Magic=500}
        return "Game Character{Name=" + mName + ", Level=" + mLevel + ", Health Points=" + mHealthPoints + ", Gold=" + mGold
                + ", Magic=" + mMagic + "}";

    }

    public void rest()
    {

        System.out.println(mName+" never rests!");
    }

}