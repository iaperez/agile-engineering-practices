package edu.berkeley.ischool.aep;

/**
 * Created by Ignacio on 3/7/14.
 *
 *
 * Find the best
 */
public class Bester {
    private final Bestable[] thingsToCompare;

    public Bester(Bestable[] thingsToCompare) {
        if(thingsToCompare == null) throw new NullPointerException();
        this.thingsToCompare = thingsToCompare;
    }

    public Bestable best() throws Exception {
        Bestable champion = thingsToCompare[0];
        for (Bestable challenger: thingsToCompare)
            if(challenger.betterThan(champion)) champion = challenger;
        return champion;
    }
}
