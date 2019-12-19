/**
 * Deze klasse is aangepast door Dirk van der Straaten, Studentnummer 500837825
 */

package nl.hva.miw.ads.opdracht.opdracht1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Route {

    private static final Character AVENUE = 'A' ;
    private static final Character STREET = 'S' ;

    private int nrOfAvenues;
    private int nrOfStreets;

    private String route;


    public Route(int nrOfAvenues, int nrOfStreets) {
        this.nrOfAvenues = nrOfAvenues;
        this.nrOfStreets = nrOfStreets;
    }


    /**
     * Make a random route for this combination of streets and avenues.
     *
     * You can get the route by calling getRoute();
     *
     */
    public void makeRandomRoute() {
        List<Character> l = initializeRouteArray();

        Collections.shuffle( l );

        route = routeToString( l );
    }

    /**
     * Returns the route as a String.
     *
     * @return
     */
    public String getRoute() {
        return route;
    }

    /**
     * Retourneert de omgekeerde route.
     *
     * @return
     */
    public String makeHomeroute() {
        Stack<Character> routeStack = new Stack();
        StringBuilder routeTerug = new StringBuilder();

        for (int i = 0; i <route.length() ; i++) {
            routeStack.push(route.charAt(i));
        }

        for (int i = 0; i <route.length() ; i++) {
            char ch = routeStack.pop();
            routeTerug.append(ch);
        }
        return routeTerug.toString();
    }


    /**
     * Hulpmethode om een array te vullen met A's en S'en.
     *
     * @return
     */
    private List<Character> initializeRouteArray() {
        List<Character> l = new ArrayList<>();
        for (int i=0; i<nrOfAvenues; i++) {
            l.add( AVENUE );
        }
        for (int i=0; i<nrOfStreets; i++) {
            l.add( STREET );
        }

        return l;
    }

    /**
     * Hulpmethode om een string te maken van een lijst van characters.
     *
     * @param routeList
     * @return
     */
    private String routeToString(List<Character> routeList) {
        String result = "";

        for ( Character c : routeList ) {
            result += c;
        }

        return result;
    }
}
