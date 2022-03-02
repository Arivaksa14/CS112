package IC02_CaffeinatedBeverage;
import java.util.Objects;
public class Coffee extends CaffeinatedBeverage{

private int mRoastType;
private String mType;

    public int getRoastType() {
        return mRoastType;
    }

    public void setRoastType(int roastType) {
       mRoastType = roastType;
    }
    public Coffee(String name, int ounces, double price, String type) {
        super(name, ounces, price);
        mType = type;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Coffee coffee = (Coffee) o;
        return mRoastType == coffee.mRoastType;
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mRoastType);
    }
    @Override
    public String toString() {
        return "Coffee:"+ mName +","+mOunces+
                " ounces," +  mType+
        " roast," + currency.format(mPrice);
    }
}
