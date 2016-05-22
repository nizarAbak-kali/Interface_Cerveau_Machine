package graphe;

import neuron.Neuron;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Vector;

/**
 * Created by Alexou on 21/05/2016.
 */
public class Numerotation {

    private int compteur;
    private Hashtable<Sommet<Neuron>, Integer> HSI;
    private Vector<Sommet<Neuron>> VS;

    public Numerotation(int n) {
        this.compteur=-1;
        this.HSI = new Hashtable<Sommet<Neuron>, Integer>();
        this.VS = new Vector<Sommet<Neuron>>(n);
        VS.setSize(n);
    }

    public int taille() {
        return VS.size();
    }

    public boolean ajouterElement(Sommet<Neuron> s) {
        if(!HSI.containsKey(s)) {
            compteur++;
            HSI.put(s, compteur);
            VS.set(compteur, s);
            return true;
        }
        return false;
    }

    public int numero(Sommet s) {
        return HSI.get(s);
    }

    public Sommet<Neuron> elementAt(int i) {
        return VS.elementAt(i);
    }

    public Collection<Sommet<Neuron>> sommets() {
        return VS;
    }
}