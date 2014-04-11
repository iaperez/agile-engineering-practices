package edu.berkeley.ischool.aep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ignacio on 3/21/14.
 */
public class Golf_Optimizely {
    private final List<Integer> parties;

    public Golf_Optimizely(Integer[] parties) {
        this.parties = new ArrayList<Integer>(Arrays.asList(parties));
    }

    public int countTotalParties() {



        int bestBuy = 0; //3
        int bestSell = 0; //5
        int[] a = {100, 70, 30, 80,  40, 60, 15, 20, 10};
        int profit = 0;
        int maxProfit = 0;
        int buy = 0;
        for(int sell = buy; sell < a.length; sell++){
            profit = a[sell]-a[buy];
            if (maxProfit<profit){
                bestSell = sell;
                maxProfit = profit;
                bestBuy = buy;
            }
            if (profit<0){
                buy = sell;
            }

        }







        int count = 0;

        for (Integer party : parties) {
            for (Integer extraParty : parties) {

            }
        }
        return count;
    }
}
