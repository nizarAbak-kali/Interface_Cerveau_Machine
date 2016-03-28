package neuron;

/**
 * Created by Alexou on 10/03/2016.
 * Classe définissant les caractéristiques d'un neurone pour permettre la création du réseau dans la classe NeuronNetwork
 */
public class Neuron {

    private float value;
    private float weight;
    private float donnee;
    private float errorGradient;

    /**
     * Construction d'un neurone dont les attributs sont tous initialisés à 0.
     */

    public Neuron() {

        //Initialisation des trois données du neurone à 0. Le poids de chaque neurone sera initialisé dans la classe du réseau.
        this.value=0;
        this.weight=0;
        this.donnee=0;
        this.errorGradient=0;
    }

    /**
     * Construction d'un neurone dont tous les attributs sont des valeurs passées en paramètres.
     * @param value
     * @param weight
     * @param donnee
     * @param errorGradient
     */

    public Neuron(float value, float weight, float donnee, float errorGradient) {
        this.value = value;
        this.weight = weight;
        this.errorGradient = errorGradient;
        this.donnee = donnee;
    }

    /**
     *
     * @return La valeur du neurone.
     */

    public float getValue() {
        return value;
    }

    /**
     * Permet de modifier la valeur du neurone.
     * @param value: float
     */

    public void setValue(float value) {
        this.value = value;
    }

    /**
     *
     * @return Le poids du neurone.
     */

    public float getWeight() {
        return weight;
    }

    /**
     * Permet de modifier le poids du neurone.
     * @param weight: float
     */

    public void setWeight(float weight) {
        this.weight = weight;
    }

    /**
     *
     * @return La donnée que comporte le neurone.
     */

    public float getDonnee() {
        return donnee;
    }

    /**
     * Permet de modifier la donnée du neurone.
     * @param donnee: float
     */

    public void setDonnee(float donnee) {
        this.donnee = donnee;
    }

    /**
     *
     * @return Le gradient d'erreur du neurone.
     */

    public float getErrorGradient() {
        return errorGradient;
    }

    /**
     * Permet de modifier le gradient d'erreur du neurone.
     * @param errorGradient: float
     */

    public void setErrorGradient(float errorGradient) {
        this.errorGradient = errorGradient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Neuron neuron = (Neuron) o;

        if (Float.compare(neuron.value, value) != 0) return false;
        if (Float.compare(neuron.weight, weight) != 0) return false;
        if (Float.compare(neuron.donnee, donnee) != 0) return false;
        return Float.compare(neuron.errorGradient, errorGradient) == 0;

    }

    @Override
    public int hashCode() {
        int result = (value != +0.0f ? Float.floatToIntBits(value) : 0);
        result = 31 * result + (weight != +0.0f ? Float.floatToIntBits(weight) : 0);
        result = 31 * result + (donnee != +0.0f ? Float.floatToIntBits(donnee) : 0);
        result = 31 * result + (errorGradient != +0.0f ? Float.floatToIntBits(errorGradient) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Neuron{" +
                "value=" + value +
                ", weight=" + weight +
                ", donnee=" + donnee +
                ", errorGradient=" + errorGradient +
                '}';
    }
}