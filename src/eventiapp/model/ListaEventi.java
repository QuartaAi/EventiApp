package eventiapp.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Burghila Flavius
 */
public class ListaEventi {

    private ArrayList<Evento> lista;
    private Evento evento;

    public ListaEventi(String csvfilename) {
        lista = new ArrayList();
        caricaDaFile(csvfilename);
    }

    private int caricaDaFile(String csvfilename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(csvfilename));
            String s;

            while ((s = br.readLine()) != null) {
                String[] ss = s.split(";");
                evento = new Evento(ss[0], ss[1]);
                aggiungiEvento(evento);
                evento.caricaPartecipantiEvento("data/" + evento.getNome() + ".csv");
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File non trovato");
        } catch (IOException ex) {
            System.out.println("Errore I/O");
        }
        return 1;
    }

    private void aggiungiEvento(Evento evento) {
        lista.add(evento);
    }

    public Evento getEvento(int idx) {
        return lista.get(idx);
    }

    public String[] getNomiEventi() {
        String[] arr = new String[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            arr[i] = lista.get(i).getNome();
        }
        return arr;
    }

    public String[] getLuoghiEventi() {
        String[] arr = new String[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            arr[i] = lista.get(i).getLuogo();
        }
        return arr;
    }

    public void stampa() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return lista + " ";
    }

}
