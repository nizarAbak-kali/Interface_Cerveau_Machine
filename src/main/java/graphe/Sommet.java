package graphe;

import neuron.Neuron;

/**
 * Created by Alexou on 21/05/2016.
 * Classe représentant les emplacements des neurones du réseau.
 */
public class Sommet<T extends Neuron> {
    private String nom;
    private int marque;
    private T valeur;

    /**
     * Constructeur d'une instance de la classe Sommet
     * @param nom
     * @param num
     * @param valeur
     */

    public Sommet(String nom, int num, T valeur) {
        this.nom=nom;
        this.marque=num;
        this.valeur = valeur;
    }

    /**
     * Autre constructeur d'une instance de la classe Sommet à partir d'un sommet passé en paramètre.
     * @param s
     * @param num
     * @param valeur
     */

    public Sommet(Sommet s, int num, T valeur) {
        this.nom=s.nom;
        this.marque=num;
        this.valeur=valeur;
    }

    /**
     * @return Le numéro du sommet
     */

    public int valeurMarque() {
        return this.marque;
    }

    /**
     * Permet de modifier le numéro du sommet
     * @param m
     */

    public void modifierMarque(int m) {
        this.marque=m;
    }

    public boolean equals(Object o) {
        return nom.equals(((Sommet)o).nom);
    }


    /**
     * Permet de comparer le sommet courant à un autre sommet passé en paramètre.
     * @param o
     * @return
     */
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

    /**
     *
     * @return Le neurone associé sur lequel on peut ensuite retourner et/ou modifier les attributs.
     */

    public T getValeur() {
        return this.valeur;
    }

    /**
     *
     * @return Le nom du sommet.
     */

    public String getNom() {
        return this.nom;
    }
}