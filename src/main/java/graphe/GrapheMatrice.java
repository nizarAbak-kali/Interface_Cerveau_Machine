package graphe;

import neuron.Neuron;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Vector;

/**
 * Created by Alexou on 21/05/2016.
 */
public class GrapheMatrice implements Graphe {

    private Vector<Vector<Arc>> M;
    private Numerotation numerotation;

    /**
     * Constructeur d'une instance d'un graphe sous forme de matrice.
     * @param n
     */

    public GrapheMatrice(int n) {
        this.numerotation = new Numerotation(n);
        this.M = new Vector<Vector<Arc>>(n);
        M.setSize(n);
    }

    public int taille() {
        return M.size();
    }

    public GrapheMatrice copie() {
        int n = taille();
        GrapheMatrice G = new GrapheMatrice(n);
        for(int i=0;i<n;i++) {
            G.ajouterSommet(numerotation.elementAt(i));
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(M.get(i).get(j)!=null) {
                    G.ajouterArc(numerotation.elementAt(i), numerotation.elementAt(j), valeurArc(M.get(i).get(j).origine(), M.get(i).get(j).destination()));
                }
            }
        }
        return G;
    }

    public void ajouterSommet(Sommet<Neuron> s) {
        if(numerotation.ajouterElement(s)) {
            int n = taille();
            Vector<Arc> vs = new Vector<Arc>(n);
            vs.setSize(n);
            M.set(numerotation.numero(s), vs);
        }
    }

    public boolean existeArc(Sommet<Neuron> s, Sommet<Neuron> t) {
        int si = numerotation.numero(s);
        int ti = numerotation.numero(t);
        return M.get(si).get(ti)!=null;
    }

    /**
     * Vérifie si un arc existe entre les deux sommets de numéros respectifs i et j passés en paramètres.
     * @param i
     * @param j
     * @return Vrai s'il y a un arc et faux sinon.
     */

    private boolean existeArc(int i, int j) {
        return M.get(i).get(j)!=null;
    }

    public void ajouterArc(Sommet<Neuron> s, Sommet<Neuron> t, int val) {
        ajouterSommet(s);
        ajouterSommet(t);
        int si = numerotation.numero(s);
        int ti = numerotation.numero(t);
        M.get(si).set(ti, new Arc(s, t, val));
    }

    public int valeurArc(Sommet<Neuron> s, Sommet<Neuron> t) {
        int si = numerotation.numero(s);
        int ti = numerotation.numero(t);
        return M.get(si).get(ti).valeur();
    }

    /**
     * @param i
     * @param j
     * @return La valeur de l'arc entre les sommets de numéros respectifs i et j passés en paramètres.
     */

    private int valeurArc(int i, int j) {
        return M.get(i).get(j).valeur();
    }

    public void enleverArc(Sommet<Neuron> s, Sommet<Neuron> t) {
        int si = numerotation.numero(s);
        int ti = numerotation.numero(t);
        M.get(si).remove(ti);
    }

    public Collection<Sommet<Neuron>> sommets() {
        return numerotation.sommets();
    }

    public void modifierValeur(Sommet<Neuron> s, Sommet<Neuron> t, int val) {
        int si = numerotation.numero(s);
        int ti = numerotation.numero(t);
        M.get(si).get(ti).modifierValeur(val);
    }

    public LinkedList<Arc> voisins(Sommet<Neuron> s) {
        LinkedList<Arc> l = new LinkedList<Arc>();
        int si = numerotation.numero(s);

        for(int j=0;j<taille();j++) {
            if(existeArc(si, j)) {
                l.addLast(M.get(si).get(j));
            }
        }
        return l;
    }

    /**
     *
     * @param M
     * @return Retourne une instance de GrapheMatrice représentant le tableau M passé en paramètre.
     */

    public static GrapheMatrice deMatrice(int [][] M) {
        int n = M.length;
        GrapheMatrice G = new GrapheMatrice(n);

        for(int i=0;i<n;i++) {
            G.ajouterSommet(new Sommet<Neuron>("", i, new Neuron()));
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<M[i].length;j++) {
                if(M[i][j]==1) {
                    G.ajouterArc(G.numerotation.elementAt(i), G.numerotation.elementAt(j), 1);
                }
            }
        }
        return G;
    }
}