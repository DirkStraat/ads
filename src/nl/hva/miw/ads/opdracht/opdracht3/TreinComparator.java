/**
 * Deze klasse maakt vergelijking van treinen op basis van wagonnrs mogelijk.
 *
 *Deze klasse is geschreven door Dirk van der Straaten, student nummer 500837825
 */



package nl.hva.miw.ads.opdracht.opdracht3;

import java.util.Comparator;

public class TreinComparator implements Comparator<Trein> {
    @Override
    public int compare(Trein o1, Trein o2) {
        int somVanWagonNrs1 = o1.getSomVanWagonNummers();
        int somVanWagonNrs2 = o2.getSomVanWagonNummers();

        if (somVanWagonNrs1 < somVanWagonNrs2){
            return -1;
        } else if (somVanWagonNrs1 == somVanWagonNrs2){
            return 0;
        } else return 1;

    }
}
