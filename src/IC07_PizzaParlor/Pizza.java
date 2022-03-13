package IC07_PizzaParlor;

public class Pizza {

private boolean pepperoni;
private boolean sausage;
private boolean mushrooms;
private boolean vegan;
private char size;

    public Pizza(char size,boolean pepperoni, boolean sausage, boolean mushrooms,boolean vegan) {
        this.pepperoni = pepperoni;
        this.sausage = sausage;
        this.mushrooms = mushrooms;
        this.vegan = vegan;
        this.size = size;
    }

    public char getSize() {
        return size;
    }

    public  int getNumToppings(){
        int numToppings=0;
        if(pepperoni) numToppings++;
        if(sausage) numToppings++;
        if(mushrooms) numToppings++;
        if(vegan) numToppings++;
        return numToppings;
    }

    @Override
    public String toString() {
        String output=
      "Pizza [Size=" +size;
        if(pepperoni) output+=", Pepperoni";
        if(sausage) output+=", Sausage";
        if(mushrooms) output+=", Mushrooms";
        if(vegan) output+=", Vegan";
             output+= ']';

        return output;
    }
}
