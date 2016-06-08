package neuron;

import donnees.LireCVS;
import graphe.Sommet;

import java.util.Vector;

/**
 * Created by Alexou on 28/05/2016.
 */
public class NeuronNetworkLearnAndResults {

    /**
     * Méthode permettant de charcher les caractéristiques temporelles qui serviront pour l'apprentissage et les résultats donnés par le réseau de neurones.
     */

    public static void apprentissageEtResultatsReseauDeNeurones() {

        String fichierChat = "C:\\Users\\Alexou\\IdeaProjects\\Interface_Cerveau_Machine_5\\data\\Activity-Chat.csv";
        String fichierRead = "C:\\Users\\Alexou\\IdeaProjects\\Interface_Cerveau_Machine_5\\data\\Activity-Read.csv";
        String fichierRest = "C:\\Users\\Alexou\\IdeaProjects\\Interface_Cerveau_Machine_5\\data\\Activity-Rest.csv";
        String fichierVideo = "C:\\Users\\Alexou\\IdeaProjects\\Interface_Cerveau_Machine_5\\data\\Activity-Video.csv";
        String fichierWork = "C:\\Users\\Alexou\\IdeaProjects\\Interface_Cerveau_Machine_5\\data\\Activity-Work.csv";

        LireCVS chatCVS = new LireCVS(fichierChat);
        LireCVS readCVS = new LireCVS(fichierRead);
        LireCVS restCVS = new LireCVS(fichierRest);
        LireCVS videoCVS = new LireCVS(fichierVideo);
        LireCVS workCVS = new LireCVS(fichierWork);

        NeuronNetwork neuronNetwork = new NeuronNetwork(100);
        Vector<Sommet<Neuron>> neurons = neuronNetwork.getNeurons();

        String[][] donneesFichierChat = chatCVS.chargerFichier();
        float[][] donneesFichierChatConverties = chatCVS.conversionTableau(donneesFichierChat);
        CaracteristiqueTemporel caracteristiqueTemporelllesFichierChat = new CaracteristiqueTemporel(donneesFichierChatConverties);
        float[][] resultsCaracteristiquesTemporellesFichierChat = caracteristiqueTemporelllesFichierChat.getResults();

        for(int i=0;i<donneesFichierChatConverties.length;i++) {
            System.out.println("Signal N° " + i + " du fichier chat : ");
            System.out.println("\n");
            for(int j=0;j<resultsCaracteristiquesTemporellesFichierChat.length;j++) {
                for(int k=0;k<resultsCaracteristiquesTemporellesFichierChat[j].length;k++) {
                    System.out.println(resultsCaracteristiquesTemporellesFichierChat[j][k]);
                    System.out.println("\n");
                }
            }
        }

        String[][] donneesFichierRead = readCVS.chargerFichier();
        float[][] donneesFichierReadConverties = readCVS.conversionTableau(donneesFichierRead);
        CaracteristiqueTemporel caracteristiqueTemporellesFichierRead = new CaracteristiqueTemporel(donneesFichierReadConverties);
        float[][] resultsCaracteristiquesTemporellesFichierRead = caracteristiqueTemporellesFichierRead.getResults();

        for(int i=0;i<donneesFichierReadConverties.length;i++) {
            System.out.println("Signal N° " + i + " du fichier read : ");
            System.out.println("\n");
            for(int j=0;j<resultsCaracteristiquesTemporellesFichierRead.length;j++) {
                for(int k=0;k<resultsCaracteristiquesTemporellesFichierRead[j].length;k++) {
                    System.out.println(resultsCaracteristiquesTemporellesFichierRead[j][k]);
                    System.out.println("\n");
                }
            }
        }

        String[][] donneesFichierRest = restCVS.chargerFichier();
        float[][] donneesFichierRestConverties = restCVS.conversionTableau(donneesFichierRest);
        CaracteristiqueTemporel caracteristiqueTemporellesFichierRest = new CaracteristiqueTemporel(donneesFichierRestConverties);
        float[][] resultsCaracteristiquesTemporellesFichierRest = caracteristiqueTemporellesFichierRest.getResults();

        for(int i=0;i<donneesFichierRestConverties.length;i++) {
            System.out.println("Signal N° " + i + " du fichier rest : ");
            System.out.println("\n");
            for(int j=0;j<resultsCaracteristiquesTemporellesFichierRest.length;j++) {
                for(int k=0;k<resultsCaracteristiquesTemporellesFichierRest[j].length;k++) {
                    System.out.println(resultsCaracteristiquesTemporellesFichierRest[j][k]);
                    System.out.println("\n");
                }
            }
        }

        String[][] donneesFichierVideo = videoCVS.chargerFichier();
        float[][] donneesFichierVideoConverties = videoCVS.conversionTableau(donneesFichierVideo);
        CaracteristiqueTemporel caracteristiqueTemporellesFichierVideo = new CaracteristiqueTemporel(donneesFichierVideoConverties);
        float[][] resultsCaracteristiquesTemporellesFichierVideo = caracteristiqueTemporellesFichierVideo.getResults();

        for(int i=0;i<donneesFichierVideoConverties.length;i++) {
            System.out.println("Signal N° " + i + " du fichier video : ");
            System.out.println("\n");
            for(int j=0;j<resultsCaracteristiquesTemporellesFichierVideo.length;j++) {
                for(int k=0;k<resultsCaracteristiquesTemporellesFichierVideo[j].length;k++) {
                    System.out.println(resultsCaracteristiquesTemporellesFichierVideo[j][k]);
                    System.out.println("\n");
                }
            }
        }

        String[][] donneesFichierWork = workCVS.chargerFichier();
        float[][] donneesFichierWorkConverties = workCVS.conversionTableau(donneesFichierWork);
        CaracteristiqueTemporel caracteristiqueTemporellesFichierWork = new CaracteristiqueTemporel(donneesFichierWorkConverties);
        float[][] resultsCaracteristiquesTemporellesFichierWork = caracteristiqueTemporellesFichierWork.getResults();

        for(int i=0;i<donneesFichierChatConverties.length;i++) {
            System.out.println("Signal N° " + i + " du fichier work : ");
            System.out.println("\n");
            for(int j=0;j<resultsCaracteristiquesTemporellesFichierWork.length;j++) {
                for(int k=0;k<resultsCaracteristiquesTemporellesFichierWork[j].length;k++) {
                    System.out.println(resultsCaracteristiquesTemporellesFichierWork[j][k]);
                    System.out.println("\n");
                }
            }
        }
    }
    /**
     * Méthode permettant de tester notre réseau de neurones sur les fichiers de données fournis.
     * @param args
     */

    public static void main(String[] args) {

        apprentissageEtResultatsReseauDeNeurones();
    }
}