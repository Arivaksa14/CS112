package IC05_RecursiveCount;

public class Main {

    public static void main(String[] args) {

        int[] data={1,2,6,4,3,2};

        System.out.println(countNumberOf(2, data));

    }

   public static int countNumberOf(int value, int[] array){

        if(array==null)
            throw new IllegalArgumentException("Array cannot be null.");

        return countNumberOf(value,array, array.length-1);

    }

    private static int countNumberOf(int value,int[] array,int i){

        //base case:
        if(i==0) {
            return ((array[i]==value)?1:0);}

        //recursive case:

        return ((array[i]==value)?1:0+countNumberOf(value,array,i-1));
    }

}
