package neuron;

/**
 * Created by Alexou on 10/03/2016.
 * Classe permettant de gérer les exceptions en cas de longueurs de tableaux différentes dans les méthodes appelées dans la classe NeuronNetwork.
 */
public class LongueurDifferenceException extends Exception {
    public LongueurDifferenceException() {
        System.out.println("La longueur de la liste de neurones est différente de la liste de données passée en paramètre.");
    }
}
