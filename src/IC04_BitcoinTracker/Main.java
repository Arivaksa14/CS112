package IC04_BitcoinTracker;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

public static final String FILE_NAME="bitcoin_prices_lite.txt";


public static void main(String[]args ){

    try{
    Scanner file=new Scanner(new File(FILE_NAME));
    double price,sum=0.0,min=Double.MAX_VALUE,max=Double.MIN_VALUE;
    int count=0;

    NumberFormat currency=NumberFormat.getCurrencyInstance();

       //skips the header:
        file.nextLine();

        //reading the file:
     while(file.hasNextDouble()){
         price=file.nextDouble();
         count++;

       sum+=price;

       if(price>max){
           max=price;
       }
       if(price<min){
           min=price;
       }

    }

    file.close();
    double average=sum/count;
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Bitcoin Statistics: Dec 2014 - Jun 2018");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Number of price quotes: " + count);
        System.out.println("Average price: " + currency.format(average));
        System.out.println("Lowest price: " + currency.format(min));
        System.out.println("Highest price: " + currency.format(max));
    }

    catch(FileNotFoundException e)
    {
        System.out.println("Error opening: "+e.getMessage());

    }
}
}
