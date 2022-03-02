package IC05_PrintNums;

public class Main {
    public static void main(String[] args) {

        printNums(12);
        printNumsAscending(5);

    }

    public static void printNums(int n) {
        //Error case:
        if(n<1)
            throw new IllegalArgumentException("n must be greater than 1. Try again.");

        //Base case:
        if(n==1)
        {System.out.println(n);
        return;}

        //Recursive case:
        System.out.print(n+", ");
        printNums(n-1);

    }


    public static void printNumsAscending(int n){
 if(n<1)
     throw new IllegalArgumentException("n must be grater than 1. Try again.");
if(n==1)
{System.out.print(1);
    return;}

        printNumsAscending(n-1);
        System.out.print(", "+n);

    }


}
