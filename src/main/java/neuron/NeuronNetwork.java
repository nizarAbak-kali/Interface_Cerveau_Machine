package neuron;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Alexou on 10/03/2016.
 * Classe modélisant le réseau de neurones.
 */
public class NeuronNetwork {

    private ArrayList<Neuron> neurons;
    private CaracteristiqueTemporel caracteristiquesTemporelles;

    /**
     * Constructeur du réseau de neurones.
     */

    public NeuronNetwork() {
        this.neurons=new ArrayList<Neuron>();
        this.neurons=remplirArrayList();
        init();
        //caracteristiquesTemporelles=new CaracteristiqueTemporel();
    }

    /**
     * Initialisation du poids de tous les neurones.
     */

    private void init() {

        float minimalWeight = (float) (-2.4/this.neurons.size());
        float maximalWeight = (float) (2.4/this.neurons.size());
        Random r = new Random();

        for(int i=0;i<this.neurons.size();i++) {
            this.neurons.get(i).setWeight(minimalWeight + (r.nextFloat() + minimalWeight) - maximalWeight);
        }

    }

    /**
     * Initialise la liste des neurones.
     * @return La liste des neurones nouvellement créée.
     */

    private ArrayList<Neuron> remplirArrayList() {
        Random r = new Random();
        int nbMinimalNeurons=10;
        int nbMaximalNeurons=100;
        int nbNeurons=nbMinimalNeurons + r.nextInt(nbMaximalNeurons - nbMinimalNeurons);

        for(int i=0;i<=nbNeurons;i++) {
            ajouterNeuron(new Neuron());
        }

        return this.neurons;
    }

    /**
     *
     * @return La liste des neurones.
     */

