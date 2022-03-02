package IC05_HowManyDigitsMatch;
public class Main {

    public static void main(String[] args) {

      System.out.println( howManyDigitsMatch(298892,7892));
      tooManyTwos(80);
    }
    public static void tooManyTwos(int n){
        //error case:
        if(n<1)
            throw new IllegalArgumentException("Error: n must be >= 1");
//base cases:
        if(n%2==1){
            System.out.print(n);
            return;}
//recursive case:
        if((n/4)>1) {
            System.out.print("2 * ");
            tooManyTwos(n / 4);
            System.out.print(" * 2");
            return;
        }
        if(n/2>=1){
            System.out.print("2 * ");
            tooManyTwos(n/2);
            return;

        }}


    public static int howManyDigitsMatch(int n1,int n2){
        //error case:
        if(n1 < 0 || n2 < 0)
            throw new IllegalArgumentException();

        //base case:
        if(n1 < 10 || n2 < 10)
            return n1 % 10 == n2 % 10 ? 1 : 0;

        //recursive case:
        if(n1%10==n2%10)
            return (1+howManyDigitsMatch(n1/10,n2/10));
        else
        return howManyDigitsMatch(n1/10,n2/10);

    }
}

