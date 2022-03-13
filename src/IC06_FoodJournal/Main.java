package IC06_FoodJournal;

import IC03_Scheduler.InvalidTimeException;
import IC03_Scheduler.TimeInUseException;

import java.io.*;
import java.util.Scanner;

public class Main {
static int count=0;
    public static void main(String[] args) {

        int choice,type,calories,carbs,cookingTemp,organicType;

        PaleoFood[] journal=new PaleoFood[100];

        String name;
        boolean organic;
        int total;

        Scanner keyboard=new Scanner(System.in);
        File binaryFile=new File("PaleoFoodJournal.dat");
     //check to see if the file exists and check if it has non-zero file size
        System.out.println("Previously saved journal entries from binary file: ");
        if (binaryFile.exists() && binaryFile.length()>1L){

            try {
                ObjectInputStream fileReader=new ObjectInputStream(new FileInputStream(binaryFile));
                //Read the entire array into the journal
                //readObject returns Object
                journal =(PaleoFood[])fileReader.readObject();
                while(journal[count]!=null){
                    System.out.println(journal[count++]);

                }

                fileReader.close();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error: "+e.getMessage());
            }
        }else{
            System.out.println("[No food eaten. You must be hungry.]");
        }
        System.out.println("\n~~~Welcome to the Paleo Food Journal~~~\n");
        do{
            System.out.println("\nEnter (1) to record meat");
            System.out.println("Enter (2) to record produce");
            System.out.println("Enter (3) to quit");
            choice=keyboard.nextInt();
                switch(choice) {
                    // Choice 1:
                    case 1:

                        keyboard.nextLine();
                        System.out.print("What is the name of the meat eaten? ");
                        name = keyboard.nextLine();

                        System.out.print("How many calories was it? ");
                        calories = keyboard.nextInt();
                        System.out.print("Enter (1) for animal or (2) for seafood: ");
                        type = keyboard.nextInt();
                        keyboard.nextLine();
                        try {
                            if (type != 1 && type != 2) {
                                throw new MysteryMeatExection();
                            }

                        System.out.print("Enter the cooking temperature: ");
                        cookingTemp = keyboard.nextInt();

                        journal[count++] = new Meat(name, calories, type, cookingTemp);
                      }catch (MysteryMeatExection e) {
                       System.out.println(e.getMessage());
                       }

                        break;


                        // Choice 2:
                    case 2:
                        keyboard.nextLine();
                        System.out.print("What is the name of the produce eaten? ");
                        name = keyboard.nextLine();

                        System.out.print("How many calories was it? ");
                        calories = keyboard.nextInt();

                        System.out.print("How many carbohydrates? ");
                        carbs = keyboard.nextInt();

                        System.out.print("Enter (1) for organic or (2) for non-organic: ");
                        organicType = keyboard.nextInt();
//                     if(organicType==1)
//                     organic=true;
//                     else
//                     organic=false;
                        //Same as:

                        organic = (organicType == 1);
                        journal[count++] = new Produce(name, calories, carbs, organic);

                        break;
                    // Choice 3:
                    case 3:
                        System.out.println("~~~Food Recorded in Journal~~~");
                        for (int i = 0; i < count; i++) {

                            System.out.println(journal[i]);
                        }

                        total = totalCalories(journal);
                        System.out.println("\nTotal calories consumed   = " + total);
                        System.out.println("Average calories consumed = " + total / count);
                        System.out.println("Food with most calories   = " + foodWithMostCalories(journal));
                        System.out.println("Eat healthy and enjoy your weekend!");
                        break;
                }

        }while (choice!=3);
        try {
            ObjectOutput fileWriter=new ObjectOutputStream(new FileOutputStream(binaryFile));
            fileWriter.writeObject(journal);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error: "+e.getMessage());
        }

    }

    public static int totalCalories(PaleoFood[] journal){

        int total=0;
        for(int i=0;i<count;i++){
            total+=journal[i].getCalories();

        }
        return total;
    }

    public static PaleoFood foodWithMostCalories(PaleoFood[] journal){
        int max=Integer.MIN_VALUE;
        PaleoFood maxFood=null;

        for(int i=0;i<count;i++){
            if(journal[i].getCalories()>max){
                max=journal[i].getCalories();
                maxFood=journal[i];
            }
        }
        return maxFood;

    }

}
