package IC05_HarmonicSeries;

public class Main {
    public static void main(String[] args) {
        System.out.print("Harmonic series of 2 is "+harmonicSeries(2));

    }

    public static double harmonicSeries(int n){

        //error case:
        if(n<1)
            throw new IllegalArgumentException("n must by >=1");

        //base case:
        if(n==1)
            return 1.0 ;

        //recursive case:
        return 1.0/n+harmonicSeries(n-1);
    }
}
