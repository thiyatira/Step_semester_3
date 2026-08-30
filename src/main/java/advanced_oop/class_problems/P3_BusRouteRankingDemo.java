package advanced_oop.class_problems;

/**
 * Week 4 Practice - Problem 3: Bus Route Ranking Demo
 */
public class P3_BusRouteRankingDemo {

    public static void main(String[] args) {
        BusRoute[] routes = {
            new BusRoute("RT205L", "Airport Express", 3),
            new BusRoute("rt201j", "City Central", 4),
            new BusRoute("RT299T", "Night Service") // priority defaults to 1
        };

        BusRoute[] ranked = BusRoute.rankRoutes(routes);

        System.out.print("[");
        for (int i = 0; i < ranked.length; i++) {
            System.out.print("\"" + ranked[i].getRouteCode() + "\"");
            if (i < ranked.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
