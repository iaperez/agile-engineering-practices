package edu.berkeley.ischool.aep;

import javafx.util.Pair;

import java.util.HashMap;

/**
 * Created by Ignacio on 2/7/14.
 */
public class QuantityAlt {
    private double size;
    private Units unit;

    public enum Units {INCHES,FEET,YARDS,MILES,TSP,TBSP,OZ,CUPS;

        public double convertTo(double size, Units unit) {
            return 0.0;
        }
    }
    private static final HashMap<Pair<Units, Units>, Double> ratios;
    static {
        ratios = new HashMap<Pair<Units, Units>, Double>();
        ratios.put(new Pair(Units.INCHES, Units.FEET), 12.0);
        ratios.put(new Pair(Units.FEET, Units.YARDS), 3.0);
        ratios.put(new Pair(Units.YARDS, Units.MILES), 1760.0);
        ratios.put(new Pair(Units.TSP, Units.TBSP), 3.0);
        ratios.put(new Pair(Units.TBSP, Units.OZ), 2.0);
        ratios.put(new Pair(Units.OZ, Units.CUPS), 8.0);
    }



    public QuantityAlt(double size, Units type) {
        this.size = size;
        this.unit = type;
    }

    public boolean equalsOLD(Object other) {
        if (other == this) return true;
        if (!(other instanceof QuantityAlt)) return false;

        QuantityAlt otherQuantity = (QuantityAlt) other;
        Pair unitsPair = new Pair(this.unit, otherQuantity.unit);
        Pair reverseUnitsPair = new Pair(otherQuantity.unit, this.unit);

        if (otherQuantity.unit.equals(this.unit))
            return (otherQuantity.size == this.size);
        else {
            if (ratios.containsKey(unitsPair))
                return this.size / ratios.get(unitsPair) == otherQuantity.size;
            else if (ratios.containsKey(reverseUnitsPair))
                return this.size * ratios.get(unitsPair) == otherQuantity.size;
            else
                return false;
        }
    }

   // public ScaledQuantity convertTo

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (!(other instanceof QuantityAlt)) return false;
        QuantityAlt otherQ = (QuantityAlt) other;
        return this.size == otherQ.unit.convertTo(otherQ.size, this.unit);
    }


    @Override
    public int hashCode() {
        //there is a better solution!!
        //return 42;
        long longBits = Double.doubleToLongBits(this.size + this.unit.hashCode());
        return (int) (longBits ^ (longBits >>> 32));
    }

}
