package graphe;

import neuron.Neuron;

/**
 * Created by Alexou on 21/05/2016.
 */
public class Sommet<T extends Neuron> {
    private String nom;
    private int marque;
    private T valeur;

    public Sommet(String nom, int num, T valeur) {
        this.nom=nom;
        this.marque=num;
        this.valeur = valeur;
    }

    public Sommet(Sommet s, int num, T valeur) {
        this.nom=s.nom;
        this.marque=num;
        this.valeur=valeur;
    }

    public int valeurMarque() {
        return this.marque;
    }

    public void modifierMarque(int m) {
        this.marque=m;
    }

    public boolean equals(Object o) {
        return nom.equals(((Sommet)o).nom);
    }

    public int compareTo(Object o) {
        Sommet s = (Sommet)o;
        return nom.compareTo(s.nom);
    }

    public String toString() {
        return ""+ nom;
    }

    public int hashCode() {
        return nom.hashCode();
    }

    public T getValeur() {
        return this.valeur;
    }

    public String getNom() {
        return this.nom;
    }
}