package IC04_SliceOfThePie;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.text.NumberFormat;

public class Main {
    public static final String FILE_NAME="USPizzaDataset.csv";

public static void main(String[] args){
    int count = 0, countOside = 0;
    double price,min=Double.MAX_VALUE, minOside = Double.MAX_VALUE,
            max=Double.MIN_VALUE, maxOside = Double.MIN_VALUE,
            average, averageOside, sum = 0.0, sumOside=0.0;
    String city, name, line, minName="", maxName="", minNameOside="", maxNameOside="";
String[] parts;
    try{

        Scanner file=new Scanner(new File(FILE_NAME));
        NumberFormat currency=NumberFormat.getCurrencyInstance();
        //skip the header:
        file.nextLine();

        while(file.hasNextLine()){

            line=file.nextLine();

            //CSV files=comma separated values. Comma == delimiter(separator)

            parts=line.split(",");
            price=(parts[6]==null)?price=0.00:Double.parseDouble(parts[6]);
            city=parts[2];
            name=parts[9];

            count++;
            sum+=price;
            if(price>max){
               max=price;
               maxName=name;
            }
            if(price<min){
                min=price;
                minName=name;
            }
    if("Oceanside".equalsIgnoreCase(city)){

   countOside++;
   sumOside+=price;
        if(price>maxOside){
            maxOside=price;
            maxNameOside=name;
        }
        if(price<minOside){
            minOside=price;
            minNameOside=name;
        }}}

        file.close();
        System.out.println("\n**********************************************************\n*            US Pizza Dataset: National                  *\n**********************************************************");
        System.out.println("Number of entries reported: "+count);
        System.out.println("Highest priced pizzeria (nationally): "+maxName);
        System.out.println("Pizza Price $"+max);
        System.out.println("Lowest priced pizzeria (nationally): "+minName);
        System.out.println("Pizza Price $"+min);
        System.out.println("Average price of pizza (nationally): "+currency.format(sum/count));

        System.out.println("\n\n***********************************************************");
        System.out.println("Highest priced pizzeria (Oceanside):" + maxNameOside);
        System.out.println("Pizza Price $" + maxOside);
        System.out.println("Lowest priced pizzeria (Oceanside): " + minNameOside);
        System.out.println("Pizza Price $" + minOside);

        System.out.println("Average price of pizza (Oceanside): " +currency.format( sumOside / countOside));

    }catch(FileNotFoundException e){

        System.out.println("Error opening: "+e.getMessage());
    }}}
