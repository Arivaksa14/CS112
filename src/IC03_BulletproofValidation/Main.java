package IC03_BulletproofValidation;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int number=0, min = 1, max = 5;
        Scanner keyboard = new Scanner(System.in);
        boolean error;
do {
    try {
        System.out.print("Please enter a number between " + min + " and " + max + ": ");
        number = keyboard.nextInt();
        error=(number < min || number > max);

    } catch (InputMismatchException e){
        keyboard.nextLine();
        error=true;
    }

    if(error)
        System.out.println("\t Enter only integer numbers between "+min+" and "+max);
}while(error);

        System.out.println("\nThe number you entered is " + number);
        keyboard.close();}}
