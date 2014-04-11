package edu.berkeley.ischool.aep;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by Ignacio on 3/21/14.
 */
public class GolfTest {

    @Test
    public void oneChanceShouldNotBeEqualToAnother() {
        Integer[] parties = new Integer[] {4,4,4};
        assertEquals(3, new Golf(parties).countTotalParties());

        parties = new Integer[] {1};
        assertEquals(1, new Golf(parties).countTotalParties());

        parties = new Integer[] {3,1,2,4,1};
        assertEquals(3, new Golf(parties).countTotalParties());

        parties = new Integer[] {1,1,1,1};
        assertEquals(1, new Golf(parties).countTotalParties());

        parties = new Integer[] {1,1,1,1,2,2};
        assertEquals(2, new Golf(parties).countTotalParties());

        parties = new Integer[] {1,2,3,2};
        assertEquals(3, new Golf(parties).countTotalParties());

        parties = new Integer[] {3,3,3,3};
        assertEquals(4, new Golf(parties).countTotalParties());
    }




}

