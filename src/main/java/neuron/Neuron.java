package neuron;

/**
 * Created by Alexou on 10/03/2016.
 */
public class Neuron {

    private float value;
    private float weight;
    private float donnee;
    private float errorGradient;

    public Neuron() {

        //Initialisation des trois données du neurone à 0. Le poids de chaque neurone sera initialisé dans la classe du réseau.
        this.value=0;
        this.weight=0;
        this.donnee=0;
        this.errorGradient=0;
    }

    public Neuron(float value, float weight, float donnee, float errorGradient) {
        this.value = value;
        this.weight = weight;
        this.errorGradient = errorGradient;
        this.donnee = donnee;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getDonnee() {
        return donnee;
    }

    public void setDonnee(float donnee) {
        this.donnee = donnee;
    }

    public float getErrorGradient() {
        return errorGradient;
    }

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