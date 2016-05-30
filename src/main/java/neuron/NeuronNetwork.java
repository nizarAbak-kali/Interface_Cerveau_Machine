package neuron;

import graphe.Graphe;
import graphe.GrapheListe;
import graphe.GrapheMatrice;
import graphe.Sommet;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Alexou on 10/03/2016.
 * Classe modélisant le réseau de neurones.
 */
public class NeuronNetwork {

    private Graphe neurons;
    private CaracteristiqueTemporel caracteristiquesTemporelles;
    private ArrayList<Sommet<Neuron>> sommets;

    /**
     * Constructeur du réseau de neurones.
     */

    public NeuronNetwork(int n) {
        this.neurons=new GrapheListe(n);
        init();
        //caracteristiquesTemporelles=new CaracteristiqueTemporel();
    }

    /**
     * Initialisation du poids de tous les neurones.
     */

    private void init() {

        float minimalWeight = (float) (-2.4/this.neurons.taille());
        float maximalWeight = (float) (2.4/this.neurons.taille());
        Random r = new Random();
        sommets = (ArrayList<Sommet<Neuron>>) this.neurons.sommets();

        for(int i=0;i<this.neurons.taille();i++) {
            sommets.get(i).getValeur().setWeight(minimalWeight + (r.nextFloat() + minimalWeight) - maximalWeight);
        }

    }

    /**
     * Initialise la liste des neurones.
     * @return La liste des neurones nouvellement créée.
     */

    private Graphe remplirArrayList() {
        Random r = new Random();
        int nbMinimalNeurons=10;
        int nbMaximalNeurons=100;
        int nbNeurons=nbMinimalNeurons + r.nextInt(nbMaximalNeurons - nbMinimalNeurons);

        for(int i=0;i<=nbNeurons;i++) {
            ajouterNeuron(new Sommet<Neuron>("Sommet N° " + i+1, i+1, new Neuron()));
        }

        return this.neurons;
    }

    /**
     *
     * @return La liste des neurones.
     */

    public ArrayList<Sommet<Neuron>> getNeurons() {
        return this.sommets;
    }

    /**
     *
     * @return Les caractéristiques temporelles de tous les neurones.
     */

    public CaracteristiqueTemporel getCaracteristiquesTemporelles() {
        return this.caracteristiquesTemporelles;
    }

    /**
     * Permet de modifier les caractéristiques temporelles.
     * @param caracteristiquesTemporelle: CaracteristiqueTemporel
     */

    public void setCaracteristiquesTemporelless(CaracteristiqueTemporel caracteristiquesTemporelle) {
        this.caracteristiquesTemporelles=caracteristiquesTemporelle;
    }

    /**
     * Permet d'ajouter un nouveau neurone à la liste des neurones.
     * @param s:Neuron
     */

    public void ajouterNeuron(Sommet<Neuron> s) {
        this.neurons.ajouterSommet(s);
    }

    /**
     * Permet de supprimer de la liste de neurones le neurone passé en paramètre.
     * @param s:Sommet<Neuron>
     * @Param t:Sommet<Neuron>
     */

    public void supprimerNeuron(Sommet<Neuron> s, Sommet<Neuron> t) {
        for(int i=0;i<this.neurons.taille();i++) {
            if(this.sommets.get(i).getValeur().equals(s) || this.sommets.get(i).getValeur().equals(t)) {
                this.neurons.enleverArc(s, t);
            }
        }
    }

    /**
     * Permet de mettre à jour les valeurs des neurones avec la valeur passée en paramètre (la même pour tous).
     * @param newValue:float
     */

    public void updateValues(float newValue) {
        for (int i = 0; i < this.neurons.taille(); i++) {
            this.sommets.get(i).getValeur().setValue(newValue);
        }
    }

    /**
     * Permet de mettre à jour la valeur de tous les neurones en passant la liste des nouvelles valeurs à attribuer aux neurones en paramètre.
     * @param newValues:ArrayList<Float>
     * @throws LongueurDifferenceException
     */

    public void updateValues(ArrayList<Float> newValues) throws LongueurDifferenceException {
        if(this.neurons.taille()==newValues.size()) {
            for (int i = 0; i < this.neurons.taille(); i++) {
                for (int j = 0; j < newValues.size(); j++) {
                    this.sommets.get(i).getValeur().setValue(newValues.get(j));
                }
            }
        }
        else {
            throw new LongueurDifferenceException();
        }
    }

    /**
     * Permet de mettre à jour le poids de chaque neurone avec la valeur passée en paramètre (la même pour tous).
     * @param newWeight:foat
     */

    public void updateWeights(float newWeight) {
        for(int i=0;i<this.neurons.taille();i++) {
            this.sommets.get(i).getValeur().setWeight(newWeight);
        }
    }

