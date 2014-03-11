package edu.berkeley.ischool.aep;

/**
 * Created by Ignacio on 2/14/14.
 */
public class ScaledQuantity implements Bestable<ScaledQuantity> {

    protected final double value;
    protected final Unit units;

    public ScaledQuantity(double size, Unit units) {
        this.value = size;
        this.units = units;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (!(other instanceof ScaledQuantity)) return false;
        ScaledQuantity otherQ = (ScaledQuantity) other;

        if (this.isCompatible(otherQ)) {
            try {
                return Math.abs(this.value-otherQ.convertValueTo(this.units))<0.0001;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        return false;
    }

    //Is this breaking encapsulation????
    protected boolean isCompatible(ScaledQuantity otherQ) {
        return this.units.isCompatible(otherQ.units);
    }

    public double convertValueTo(Unit units) throws Exception {
        return this.units.convertTo(units, this.value);
    } 

    @Override
    public String toString() {
        return value + " " + units;
    }


    @Override
    public boolean betterThan(ScaledQuantity challenger) throws Exception {
        return this.value>challenger.convertValueTo(this.units);
    }
}
