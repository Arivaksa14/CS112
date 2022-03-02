package IC01_GameCharacter;
public class Main {
    public static void main(String[] args){

        GameCharacter ari=new GameCharacter("Ari the Little Bug",5,500,500,500);
        GameCharacter gandalf=new GameCharacter("Gandalf the Grey",20,2000,2000,2000);
        GameCharacter monsterBug=new GameCharacter("Monster Bug",1,100,100,100);

        System.out.println("~~~Game Characters Created~~~");
        System.out.println(ari);
        System.out.println(gandalf);
        System.out.println(monsterBug);

        ari.assist(gandalf);

        System.out.println("\n~~~"+ari.getName()+" is assisting "+gandalf.getName()+"~~~");
        System.out.println(ari);
        System.out.println(gandalf);
        System.out.println(monsterBug);

        gandalf.attack(monsterBug);

        System.out.println("\n~~~"+gandalf.getName()+" is attacking "+monsterBug.getName()+"~~~");
        System.out.println(ari);
        System.out.println(gandalf);
        System.out.println(monsterBug);

        ari.rest();
        gandalf.rest();

        System.out.println("\n~~~"+ari.getName()+" and "+gandalf.getName()+" have rested ~~~");
        System.out.println(ari);
        System.out.println(gandalf);
        System.out.println(monsterBug);

    }











}
