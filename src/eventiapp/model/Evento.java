package eventiapp.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/**
 *
 * @author Burghila Flavius
 */
public class Evento implements Comparable<Evento> {

    private String nome, luogo;
    TreeSet<Partecipante> partecipanti;

    public Evento(String nome, String luogo) {
        this.nome = nome;
        this.luogo = luogo;
        partecipanti = new TreeSet<>();
    }

    private void aggiungiPartecipante(Partecipante partecipante) {
        partecipanti.add(partecipante);
    }

    public void caricaPartecipantiEvento(String csvfilename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(csvfilename));
            String s;
            String nominativo;

            while ((s = br.readLine()) != null) {
                String[] ss = s.split(";");
                nominativo = ss[0];
                Partecipante partecipante = new Partecipante(nominativo);
                aggiungiPartecipante(partecipante);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File non trovato");
        } catch (IOException ex) {
            System.out.println("Errore I/O");
        }
    }

    public Partecipante[] getNominativiPartecipanti() {
        Partecipante[] arr = partecipanti.toArray(new Partecipante[partecipanti.size()]);
        return arr;
    }

    public String getNome() {
        return nome;
    }

    public String getLuogo() {
        return luogo;
    }

    @Override
    public String toString() {
        return "Nome:" + nome + "; Luogo:" + luogo;
    }

    @Override
    public int compareTo(Evento t) {
        int x = this.nome.compareTo(t.nome);
        return x == 0 ? this.nome.compareTo(t.nome) : x;
    }

}
