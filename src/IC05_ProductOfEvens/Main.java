package IC05_ProductOfEvens;

public class Main {

    public static void main(String[] args) {

        System.out.print(productOfEvens(3));

    }
    public static int productOfEvens(int n){

        //error case:

        if(n<=0)
            throw new IllegalArgumentException("Please enter a value greater than 0");
        //base case:
        if(n==1)
            return 2;

        //recursive case:
        return (n*2)*productOfEvens(n-1);
    }


}
