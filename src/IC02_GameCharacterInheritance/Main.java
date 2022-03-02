package IC02_GameCharacterInheritance;
public class Main {
    public static void main(String[] args) {

        Hero me= new Hero("Ari the Great", 5);
        Villain bug=new Villain("Cyber Monster Bug",4);
        GameCharacter bush=new GameCharacter("The Peaceful Bush", 2);

        GameCharacter[] allCharacters=new GameCharacter[3];
        allCharacters[0]=me;
        allCharacters[1]=bug;
        allCharacters[2]=bush;
        System.out.println("\n~~~Game Characters Created~~~");

        for (GameCharacter g: allCharacters) {
            System.out.println(g);
        }

        me.attack(bug);
        System.out.println("\n~~~The Bug Has Been Attacked~~~");
        for (GameCharacter g: allCharacters) {
            System.out.println(g);}

        bug.assist(bug);
        System.out.println("\n~~~The Villain Bug Assisted Itself~~~");
        for (GameCharacter g: allCharacters) {
            System.out.println(g);
        }
        System.out.println("\n~~~All Characters Are Resting~~~");
        bush.rest();
        me.rest();
        bug.rest();

        for (GameCharacter g: allCharacters) {
            System.out.println(g);
        }}}

