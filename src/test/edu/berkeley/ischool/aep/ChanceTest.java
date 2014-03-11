package edu.berkeley.ischool.aep;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by Ignacio Perez on today.
 */
public class
        ChanceTest {

    @Test
    public void oneChanceShouldNotBeEqualToAnother() {
        Chance coinToss = new Chance(0.5);
        Chance dieThrow = new Chance(0.7);
        assertFalse(dieThrow.equals(coinToss));
        assertEquals(new Chance(0.5), coinToss);
        assertEquals(new Chance(0.3), dieThrow.not());
    }

    @Test
    public void equalsShouldWorkAccordingToContract() {
        Chance coinToss = new Chance(0.5);
        assertFalse(coinToss.equals(null));
        assertFalse(coinToss.equals(new Object()));
    }


    @Test
    public void combinedOutcomeForTwoProbabilities() {
        Chance A = new Chance(0.5);
        Chance B = new Chance(0.5);
        assertEquals(A.combined(B), B.combined(A));
        assertEquals(new Chance(0.25), B.combined(A));
        assertEquals(new Chance(0.25), A.combined(B));
    }


    @Test
    public void getTheBest() throws Exception {
        //assertEquals(new ScaledQuantity(1,"INCHES"), new ScaledQuantity(1, "FEET"));
        //using enums
        Chance list[] =  new Chance[4];

        list[0] = new Chance(0.7);
        list[1] = new Chance(0.6);
        list[2] = new Chance(0.4);
        list[3] = new Chance(0.9);

        assertEquals(new Chance(0.9), (new Bester(list)).best());

    }
}
