package graphe;

import neuron.Neuron;

/**
 * Created by Alexou on 21/05/2016.
 */
public class Arc {

    private Sommet<Neuron> o, d;
    private int val;

    public Arc(Sommet<Neuron> o0, Sommet<Neuron> d0, int val0) {
        this.o = o0;
        this.d = d0;
        this.val=val0;
    }

    public Arc(Arc a) {
        this.o = a.o;
        this.d = a.d;
        this.val = a.val;
    }

    public Sommet<Neuron> destination() {
        return this.d;
    }

    public Sommet<Neuron> origine() {
        return this.o;
    }

    public int valeur() {
        return this.val;
    }

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