package nl.hva.miw.ads.opdracht.opdracht3;

/**
 * Rangeerder klasse.
 *
 * Kan met treinen omgaan.
 *
 * @author michel
 * Deze klasse is aangepast door Dirk van der Straaten, Studentnummer 500837825
 */
public class Rangeerder {


    /**
     * Haalt wagon met nr wagonNr uit trein1 en voegt ze achteraan trein2 toe.
     *
     * @param trein1
     * @param trein2
     * @param wagonNr
     */
    public void verplaatsWagon( Trein trein1, Trein trein2, int wagonNr ) {
        if(trein1.geefPositie(wagonNr) != 0){
            trein1.verwijderWagon(trein1.geefPositie(wagonNr));
            trein2.voegWagonToe(wagonNr, trein2.getLengte()+1);
        }
    }

    /**
     * Voegt een nieuwe wagon toe aan de opdracht3 achter wagon met nr wagonNr.
     *
     * Als wagon met wagonNr er niet in zit, dan wordt de wagon NIET toegvoegd.
     *
     * @param trein
     * @param nieuweWagonNr
     * @param wagonNr
     */
    public void hangWagonAchterAndereWagon( Trein trein, int nieuweWagonNr, int wagonNr ) {
        int positie = trein.geefPositie(wagonNr);
        if (positie != 0){
            trein.voegWagonToe(nieuweWagonNr, positie+1);
        }
    }

    /**
     * Voegt een nieuwe wagon toe aan de opdracht3 voor wagon met nr wagonNr.
     *
     * Als wagon met wagonNr er niet in zit, dan wordt de wagon NIET toegvoegd.
     *
     * @param trein
     * @param nieuweWagonNr
     * @param wagonNr
     */
    public void hangWagonVoorAndereWagon( Trein trein, int nieuweWagonNr, int wagonNr ) {
        int positie = trein.geefPositie(wagonNr);
        if (positie != 0){
            trein.voegWagonToe(nieuweWagonNr, positie);
        }
    }

    /**
     * Retourneert een nieuwe trein waarbij de wagons uit Trein trein in volgorde van
     * wagonNr staan (van klein naar groot).
     *
     * @param trein
     */
    public Trein sorteerWagons( Trein trein ) {
        // Implementeer deze methode

        return null;
    }

}
