package neuron;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Alexou on 10/03/2016.
 */
public class NeuronNetwork {

    private ArrayList<Neuron> neurons;
    private CaracteristiqueTemporel caracteristiquesTemporelles;

    public NeuronNetwork() {
        this.neurons=new ArrayList<Neuron>();
        this.neurons=remplirArrayList();
        init();
        caracteristiquesTemporelles=new CaracteristiqueTemporel();
    }

    private void init() {

        float minimalWeight = (float) (-2.4/this.neurons.size());
        float maximalWeight = (float) (2.4/this.neurons.size());
        Random r = new Random();

        for(int i=0;i<this.neurons.size();i++) {
            this.neurons.get(i).setWeight(minimalWeight + (r.nextFloat() + minimalWeight) - maximalWeight);
        }

    }

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

    public ArrayList<Neuron> getNeurons() {
        return this.neurons;
    }

    public CaracteristiqueTemporel getCaracteristiquesTemporelles() {
        return this.caracteristiquesTemporelles;
    }

    public void setCaracteristiquesTemporelless(CaracteristiqueTemporel caracteristiquesTemporelle) {
        this.caracteristiquesTemporelles=caracteristiquesTemporelle;
    }

    public void ajouterNeuron(Neuron neuron) {
        this.neurons.add(neuron);
    }

    public void supprimerNeuron(Neuron neuron) {
        for(int i=0;i<this.neurons.size();i++) {
            if(this.neurons.get(i).equals(neuron)) {
                this.neurons.remove(neuron);
            }
        }
    }

    public void updateValues(float newValue) {
        for (int i = 0; i < this.neurons.size(); i++) {
            this.neurons.get(i).setValue(newValue);
        }
    }

    public void updateValues(ArrayList<Float> newValues) throws LongueurDifferenteException {
        if(this.neurons.size()==newValues.size()) {
            for (int i = 0; i < this.neurons.size(); i++) {
                for (int j = 0; j < newValues.size(); j++) {
                    this.neurons.get(i).setValue(newValues.get(j));
                }
            }
        }
        else {
            throw new LongueurDifferenteException();
        }
    }

    public void updateWeights(float newWeight) {
        for(int i=0;i<this.neurons.size();i++) {
            this.neurons.get(i).setWeight(newWeight);
        }
    }

    public void updateWeights(ArrayList<Float> newWeights) throws LongueurDifferenteException {
        if(this.neurons.size()==newWeights.size()) {
            for(int i=0;i<this.neurons.size();i++) {
                for(int j=0;j<newWeights.size();j++) {
                    this.neurons.get(i).setWeight(newWeights.get(j));
                }
            }
        }
        else {
            throw new LongueurDifferenteException();
        }
    }

    public void updateDonnees(float newDonnee) {
        for(int i=0;i<this.neurons.size();i++) {
            this.neurons.get(i).setDonnee(newDonnee);
        }
    }

    public void updateDonnees(ArrayList<Float> newDonnees) throws LongueurDifferenteException {
        if(this.neurons.size()==newDonnees.size()) {
            for(int i=0;i<this.neurons.size();i++) {
                for(int j=0;j<newDonnees.size();j++) {
                    this.neurons.get(i).setDonnee(newDonnees.get(j));
                }
            }
        }
        else {
            throw new LongueurDifferenteException();
        }
    }

    public void updateErrorGradients(float newErrorGradient) {
        for(int i=0;i<this.neurons.size();i++) {
            this.neurons.get(i).setErrorGradient(newErrorGradient);
        }
    }

    public void updateErrorGradients(ArrayList<Float> newErrorGradients) throws LongueurDifferenteException {
        if(this.neurons.size()==newErrorGradients.size()) {
            for(int i=0;i<this.neurons.size();i++) {
                for(int j=0;j<newErrorGradients.size();j++) {
                    this.neurons.get(i).setErrorGradient(newErrorGradients.get(j));
                }
            }
        }
        else {
            throw new LongueurDifferenteException();
        }
    }

    public void updateValueNeuron(int neuron, float newValue) {
        for(int i=0;i<this.neurons.size();i++) {
            if(this.neurons.get(i).equals(neuron)) {
                this.neurons.get(i).setValue(newValue);
            }
        }
    }

    public void updateWeightNeuron(int neuron, float newWeight) {
        for(int i=0;i<this.neurons.size();i++) {
            if(this.neurons.get(i).equals(neuron)) {
                this.neurons.get(i).setWeight(newWeight);
            }
        }
    }

    public void updateDonneeNeuron(int neuron, float newDonnee) {
        for(int i=0;i<this.neurons.size();i++) {
            if(this.neurons.get(i).equals(neuron)) {
                this.neurons.get(i).setDonnee(newDonnee);
            }
        }
    }

    public void updateErrorGradientNeuron(int neuron, float newErrorGradient) {
        for(int i=0;i<this.neurons.size();i++) {
            if(this.neurons.get(i).equals(neuron)) {
                this.neurons.get(i).setErrorGradient(newErrorGradient);
            }
        }
    }
}