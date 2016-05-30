package graphe;

import neuron.Neuron;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Vector;

/**
 * Created by Alexou on 21/05/2016.
 * Classe gérant la collection d'éléments du graphe.
 */
public class Numerotation {

    private int compteur;
    private Hashtable<Sommet<Neuron>, Integer> HSI;
    private Vector<Sommet<Neuron>> VS;

    /**
     * Constructeur d'une instance de la classe Numérotation.
     * @param n
     */

    public Numerotation(int n) {
        this.compteur=-1;
        this.HSI = new Hashtable<Sommet<Neuron>, Integer>();
        this.VS = new Vector<Sommet<Neuron>>(n);
        VS.setSize(n);
    }

    /**
     *
     * @return La taille du vecteur de sommets.
     */

    public int taille() {
        return VS.size();
    }

    /**
     * Permet d'ajouter un sommet à la HashTable du graphe.
     * @param s
     * @return
     */

    public boolean ajouterElement(Sommet<Neuron> s) {
        if(!HSI.containsKey(s)) {
            compteur++;
            HSI.put(s, compteur);
            VS.set(compteur, s);
            return true;
        }
        return false;
    }

    /**
     * @param s
     * @return Le numéro associé au sommet passé en paramètre.
     */

    public int numero(Sommet s) {
        return HSI.get(s);
    }

    /**
     * @param i
     * @return Le sommet associé au numéro passé en paramètre.
     */

    public Sommet<Neuron> elementAt(int i) {
        return VS.elementAt(i);
    }

    /**
     * @return Tous les sommets du graphe.
     */

    public Collection<Sommet<Neuron>> sommets() {
        return VS;
    }
}