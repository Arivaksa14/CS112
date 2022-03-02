package IC02_CaffeinatedBeverage;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
  static NumberFormat currency=NumberFormat.getCurrencyInstance();
  public static int count = 0;
  public static void main(String[ ] args) {
    String name,flavor,roastTypeS = "";
    int ounces, roastType, choice;
    double price;
    Scanner keyboard=new Scanner(System.in);
    CaffeinatedBeverage[] beverages = new CaffeinatedBeverage[10];

    do {
      System.out.println("~~~Welcome to CS112 Coffee Shop~~~");
      System.out.println("Please choose from the following options:");
      System.out.println("To Enter a new Coffee Drink choose option (1)");
      System.out.println("To Enter a new Energy Drink choose option (2)");
      System.out.println("To Quit choose option (3)");
      choice=keyboard.nextInt();

      switch (choice){
        case 1:
          keyboard.nextLine();
          System.out.print("Enter name of Coffee Drink: ");
          name= keyboard.nextLine();
          System.out.print("Enter how many ounces: ");
          ounces=keyboard.nextInt();
          System.out.print("Enter price: $");
          price=keyboard.nextDouble();
          System.out.print("Enter the type of a roast (1 = light, 2 = medium, 3 = dark): ");
          roastType= keyboard.nextInt();

          if(roastType==1)
            roastTypeS="light";

          else if(roastType==2)
            roastTypeS="medium";

          else if(roastType==3)
            roastTypeS="dark";

          beverages[count++] =new Coffee(name,ounces,price,roastTypeS);
          break;

        case 2:
          keyboard.nextLine();
          System.out.print("Enter name of Energy Drink: ");
          name= keyboard.nextLine();
          System.out.print("Enter how many ounces: ");
          ounces=keyboard.nextInt();
          System.out.print("Enter price: $");
          price=keyboard.nextDouble();
          keyboard.nextLine();
          System.out.print("Enter the flavor: ");
          flavor= keyboard.nextLine();

          beverages[count++]=new EnergyDrink(name,ounces,price, flavor);

        break;

        case 3:
          System.out.println("\n~~~All Caffeinated Beverages~~~");

          for (int i = 0; i < count; i++) {
            System.out.println(beverages[i]);
          }
          System.out.println("\nAverage drink price = "+ currency.format(findAveragePrice(beverages)));
          System.out.println("\nEnergy Drink with the highest price: "+ findHighestPricedEnergyDrink(beverages).getName()
                  +" at "+currency.format(findHighestPricedEnergyDrink(beverages).getPrice()));

          break;

      }
    } while (choice != 3);

  }

  public static double findAveragePrice(CaffeinatedBeverage[] inventory){
    double total=0.00;
    for (int i = 0; i <count; i++) {

      total+=inventory[i].getPrice();
    }
    return total/count;
  }

//  public static EnergyDrink findHighestPricedEnergyDrink(CaffeinatedBeverage[] inventory){
//   double max=inventory[0].getPrice();
//   String maxName=inventory[0].getName();
//
//   EnergyDrink drink=new EnergyDrink("",0,0,"");
//
//    for(int i=0;i<=count;i++){
//      if(inventory[i] instanceof EnergyDrink && inventory[i].getPrice()>max) {
//        max = inventory[i].getPrice();
//        maxName = inventory[i].getName();
//      }}
//
//    drink.setPrice(max);
//    drink.setName(maxName);
//
//    return drink;
//  }

  public static EnergyDrink findHighestPricedEnergyDrink(CaffeinatedBeverage[] inventory){

     double max=Integer.MIN_VALUE;

     CaffeinatedBeverage maxPricedBeverage=null;

    for(int i=0;i<count;i++){
      if(inventory[i] instanceof EnergyDrink && inventory[i].getPrice()>max) {
        max = inventory[i].getPrice();
        maxPricedBeverage = inventory[i];
      }}

  return (EnergyDrink) maxPricedBeverage;

  }


}
