package nl.hva.miw.ads.opdracht.opdracht3;



/**
 * Trein klasse. Een opdracht3 is een keten van wagons.
 * Elke wagon heeft een nr.
 *
 * Wagons hebben een positie in de opdracht3. De posities beginnen bij 1 (niet 0!)
 * Deze klasse is aangepast door Dirk van der Straaten, Studentnummer 500837825
 *
 */
public class Trein implements Comparable<Trein> {
    private int lengte;

    private Wagon kop;


    public Trein() {
        this.lengte = 0;
        kop = null;
    }

    public int getLengte() {
        return lengte;
    }

    /**
     * Geeft de wagonnr van de wagon op gegeven positie.
     *
     * Als er geen wagon op die positie niet bestaat wordt -1 teruggegeven.
     *
     * Let op: de eerste wagon zit op positie 1.
     *
     * @param positie
     * @return
     */
    public int geefWagonNr(int positie) {
        if (positie > lengte || positie < 1) {
            return -1;
        }
        Wagon current = kop;
        for (int i = 1; i < positie; i++) {
            current = current.getVolgende();
        }
        return current.getNr();
    }


    /**
     * Zoek de wagon met wagonNr in deze opdracht3 en retourneert de positie van de wagon.
     * Als de wagon er niet in zit, dan wordt 0 geretourneerd.
     *
     * @param wagonNr
     * @return
     */
    public int geefPositie( int wagonNr ) {
        Wagon current = kop;
        for (int i = 1; i <= lengte; i++) {
            if (current.getNr() == wagonNr) return i;
            current = current.getVolgende();
        }
        return 0;
    }

    /**
     * Voegt een wagon met wagonNr toe aan de opdracht3 op de gegeven positie.
     * Let op eerste wagon zit op postie 1. Als positie groter is dan de lengte van de
     * opdracht3 dan wordt een wagon aan het einde toegevoegd.
     *
     * @param wagonNr - wagon nummer.
     */
    public void voegWagonToe( int wagonNr, int positie ) {
        System.out.println("voegWagonToe: " + wagonNr + " op positie " + positie );
        if(this.geefPositie(wagonNr) != 0){
            System.out.println("Let op: er is al een wagon met dit nummer in de trein.");
        } else {
            if (positie == 1) {
                Wagon newWagon = new Wagon(wagonNr);
                newWagon.setVolgende(kop);
                kop = newWagon;
                lengte++;

            } else if (positie > lengte) {
                Wagon newWagon = new Wagon(wagonNr);
                Wagon current = kop;
                for (int i = 1; i < lengte; i++) {
                    current = current.getVolgende();
                }
                current.setVolgende(newWagon);
                lengte++;

            } else {
                Wagon current = kop;
                for (int i = 1; i < positie - 1; i++) {
                    current = current.getVolgende();
                }
                Wagon temp = current.getVolgende();
                current.setVolgende(new Wagon(wagonNr));
                (current.getVolgende()).setVolgende(temp);
                lengte++;
            }
        }
    }



    /**
     * haalt een wagon op een gegeven positie uit een opdracht3.
     * Let op eerste wagon zit op postie 1.
     *
     * @param positie - positie.
     */
    public void verwijderWagon( int positie ) {
        System.out.println("verwijderWagon op positie " + positie );
        if (positie == 1) {
            kop = kop.getVolgende();
            lengte--;
        } else {
            Wagon vorige = kop;
            for (int i = 2; i < positie; i++) {
                vorige = vorige.getVolgende();
            }

            Wagon current = vorige.getVolgende();
            if (positie == lengte) {
                vorige.setVolgende(null);
            } else vorige.setVolgende(current.getVolgende());
            lengte--;
        }
    }

    /**
     * Hulp methode.
     *
     * @param w
     * @return
     */
    private Wagon geefVolgende(Wagon w) {
        return w.getVolgende();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Trein{ lengte=" + lengte + " }");
        Wagon w = kop;
        while (w != null ) {
            sb.append( " " + w.getNr() );
            w = geefVolgende(w);
        }

        return sb.toString();
    }

    public int getSomVanWagonNummers (){
        int count = 0;
        if (kop != null) {
            count = kop.getNr();
            Wagon wagon = kop;
            while (wagon.getVolgende() != null) {
                count += wagon.getVolgende().getNr();
                wagon = wagon.getVolgende();
            }
        }
        return count;
    }

    @Override
    public int compareTo(Trein o) {
        return lengte - o.lengte;
    }
}
