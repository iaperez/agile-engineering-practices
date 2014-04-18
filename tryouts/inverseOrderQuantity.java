package edu.berkeley.ischool.aep;

/**
 * Created by Ignacio on 2/21/14.
 */
public class inverseOrderQuantity extends ScaledQuantity {

    public inverseOrderQuantity(double size, Unit units) {
        super(size, units);
    }

    public boolean betterThan(ScaledQuantity other) {
        if (other == this) return false;
        if (!(other instanceof ScaledQuantity)) return false;
        ScaledQuantity otherQ = (ScaledQuantity) other;

        if (this.isCompatible(otherQ)) {
            try {
                return this.value<otherQ.convertValueTo(this.units);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }
}
