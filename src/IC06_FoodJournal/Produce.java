package IC06_FoodJournal;

import java.io.Serializable;
import java.util.Objects;

public class Produce extends PaleoFood implements Serializable {
private boolean organic;

    public Produce(String name, int calories, int carbohydrates, boolean organic) {
        super(name, calories, carbohydrates);
        this.organic = organic;
    }

    public boolean isOrganic() {
        return organic;
    }

    public void setOrganic(boolean organic) {
        this.organic = organic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Produce produce = (Produce) o;
        return organic == produce.organic;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), organic);
    }

    @Override
    public String toString() {
        String output;
        if(organic){
            output="[Organic] Produce: ";
        }else{
         output="Produce: ";
        }
        output+= name + ", "+calories+
                " calories, "  +carbohydrates+
                "g carbs " ;

        return output;
    }
}
