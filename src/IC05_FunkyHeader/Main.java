package IC05_FunkyHeader;

public class Main {

    public static void main(String[] args) {
        funkyHeader(8);

    }

    public static void funkyHeader(int n){
        //error case:
        if(n<1)
        throw new IllegalArgumentException("Please pass a value >=1");

       //base cases:
        if(n==1)
        { System.out.print("*");
        return;}

        if(n==2){
            System.out.print("**");
            return;
        }

        //recursive case:
        System.out.print("<");
            funkyHeader(n-2);
            System.out.print(">");


    }


}
