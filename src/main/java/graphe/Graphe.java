package graphe;

import neuron.Neuron;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by Alexou on 21/05/2016.
 * Interface représentant le modèle des graphes qui sera implémenté par les classes GrapheListe et GrapheMatrice.
 */
public interface Graphe {

    /**
     *
     * @return La taille du graphe.
     */

    public int taille();

    /**
     *
     * @return Une copie du graphe courant.
     */

    public Graphe copie();

    /**
     * Ajoute un nouveau sommet au graphe.
     * @param s
     */

    public void ajouterSommet(Sommet<Neuron> s);

    /**
     * Vérifie si un arc existe entre les deux sommets passés en paramètres.
     * @param s
     * @param t
     * @return Vrai si un arc existe entre les deux sommets, faux sinon.
     */

    public boolean existeArc(Sommet<Neuron> s, Sommet<Neuron> t);

    /**
     * Permet d'ajouter un arc entre les deux sommets passés en paramètres et de lui attribuer une valeur.
     * @param s
     * @param t
     * @param val
     */

    public void ajouterArc(Sommet<Neuron> s, Sommet<Neuron> t, int val);

    /**
     * @param s
     * @param t
     * @return La valeur de l'arc reliant les deux sommets passés en paramètres.
     */

    public int valeurArc(Sommet<Neuron> s, Sommet<Neuron> t);

    /**
     * Permet d'enlever l'arc entre les deux sommets passés en paramètres s'il y en a un.
     * @param s
     * @param t
     */

    public void enleverArc(Sommet<Neuron> s, Sommet<Neuron> t);

    /**
     *
     * @return La liste des sommets du graphe.
     */

    public Collection<Sommet<Neuron>> sommets();

    /**
     *
     * @param s
     * @return Les sommets voisins du sommet passé en paramètre. Retourne une liste vide s'il n'y en a pas.
     */

    public LinkedList<Arc> voisins(Sommet<Neuron> s);

    /**
     * Permet de modifier la valeur de l'arc reliant les deux sommets passés en paramètres en lui affectant la valeur passée, elle aussi, en paramètre.
     * @param s
     * @param t
     * @param val
     */

    public void modifierValeur(Sommet<Neuron> s, Sommet<Neuron> t, int val);
}