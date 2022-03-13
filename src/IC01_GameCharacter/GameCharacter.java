package IC01_GameCharacter;

import java.util.Random;

public class GameCharacter {

    private String mName;
    private final int mLevel;
    private int mHealthPoints;
    private int mGold;
    private int mMagic;

    public GameCharacter(String name, int level,int healthPoints,int gold, int magic){
        mName=name;
        mLevel=level;
        mHealthPoints=healthPoints;
        mGold=gold;
        mMagic=magic;
    }

    public int getLevel(){
        return mLevel;
    }
    public int getMagic(){
        return mMagic;
    }

    public String getName(){
        return mName;
    }

    public int getGold() {
        return mGold;
    }
    public int getHealthPoints() {
        return mHealthPoints;
    }

    public void setName(String newName){
        mName=newName;
    }

    @Override
    public String toString(){
        return "Game Character {Name="+mName+", Level="+mLevel+", Health Points="+
                mHealthPoints+", Gold="+mGold+", Magic="+mMagic+"}";

    }
    public void attack(GameCharacter other){
        Random rng = new Random();
        int number=rng.nextInt(10);

        int damage=number*mLevel;
        other.mHealthPoints-=damage;

        if(other.mHealthPoints<=0){
            other.mHealthPoints = 0;
            mGold+=other.mGold;
            other.mGold=0;
        }
    }
    public void assist(GameCharacter other){

        Random rng=new Random();
        int number=rng.nextInt(5);
        switch (number){

            case 0:
                other.mHealthPoints+=mLevel*5;
                mMagic -= mLevel * 5;
                break;

            case 1:
                other.mMagic+=mLevel*5;
                mMagic -= mLevel * 5;
                break;

            case 2:
                other.mGold=mLevel*5;
                mGold -= mLevel * 5;
                break;

            case 3:
                other.mGold+=100;
                other.mHealthPoints+=100;
                other.mMagic+=100;
                mGold-=100;
                mHealthPoints-=100;
                mMagic-=100;
                break;

            case 4:
                other.mHealthPoints=mLevel*100;
                mHealthPoints=mLevel*100;
                break;
        }
    }
    public void rest(){

        mHealthPoints += 1;
    }
}

