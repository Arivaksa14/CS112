package IC06_FoodJournal;

import java.io.Serializable;
import java.util.Objects;

public class Meat extends PaleoFood implements Serializable {

    private int type;
    private int cookingTemp;

    public Meat(String name, int calories,int type, int cookingTemp) {
        super(name,calories,0);

        this.type = type;
        this.cookingTemp = cookingTemp;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCookingTemp() {
        return cookingTemp;
    }

    public void setCookingTemp(int cookingTemp) {
        this.cookingTemp = cookingTemp;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meat meat = (Meat) o;
        return type == meat.type && cookingTemp == meat.cookingTemp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, cookingTemp);
    }

    @Override
    public String toString() {
        String meatType="";
        if(type==1)
            meatType="Meat";
        else
            meatType="Seafood";

        return meatType+": " +name+", "
                + calories + ", calories, " +
                carbohydrates + "g carbs, " +
                cookingTemp + " degrees F" ;
    }
}
