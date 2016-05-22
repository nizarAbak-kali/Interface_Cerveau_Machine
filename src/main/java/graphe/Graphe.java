package graphe;

import neuron.Neuron;

import java.util.Collection;

/**
 * Created by Alexou on 21/05/2016.
 */
public interface Graphe {

    public int taille();
    public Graphe copie();
    public void ajouterSommet(Sommet<Neuron> s);
    public boolean existeArc(Sommet<Neuron> s, Sommet<Neuron> t);
    public void ajouterArc(Sommet<Neuron> s, Sommet<Neuron> t, int val);
    public int valeurArc(Sommet<Neuron> s, Sommet<Neuron> t);
    public void enleverArc(Sommet<Neuron> s, Sommet<Neuron> t);
    public Collection<Sommet<Neuron>> sommets();
}