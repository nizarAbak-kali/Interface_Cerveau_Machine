package graphe;

import neuron.Neuron;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Vector;

/**
 * Created by Alexou on 21/05/2016.
 */

public class GrapheListe implements Graphe {

    private Vector<LinkedList<Arc>> L;
    private Numerotation numerotation;

    /**
     * Constructeur d'une isntance d'un graphe sous forme de liste.
     * @param n
     */

    public GrapheListe(int n) {
        this.numerotation = new Numerotation(n);
        L = new Vector<LinkedList<Arc>>(n);
        L.setSize(n);
    }

    public int taille() {
        return L.size();
    }

    public GrapheListe copie() {
        int n = taille();
        GrapheListe G = new GrapheListe(n);
        for(int i = 0;i<n;i++) {
            G.ajouterSommet(numerotation.elementAt(i));
        }
        for(int i=0;i<n;i++) {
            LinkedList<Arc> Li = G.L.get(i);
            for(Arc a:L.get(i)) {
                Li.addLast(a);
            }
        }
        return G;
    }

    public void ajouterSommet(Sommet<Neuron> s) {
        if(numerotation.ajouterElement(s)) {
            L.set(numerotation.numero(s), new LinkedList<Arc>());
        }
    }

    public boolean existeArc(Sommet<Neuron> s, Sommet<Neuron> t) {
        for(Arc a:L.get(numerotation.numero(s))) {
            if(a.destination().equals(t)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Teste s'il existe un arc entre deux sommets de numéros respectifs i et j.
     * @param i
     * @param j
     * @return Vrai s'il y a un arc entre les deux sommets, faux sinon.
     */

    private boolean existeArc(int i, int j) {
        Sommet<Neuron> t = numerotation.elementAt(j);
        for(Arc a:L.get(i)) {
            if(a.destination().equals(t)) {
                return true;
            }
        }
        return false;
    }

    public void ajouterArc(Sommet<Neuron> s, Sommet<Neuron> t, int val) {
        ajouterSommet(s);
        ajouterSommet(t);
        int si = numerotation.numero(s);
        L.get(si).addLast(new Arc(s, t, val));
    }

    /**
     * Permet d'ajouter un arc entre deux sommets de numéros respectifs i et j en lui attribuant la valeur val.
     * @param i
     * @param j
     * @param val
     */

    public void ajouterArc(int i, int j, int val) {
        L.get(i).addLast(new Arc(numerotation.elementAt(i), numerotation.elementAt(j), val));
    }

    public int valeurArc(Sommet<Neuron> s, Sommet<Neuron> t) {
        for(Arc a:L.get(numerotation.numero(s))) {
            if(a.destination().equals(t)) {
                return a.valeur();
            }
        }
        return -1;
    }

    /**
     * @param i
     * @param j
     * @return La valeur de l'arc entre les deux sommets de numéros respectifs i et j.
     */

    public int valeurArc(int i, int j) {
        Sommet<Neuron> t = numerotation.elementAt(j);
        for(Arc a:L.get(i)) {
            if(a.destination().equals(t)) {
                return a.valeur();
            }
        }
        return -1;
    }

    public void enleverArc(Sommet<Neuron> s, Sommet<Neuron> t) {
        int si = numerotation.numero(s);
        Arc a = null;
        for(Arc aa:L.get(numerotation.numero(s))) {
            if(aa.destination().equals(t)) {
                a = aa;
                break;
            }
            if(a!=null) {
                L.get(numerotation.numero(s)).remove(a);
            }
        }
    }

    public Collection<Sommet<Neuron>> sommets() {

        return numerotation.sommets();
    }

    public LinkedList<Arc> voisins(Sommet<Neuron> s) {
        return L.get(numerotation.numero(s));
    }

    public void modifierValeur(Sommet<Neuron> s, Sommet<Neuron> t, int val) {
        for(Arc a : L.get(numerotation.numero(s))) {
            if(a.destination().equals(t)) {
                a.modifierValeur(val);
            }
        }
    }
}