    /**
     * Permet de mettre à jour le poids de tous les neurones grâce à la liste des nouveaux poids passée en paramètre.
     * @param newWeights:ArrayList<Float>
     * @throws LongueurDifferenceException
     */

    public void updateWeights(ArrayList<Float> newWeights) throws LongueurDifferenceException {
        if(this.neurons.taille()==newWeights.size()) {
            for(int i=0;i<this.neurons.taille();i++) {
                for(int j=0;j<newWeights.size();j++) {
                    this.sommets.get(i).getValeur().setWeight(newWeights.get(j));
                }
            }
        }
        else {
            throw new LongueurDifferenceException();
        }
    }

    /**
     * Permet de mettre à jour les données de tous les neurones avec la valeur passée en paramètre (la même pour tous).
     * @param newDonnee:float
     */

    public void updateDonnees(float newDonnee) {
        for(int i=0;i<this.neurons.taille();i++) {
            this.sommets.get(i).getValeur().setDonnee(newDonnee);
        }
    }

    /**
     * Permet de mettre à jour les données de tous les neurones en passant en paramètre la liste des nouvelles données.
     * @param newDonnees:ArrayList<Float>
     * @throws LongueurDifferenceException
     */

    public void updateDonnees(ArrayList<Float> newDonnees) throws LongueurDifferenceException {
        if(this.neurons.taille()==newDonnees.size()) {
            for(int i=0;i<this.neurons.taille();i++) {
                for(int j=0;j<newDonnees.size();j++) {
                    this.sommets.get(i).getValeur().setDonnee(newDonnees.get(j));
                }
            }
        }
        else {
            throw new LongueurDifferenceException();
        }
    }

    /**
     * Permet de mettre à jour les gradients d'erreur de tous les neurones avec le nouveau gradient d'erreur passé en paramètre (le même pour tous).
     * @param newErrorGradient:float
     */

    public void updateErrorGradients(float newErrorGradient) {
        for(int i=0;i<this.neurons.taille();i++) {
            this.sommets.get(i).getValeur().setErrorGradient(newErrorGradient);
        }
    }

    /**
     * Permet de mettre à jour tous les gradients d'erreurs de tous les neurones grâce à la liste des nouveaux gradients d'erreurs passée en paramètre.
     * @param newErrorGradients:ArrayList<Float>
     * @throws LongueurDifferenceException
     */

    public void updateErrorGradients(ArrayList<Float> newErrorGradients) throws LongueurDifferenceException {
        if(this.neurons.taille()==newErrorGradients.size()) {
            for(int i=0;i<this.neurons.taille();i++) {
                for(int j=0;j<newErrorGradients.size();j++) {
                    this.sommets.get(i).getValeur().setErrorGradient(newErrorGradients.get(j));
                }
            }
        }
        else {
            throw new LongueurDifferenceException();
        }
    }

    /**
     * Permet de mettre la valeur d'un neurone à jour en passant le neurone que l'on veut modifier ainsi que sa nouvelle valeur en paramètres.
     * @param neuron:int
     * @param newValue:float
     */

    public void updateValueNeuron(int neuron, float newValue) {
        for(int i=0;i<this.neurons.taille();i++) {
            if(this.sommets.get(i).getValeur().equals(neuron)) {
                this.sommets.get(i).getValeur().setValue(newValue);
            }
        }
    }

    /**
     * Permet de mettre le poids d'un neurone à jour en passant le neurone que l'on veut modifier ainsi que le nouveau poids en paramètres.
     * @param neuron:int
     * @param newWeight:float
     */

    public void updateWeightNeuron(int neuron, float newWeight) {
        for(int i=0;i<this.neurons.taille();i++) {
            if(this.sommets.get(i).getValeur().equals(neuron)) {
                this.sommets.get(i).getValeur().setWeight(newWeight);
            }
        }
    }

    /**
     * Permet de mettre la donnée d'un neurone à jour en passant le neurone que l'on veut modifier ainsi que sa nouvelle donnée en paramètres.
     * @param neuron:int
     * @param newDonnee:float
     */

    public void updateDonneeNeuron(int neuron, float newDonnee) {
        for(int i=0;i<this.neurons.taille();i++) {
            if(this.sommets.get(i).getValeur().equals(neuron)) {
                this.sommets.get(i).getValeur().setDonnee(newDonnee);
            }
        }
    }

    /**
     * Permet de mettre le gradient d'erreur à jour d'un neurone donné en passant le neurone que l'on veut modifier ainsi que son nouveau gradient d'erreur en paramètres.
     * @param neuron:int
     * @param newErrorGradient:float
     */

    public void updateErrorGradientNeuron(int neuron, float newErrorGradient) {
        for(int i=0;i<this.neurons.taille();i++) {
            if(this.sommets.get(i).getValeur().equals(neuron)) {
                this.sommets.get(i).getValeur().setErrorGradient(newErrorGradient);
            }
        }
    }
}