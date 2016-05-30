package graphe;

import neuron.Neuron;

/**
 * Created by Alexou on 21/05/2016.
 * Classe représentant les liaisons entre les sommets d'un graphe de neurones.
 */
public class Arc {

    private Sommet<Neuron> o, d;
    private int val;

    /**
     * Constructeur d'une instance de la classe Arc.
     * @param o0:origine
     * @param d0:destination
     * @param val0:valeur
     */

    public Arc(Sommet<Neuron> o0, Sommet<Neuron> d0, int val0) {
        this.o = o0;
        this.d = d0;
        this.val=val0;
    }

    /**
     * Autre constructeur d'une instance de la classe Arc à partir d'un Arc passé en paramètre.
     * @param a:Arc
     */

    public Arc(Arc a) {
        this.o = a.o;
        this.d = a.d;
        this.val = a.val;
    }

    /**
     *
     * @return Le point d'arrivée de l'arc.
     */

    public Sommet<Neuron> destination() {
        return this.d;
    }

    /**
     *
     * @return Le point d'origine de l'arc.
     */

    public Sommet<Neuron> origine() {
        return this.o;
    }

    /**
     *
     * @return La valeur de l'arc.
     */

    public int valeur() {
        return this.val;
    }

    /**
     * Permet de modifier la valeur de l'arc courant.
     * @param nouvelleValeur
     */

    public void modifierValeur(int nouvelleValeur) {
        this.val = nouvelleValeur;
    }

    @Override
    public String toString() {
        return "Arc{" +
                "o=" + o +
                ", d=" + d +
                ", val=" + val +
                '}';
    }

    @Override
    public boolean equals(Object o1) {
        if (this == o1) return true;
        if (o1 == null || getClass() != o1.getClass()) return false;

        Arc arc = (Arc) o1;

        if (val != arc.val) return false;
        if (!o.equals(arc.o)) return false;
        return d.equals(arc.d);

    }

    @Override
    public int hashCode() {
        int result = o.hashCode();
        result = 31 * result + d.hashCode();
        result = 31 * result + val;
        return result;
    }
}