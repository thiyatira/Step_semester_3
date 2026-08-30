package advanced_oop.assigment_problems;

import java.util.ArrayList;
import java.util.List;

// testing canteen ranking
public class P3_CanteenRankingEngine {
    public static void main(String[] args) {
        Canteen[] input = {
            new Canteen("HB3-C", "Spice Junction", 3),
            new Canteen("hb1-c", "Grand Mess", 5),
            new Canteen("HB2-C", "Southern Treats") // defaults to score 3
        };

        Canteen[] ranked = Canteen.rankCanteens(input);

        List<String> rankedCodes = new ArrayList<>();
        for(Canteen c : ranked) {
            rankedCodes.add(c.getCanteenCode());
        }

        System.out.println("Ranked Canteen Codes: " + rankedCodes);
        for(int i = 0; i < ranked.length; i++) {
            System.out.printf("%d. %s (%s) - Score: %d%n",
                    i + 1, ranked[i].getCanteenCode(), ranked[i].getCanteenName(), ranked[i].getTrustScore());
        }
    }
}
