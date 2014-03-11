package edu.berkeley.ischool.aep;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by Ignacio Perez on 1/31/14.
 */
public class Chance implements Bestable<Chance>{
    final private BigDecimal probability;

    public Chance(double probability){
        DecimalFormat df = new DecimalFormat("##.######");
        df.setRoundingMode(RoundingMode.DOWN);
        this.probability = new BigDecimal(df.format(probability));
        this.probability.setScale(6,BigDecimal.ROUND_DOWN);
    }

    public Chance(BigDecimal probability){
        this.probability = probability;
    }

    public Chance not(){
        BigDecimal bd = new BigDecimal(1.0);
        return new Chance(bd.add(this.probability.negate()));
    }

    @Override
    public boolean equals(Object other){
        if (other == this) return true;
        if (!(other instanceof Chance)) return false;
        // Math.abs(x-y)< 00000.1
        return this.probability.equals(((Chance) other).probability);
    }

    @Override
    public int hashCode() {
        //there is a better solution!!
        //return 42;
        long longBits = Double.doubleToLongBits(this.probability.doubleValue());
        return (int) (longBits^(longBits>>>32));
    }

    @Override
    public String toString() {

        return probability.toString();
    }

    public Chance combined(Chance b) {
        return new Chance(this.probability.multiply(b.probability));
    }

    @Override
    public boolean betterThan(Chance challenger) throws Exception {
        return this.probability.compareTo(challenger.probability)>0;
    }

}
