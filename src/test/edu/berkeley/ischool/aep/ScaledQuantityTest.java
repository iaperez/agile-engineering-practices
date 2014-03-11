package edu.berkeley.ischool.aep;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Ignacio on 2/7/14.
 */
public class ScaledQuantityTest {

    @Test
    public void testConvertFeetToYard(){
        //assertEquals(new ScaledQuantity(1,"INCHES"), new ScaledQuantity(1, "FEET"));
        //using enums
        assertEquals(new ScaledQuantity(12, Unit.Inches), new ScaledQuantity(1, Unit.Feet));
        //assertFalse(new ScaledQuantity(1, ScaledQuantity.Units.INCHES).equals(new ScaledQuantity(12, ScaledQuantity.Units.FEET)));
        assertEquals(new ScaledQuantity(3, Unit.Feet), new ScaledQuantity(1, Unit.Yards));
        assertEquals(new ScaledQuantity(1760, Unit.Yards), new ScaledQuantity(1, Unit.Miles));
        assertEquals(new ScaledQuantity(3, Unit.Tsp), new ScaledQuantity(1, Unit.Tbsp));
        assertEquals(new ScaledQuantity(2, Unit.Tbsp), new ScaledQuantity(1, Unit.Oz));
        assertEquals(new ScaledQuantity(8, Unit.Oz), new ScaledQuantity(1, Unit.Cups));

    }

    @Test
    public void testAdd() throws Exception {
        //assertEquals(new ScaledQuantity(1,"INCHES"), new ScaledQuantity(1, "FEET"));
        //using enums A = B+C
        ArithmeticQuantity A = new ArithmeticQuantity(24, Unit.Inches);
        ArithmeticQuantity B = new ArithmeticQuantity(1, Unit.Feet);
        ArithmeticQuantity C = new ArithmeticQuantity(12, Unit.Inches);

        assertEquals(A,B.add(C));
        assertFalse(C.equals(B.add(C)));
    }


    @Test
    public void testFtoC() {
        //assertEquals(new ScaledQuantity(1,"INCHES"), new ScaledQuantity(1, "FEET"));
        //using enums A = B+C
        ScaledQuantity A = new ScaledQuantity(113, Unit.F);
        ScaledQuantity B = new ScaledQuantity(45, Unit.C);
        assertEquals(A,A);
        assertEquals(A,B);
        assertEquals(new ScaledQuantity(32,Unit.F),new ScaledQuantity(0,Unit.C));
        assertEquals(new ScaledQuantity(0,Unit.F),new ScaledQuantity(-17.7777778,Unit.C));

    }

    @Test
    public void inchesEqualsToFeet(){
        //assertEquals(new ScaledQuantity(1,"INCHES"), new ScaledQuantity(1, "FEET"));
        //using enums
        assertEquals(new ScaledQuantity(12, Unit.Inches), new ScaledQuantity(1, Unit.Feet));
        //assertFalse(new ScaledQuantity(1, ScaledQuantity.Units.INCHES).equals(new ScaledQuantity(12, ScaledQuantity.Units.FEET)));

        assertEquals(new ScaledQuantity(3, Unit.Feet), new ScaledQuantity(1, Unit.Yards));
        assertEquals(new ScaledQuantity(1760, Unit.Yards), new ScaledQuantity(1, Unit.Miles));
        assertEquals(new ScaledQuantity(3, Unit.Tsp), new ScaledQuantity(1, Unit.Tbsp));
        assertEquals(new ScaledQuantity(2, Unit.Tbsp), new ScaledQuantity(1, Unit.Oz));
        assertEquals(new ScaledQuantity(8, Unit.Oz), new ScaledQuantity(1, Unit.Cups));

    }



    @Test
    public void betterThan() throws Exception {
        //assertEquals(new ScaledQuantity(1,"INCHES"), new ScaledQuantity(1, "FEET"));
        //using enums
        assertTrue(new ScaledQuantity(13, Unit.Inches).betterThan(new ScaledQuantity(1, Unit.Feet)));
        assertFalse(new ScaledQuantity(11, Unit.Inches).betterThan(new ScaledQuantity(1, Unit.Feet)));
        assertFalse(new ScaledQuantity(12, Unit.Inches).betterThan(new ScaledQuantity(1, Unit.Feet)));    }



    @Test
    public void getTheBest() throws Exception {
        //assertEquals(new ScaledQuantity(1,"INCHES"), new ScaledQuantity(1, "FEET"));
        //using enums
        ScaledQuantity list[] =  new ScaledQuantity[4];

        list[0] = new ScaledQuantity(14, Unit.Inches);
        list[1] = new ScaledQuantity(11, Unit.Inches);
        list[2] = new ScaledQuantity(160, Unit.Inches);
        list[3] = new ScaledQuantity(1, Unit.Feet);

        assertEquals(new ScaledQuantity(160, Unit.Inches), (new Bester(list)).best());

    }
}
