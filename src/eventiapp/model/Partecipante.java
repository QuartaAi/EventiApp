package eventiapp.model;

/**
 *
 * @author Burghila Flavius
 */
public class Partecipante implements Comparable<Partecipante> {

    private String nominativo;

    public Partecipante(String nominativo) {
        this.nominativo = nominativo;
    }

    public String getNominativo() {
        return nominativo;
    }

    @Override
    public String toString() {
        return nominativo;
    }

    @Override
    public int compareTo(Partecipante t) {
        int x = nominativo.compareTo(t.nominativo);
        return x == 0 ? this.nominativo.compareTo(t.nominativo) : x;
    }
}