    public ArrayList<Neuron> getNeurons() {
        return this.neurons;
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
     * @param caracteristiquesTemporelle
     */

    public void setCaracteristiquesTemporelless(CaracteristiqueTemporel caracteristiquesTemporelle) {
        this.caracteristiquesTemporelles=caracteristiquesTemporelle;
    }

    /**
     * Permet d'ajouter un nouveau neurone à la liste des neurones.
     * @param neuron
     */

    public void ajouterNeuron(Neuron neuron) {
        this.neurons.add(neuron);
    }

    /**
     * Permet de supprimer de la liste de neurones le neurone passé en paramètre.
     * @param neuron
     */

    public void supprimerNeuron(Neuron neuron) {
        for(int i=0;i<this.neurons.size();i++) {
            if(this.neurons.get(i).equals(neuron)) {
                this.neurons.remove(neuron);
            }
        }
    }

    /**
     * Permet de mettre à jour les valeurs des neurones avec la valeur passée en paramètre (la même pour tous).
     * @param newValue
     */

    public void updateValues(float newValue) {
        for (int i = 0; i < this.neurons.size(); i++) {
            this.neurons.get(i).setValue(newValue);
        }
    }

    /**
     * Permet de mettre à jour la valeur de tous les neurones en passant la liste des nouvelles valeurs à attribuer aux neurones en paramètre.
     * @param newValues
     * @throws LongueurDifferenceException
     */

    public void updateValues(ArrayList<Float> newValues) throws LongueurDifferenceException {
        if(this.neurons.size()==newValues.size()) {
            for (int i = 0; i < this.neurons.size(); i++) {
                for (int j = 0; j < newValues.size(); j++) {
                    this.neurons.get(i).setValue(newValues.get(j));
                }
            }
        }
        else {
            throw new LongueurDifferenceException();
        }
    }

    /**
     * Permet de mettre à jour le poids de chaque neurone avec la valeur passée en paramètre (la même pour tous).
     * @param newWeight
     */

    public void updateWeights(float newWeight) {
        for(int i=0;i<this.neurons.size();i++) {
            this.neurons.get(i).setWeight(newWeight);
        }
    }

    /**
     * Permet de mettre à jour le poids de tous les neurones grâce à la liste des nouveaux poids passée en paramètre.
     * @param newWeights
     * @throws LongueurDifferenceException
     */

    public void updateWeights(ArrayList<Float> newWeights) throws LongueurDifferenceException {
        if(this.neurons.size()==newWeights.size()) {
            for(int i=0;i<this.neurons.size();i++) {
                for(int j=0;j<newWeights.size();j++) {
                    this.neurons.get(i).setWeight(newWeights.get(j));
                }
            }
        }
        else {
            throw new LongueurDifferenceException();
        }
    }

    /**
     * Permet de mettre à jour les données de tous les neurones avec la valeur passée en paramètre (la même pour tous).
     * @param newDonnee
     */

    public void updateDonnees(float newDonnee) {
        for(int i=0;i<this.neurons.size();i++) {
            this.neurons.get(i).setDonnee(newDonnee);
        }
    }

    /**
     * Permet de mettre à jour les données de tous les neurones en passant en paramètre la liste des nouvelles données.
     * @param newDonnees
     * @throws LongueurDifferenceException
     */

    public void updateDonnees(ArrayList<Float> newDonnees) throws LongueurDifferenceException {
        if(this.neurons.size()==newDonnees.size()) {
            for(int i=0;i<this.neurons.size();i++) {
                for(int j=0;j<newDonnees.size();j++) {
                    this.neurons.get(i).setDonnee(newDonnees.get(j));
                }
            }
        }
        else {
            throw new LongueurDifferenceException();
        }
    }

    /**
     * Permet de mettre à jour les gradients d'erreur de tous les neurones avec le nouveau gradient d'erreur passé en paramètre (le même pour tous).
     * @param newErrorGradient
     */

    public void updateErrorGradients(float newErrorGradient) {
        for(int i=0;i<this.neurons.size();i++) {
            this.neurons.get(i).setErrorGradient(newErrorGradient);
        }
    }

    /**
     * Permet de mettre à jour tous les gradients d'erreurs de tous les neurones grâce à la liste des nouveaux gradients d'erreurs passée en paramètre.
     * @param newErrorGradients
     * @throws LongueurDifferenceException
     */

    public void updateErrorGradients(ArrayList<Float> newErrorGradients) throws LongueurDifferenceException {
        if(this.neurons.size()==newErrorGradients.size()) {
            for(int i=0;i<this.neurons.size();i++) {
                for(int j=0;j<newErrorGradients.size();j++) {
                    this.neurons.get(i).setErrorGradient(newErrorGradients.get(j));
                }
            }
        }
        else {
            throw new LongueurDifferenceException();
        }
    }

    /**
     * Permet de mettre la valeur d'un neurone à jour en passant le neurone que l'on veut modifier ainsi que sa nouvelle valeur en paramètres.
     * @param neuron
     * @param newValue
     */

    public void updateValueNeuron(int neuron, float newValue) {
        for(int i=0;i<this.neurons.size();i++) {
            if(this.neurons.get(i).equals(neuron)) {
                this.neurons.get(i).setValue(newValue);
            }
        }
    }

    /**
     * Permet de mettre le poids d'un neurone à jour en passant le neurone que l'on veut modifier ainsi que le nouveau poids en paramètres.
     * @param neuron
     * @param newWeight
     */

    public void updateWeightNeuron(int neuron, float newWeight) {
        for(int i=0;i<this.neurons.size();i++) {
            if(this.neurons.get(i).equals(neuron)) {
                this.neurons.get(i).setWeight(newWeight);
            }
        }
    }

    /**
     * Permet de mettre la donnée d'un neurone à jour en passant le neurone que l'on veut modifier ainsi que sa nouvelle donnée en paramètres.
     * @param neuron
     * @param newDonnee
     */

    public void updateDonneeNeuron(int neuron, float newDonnee) {
        for(int i=0;i<this.neurons.size();i++) {
            if(this.neurons.get(i).equals(neuron)) {
                this.neurons.get(i).setDonnee(newDonnee);
            }
        }
    }

    /**
     * Permet de mettre le gradient d'erreur à jour d'un neurone donné en passant le neurone que l'on veut modifier ainsi que son nouveau gradient d'erreur en paramètres.
     * @param neuron
     * @param newErrorGradient
     */

    public void updateErrorGradientNeuron(int neuron, float newErrorGradient) {
        for(int i=0;i<this.neurons.size();i++) {
            if(this.neurons.get(i).equals(neuron)) {
                this.neurons.get(i).setErrorGradient(newErrorGradient);
            }
        }
    }
}