package eventiapp;

import eventiapp.model.ListaEventi;
import java.util.Arrays;

/**
 *
 * @author Burghila Flavius
 */
public class EventiApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ListaEventi le = new ListaEventi("./data/index.csv");
        System.out.println("Ci sono questi Eventi:");
        System.out.println(Arrays.toString(le.getNomiEventi()));
        System.out.println("In questi Luoghi:");
        System.out.println(Arrays.toString(le.getLuoghiEventi()));

        // le.stampa();
        System.out.println();
        
        System.out.println("All'evento: " + le.getEvento(0).getNome() + "\n" + "partecipano: " + Arrays.toString(le.getEvento(0).getNominativiPartecipanti()));
        System.out.println("-------------------------------------");
        
        System.out.println("All'evento: " + le.getEvento(1).getNome() + "\n" + "partecipano: " + Arrays.toString(le.getEvento(1).getNominativiPartecipanti()));
        System.out.println("-------------------------------------");
        
        System.out.println("All'evento: " + le.getEvento(2).getNome() + "\n" + "partecipano: " + Arrays.toString(le.getEvento(2).getNominativiPartecipanti()));

    }
}
