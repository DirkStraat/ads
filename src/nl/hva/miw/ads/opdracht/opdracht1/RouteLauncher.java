/**
 * Deze klasse is aangepast door Dirk van der Straaten, Studentnummer 500837825
 */

package nl.hva.miw.ads.opdracht.opdracht1;

import java.util.HashMap;
import java.util.Map;

public class RouteLauncher {

    Route r;

    public RouteLauncher( int nrAvenues, int nrStreets) {
        r = new Route( nrAvenues, nrStreets );
    }

    /**
     * Gebruik de route om een experiment te doen en te meten hoe vaak een route wordt gegenereerd.
     *
     */
    private void doeExperiment() {
        Map<String, Integer> routemap = new HashMap<>();
        int aantalRoutes = 100;

        for (int i = 0; i <aantalRoutes ; i++) {
            r.makeRandomRoute();
            Integer cnt = routemap.get(r.getRoute());
            if (cnt == null){
                routemap.put(r.getRoute(), 1);
            } else {
                routemap.put(r.getRoute(), cnt + 1);
            }
        }

        for (String key : routemap.keySet()) {
            System.out.printf("De route: %s, komt %d keer voor in deze set.\n", key, routemap.get(key));
        }

    }

    /**
     * Test de routes door er een aantal te genereren.
     */
    private void testRoutes() {
        r.makeRandomRoute();
        System.out.println("Route " + r.getRoute() );
        System.out.println(r.makeHomeroute());

        r.makeRandomRoute();
        System.out.println("Route " + r.getRoute() );
        System.out.println(r.makeHomeroute());


        r.makeRandomRoute();
        System.out.println("Route " + r.getRoute() );
        System.out.println(r.makeHomeroute());

    }


    public static void main(String[] args) {

        RouteLauncher rl = new RouteLauncher( 6, 3);

        // Test routes
        rl.testRoutes();

        // Doe experiment
        rl.doeExperiment();
    }
}