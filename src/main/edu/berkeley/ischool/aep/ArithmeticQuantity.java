package edu.berkeley.ischool.aep;

/**
 * Created by Ignacio on 2/21/14.
 */
public class ArithmeticQuantity extends ScaledQuantity{

    public ArithmeticQuantity(double size, Unit units) {
        super(size, units);
    }

    public ArithmeticQuantity add(ArithmeticQuantity otherQ) throws Exception {
        if(this.isCompatible(otherQ))
            return new ArithmeticQuantity(this.value +otherQ.convertValueTo(this.units),this.units);
        throw new Exception("Do not mix apples and oranges!");
    }
}
