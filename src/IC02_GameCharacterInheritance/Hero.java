package IC02_GameCharacterInheritance;
public class Hero extends GameCharacter{

    public Hero(String name, int level) {

        super(name, level);
    }
    @Override
    public void attack(GameCharacter other) {
        // Generate a roll between 0 and 9
        int roll = rng.nextInt(10);
        // Calculate damage by multiplying the random number by "this" character's
        // level.
        int damage = mLevel * roll;
        // Deduct the damage from the other character's health points. However, do not
        // allow health points to go below zero.

        // this = "me, attacker"
        // other = "other character being attacked"

        other.mHealthPoints -= damage;

        // Do not allow HPs to go below 0
        if (other.mHealthPoints < 0)
            other.mHealthPoints = 0;
    }
    @Override
    public void assist(GameCharacter other) {
        switch (rng.nextInt(5)) {
            case 0:
                other.mHealthPoints += mLevel * 5;
                mHealthPoints -= mLevel * 5;
                break;
            case 1:
                other.mMagic += mLevel * 5;
                mMagic -= mLevel * 5;
                break;
            case 2:
                other.mGold += mLevel * 5;
                mGold -= mLevel * 5;
                break;
            case 3:
                other.mLevel++;
                other.mGold += 100;
                other.mMagic += 100;
                other.mHealthPoints += 100;

                mLevel--;
                mGold -= 100;
                mMagic -= 100;
                mHealthPoints -= 100;
                break;
            case 4:
                mHealthPoints = mLevel * 100;
                other.mHealthPoints = other.mLevel * 100;
                break;
        }
    }
    @Override
    public void rest() {
        int roll = rng.nextInt(5);
        mHealthPoints += roll * mLevel;
    }

    public void perish(){

        System.out.println("All is lost, our hero has perished :(");
    }
}
