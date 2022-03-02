package IC02_GameCharacterInheritance;
public class Villain extends GameCharacter{
    public Villain(String name, int level) {
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
        mGold+=other.mGold;
        other.mGold=0;
    }
    @Override
    public void assist(GameCharacter other) {
        switch (rng.nextInt(5)) {
            case 0:
                other.mHealthPoints += mLevel * 5;
                mHealthPoints -= mLevel * 5;
                break;
            case 1:
                other.mMagic += mLevel * 6;
                mMagic -= mLevel * 6;
                break;
            case 2:
                other.mGold += mLevel * 7;
                mGold -= mLevel * 7;
                break;
            case 3:
                other.mLevel++;
                other.mGold += 200;
                other.mMagic += 200;
                other.mHealthPoints += 100;

                mLevel--;
                mGold -= 300;
                mMagic -= 300;
                mHealthPoints -= 300;
                break;
            case 4:
                mHealthPoints = mLevel * 200;
                other.mHealthPoints = other.mLevel * 200;
                break;}}
    @Override
    public void rest() {
        System.out.println("Villains never rest! Are you kidding me? We have to much nefarious things to do!");
    }
    public void perish(){

        System.out.println("Humanity has been restored! The villain has perished.");}}
