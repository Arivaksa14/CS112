package IC02_TradingCards;
import IC02_CaffeinatedBeverage.CaffeinatedBeverage;
import IC02_CaffeinatedBeverage.EnergyDrink;

import java.text.NumberFormat;
import java.util.Scanner;
public class Main {
    public static int count=0;

    public static void main(String[] args) {
        String name,rarity,energyType,cardClass;
        double price;
        int hitPoints,choice;
        boolean golden;

        TradingCard[] allCards= new TradingCard[10];
        Scanner keyboard=new Scanner(System.in);

        do {
            System.out.println("\n~~~Welcome to Trading Card Central~~~");
            System.out.println("Enter (1) to enter a Pokemon card");
            System.out.println("Enter (2) to enter a Pokemon card");
            System.out.println("Enter (3) to exit");

            choice=keyboard.nextInt();
            keyboard.nextLine();

            switch (choice){
                case 1: //Pokemon
                    System.out.print("What is card's name? ");
                    name=keyboard.nextLine();
                    System.out.print("What is its price? $");
                    price= keyboard.nextDouble();
                    keyboard.nextLine();
                    System.out.print("What is its rarity? ");
                    rarity=keyboard.nextLine();
                    System.out.print("Pokemon energy type? ");
                    energyType=keyboard.nextLine();
                    System.out.print("How many hit points? ");
                    hitPoints=keyboard.nextInt();

                    allCards[count++]=new Pokemon(name,price,rarity,energyType,hitPoints);

                    break;

                case 2://Hearthstone
                    System.out.print("What is card's name? ");
                    name=keyboard.nextLine();
                    System.out.print("What is its price? $");
                    price= keyboard.nextDouble();
                    keyboard.nextLine();
                    System.out.print("What is its rarity ? ");
                    rarity=keyboard.nextLine();
                    System.out.print("Hearthstone class  ? ");
                    cardClass=keyboard.nextLine();
                    System.out.print("Is it a golden card?  ");
                    golden=keyboard.nextBoolean();

                    allCards[count++]=new Hearthstone(name,price,rarity,cardClass,golden);
                    break;

                case 3://Exit (stats)
                    System.out.println("\n~~~All Trading Cards~~~");
                    double total=0.00;
                    NumberFormat currency=NumberFormat.getCurrencyInstance();

                    for (int i = 0; i < count; i++) {
                        System.out.println(allCards[i]);
                        total+=allCards[i].getPrice();
                    }
                    System.out.println("\nAverage card price = "+currency.format(total/count) );
                    System.out.println("\nHighest Priced Hearthstone Card = "+highestPricedHearthstoneCard(allCards));
                    System.out.println("\nLowest priced Card = "+lowestPricedCard(allCards));

                    break;
            }


        }while(choice!=3);
        keyboard.close();}

    public static String highestPricedHearthstoneCard(TradingCard[] inventory){

        double max=inventory[0].getPrice();
        String maxName=inventory[0].getName();
        Hearthstone object=new Hearthstone("",0,"","",false);

        for (int i = 0; i < count; i++) {

            if( inventory[i] instanceof Hearthstone && inventory[i].getPrice()>max) {
                max = inventory[i].getPrice();
                maxName = inventory[i].getName();
            }
        }
        object.setPrice(max);
        object.setName(maxName);

        return object.getName();
    }

    public static TradingCard lowestPricedCard(TradingCard[] inventory){
        double min=Double.MAX_VALUE;
        TradingCard minObj=null;

        for (int i = 0; i < count; i++) {

            if(inventory[i].getPrice()<min){
                min=inventory[i].getPrice();
                minObj=inventory[i];

            }
        }
        return minObj;
    }

//    public static TradingCard lowestPricedCard(TradingCard[] inventory){
//        double min=Double.MAX_VALUE;
//        TradingCard minObj=null;
//
//        for (int i = 0; i < inventory.length; i++) {
//       if(inventory[i]==null)
 //   return minObj;

//            if(inventory[i] instanceOf TradingCard)
//            if((TradingCards)inventory[i].getPrice()<min){
//                min=inventory[i].getPrice();
//                minObj=(TradingCards)inventory[i];
//
//            }
//        }
//        return minObj;
//    }







}


//Team 1:
//        Write a method that returns the name of the highest-priced Hearthstone card.
//public static String highestPricedHearthstoneCard(TradingCard[] inventory)
//
//        Write a method that returns the object with the lowest price.
//public static TradingCard lowestPricedCard(TradingCard[] inventory)
