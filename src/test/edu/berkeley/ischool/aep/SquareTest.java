package edu.berkeley.ischool.aep;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;


/**
 * Created by Ignacio on 2/7/14.
 */
public class SquareTest {


    @Test
    public void squareHasAllSideEquals() {
        Square square = new Square(4);
        assertEquals(16.0,square.Area());
    }



}
