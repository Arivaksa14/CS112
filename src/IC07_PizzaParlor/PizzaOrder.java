package IC07_PizzaParlor;
import java.text.NumberFormat;
import java.util.Arrays;

public class PizzaOrder {
    private static final int MAX_PIZZAS=100;
    private int numPies;
    private final Pizza[] pies=new Pizza[MAX_PIZZAS];


    public boolean addPizzaToOrder(char size,boolean pepperoni,boolean sausage,boolean mushrooms, boolean vegan){
        if(numPies<MAX_PIZZAS){
            pies[numPies++]=new Pizza(size,pepperoni,sausage,mushrooms,vegan);
            return true;
        }
       return false;
    }

    public double calcCost(){
    double cost=0.0;

    for(int i=0;i<numPies;i++){
     switch (pies[i].getSize())  {
         case 'S':
             cost+=8.0;
             break;
         case 'M':
             cost+=10.0;
             break;
         case 'L':
             cost+=12.0;
             break;
     }
     cost+=pies[i].getNumToppings();

    }
       return cost;
    }

    @Override
    public String toString() {
        NumberFormat currency=NumberFormat.getCurrencyInstance();
        String output="Pizza Order: Number of Pies = "+numPies+"\n";
        //Loop through each pizza in the array:

        for(int i=0;i<numPies;i++){
            output+="Pie #"+(i+1)+": "+pies[i].toString()+"\n";
        }
      output+="Total Cost = "+currency.format(calcCost());
        return output;
    }
}
