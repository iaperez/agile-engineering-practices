package edu.berkeley.ischool.aep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Ignacio on 3/21/14.
 */
public class Golf {
    private final List<Integer> parties;

    public Golf(Integer[] parties) {
        this.parties = new ArrayList<Integer>(Arrays.asList(parties));
    }

    public int countTotalParties() {

        int count = 0;

        while (!parties.isEmpty()) {

            //first element is always a party
            Integer party = parties.get(0);
            parties.remove(0);
            count++;

            //and then we check if we can complete the party
            Iterator it = parties.iterator();
            while (it.hasNext()) {
                Integer possiblePartner = (Integer) it.next();
                if (possiblePartner + party <= 4) {
                    party += possiblePartner;
                    it.remove();
                }
                if (party == 4) break;
            }
        }

        return count;
    }
}
