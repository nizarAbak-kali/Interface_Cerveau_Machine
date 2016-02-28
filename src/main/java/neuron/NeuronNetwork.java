package neuron;

import java.util.Random;

/**
 * Created by Alexou on 12/02/2016.
 */
public class NeuronNetwork {

    private int [][] neurons;
    private int nbNeurons;
    private int nbMinimalNeurons;
    private int nbMaximalNeurons;

    public NeuronNetwork() {
        Random r = new Random();
        this.nbMinimalNeurons=10;
        this.nbMaximalNeurons=100;
        this.nbNeurons = nbMinimalNeurons + r.nextInt(nbMaximalNeurons - nbMinimalNeurons);
        this.neurons = new int[nbNeurons][4];
        init();
    }

    private void init() {
        int minimalWeight = (int) (-2.4/this.nbNeurons);
        int maximalWeight = (int) (2.4/this.nbNeurons);
        Random r = new Random();
        for(int i=0;i<neurons.length;i++) {
            neurons[i][0]=0; //initialisation de la valeur des neurones à 0
            neurons[i][1] = minimalWeight + r.nextInt(maximalWeight - minimalWeight); //initialisation du poids des neurones
            neurons[i][2]=0; //initialisation des données pour chaque neurone
            neurons[i][3]=0; //initialisation des gradients d'erreur
        }
    }

    public void updateValues(int [] newValues) {
        for(int i=0;i<neurons.length;i++) {
            for(int j=0;j<newValues.length;j++) {
                neurons[i][0]=newValues[j];
            }
        }
    }

    public void updateWeights(int [] changes) {
        for(int i=0;i<neurons.length;i++) {
            for(int j=0;j<changes.length;j++) {
                neurons[i][1]=changes[j];
            }
        }
    }

    public void updateDatas(int [] datas) {
        for(int i=0;i<neurons.length;i++) {
            for(int j=0;j<datas.length;j++) {
                neurons[i][2]=datas[j];
            }
        }
    }

    public void updateErrorsGradients(int [] newErrorsGradients) {
        for(int i=0;i<neurons.length;i++) {
            for(int j=0;j<newErrorsGradients.length;j++) {
                neurons[i][3]=newErrorsGradients[j];
            }
        }
    }

    public void updateErrorGradientNeuron(int newErrorGradient, int neuron) {
        for(int i=0;i<neurons.length;i++) {
            if(neuron==i) {

            }
        }
    }

    public void updateWeightNeuron(int newWeight, int neuron) {
        for(int i=0;i<neurons.length;i++) {
            if(neuron==i) {
                neurons[i][1]=newWeight;
            }
        }
    }

    public void changeValueNeuron(int value, int neuron) {
        for(int i=0;i<neurons.length;i++) {
            if(neuron==i) {
                neurons[i][0]=value;
            }
        }
    }
}
