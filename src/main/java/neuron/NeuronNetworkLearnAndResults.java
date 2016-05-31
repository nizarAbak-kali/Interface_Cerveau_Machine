package neuron;

import donnees.LireCVS;

/**
 * Created by Alexou on 28/05/2016.
 */
public class NeuronNetworkLearnAndResults {

    /**
     * Méthode permettant de charcher les caractéristiques temporelles qui serviront pour l'apprentissage et les résultats donnés par le réseau de neurones.
     */

    public static void chargerCaracteristiquesTemporelles() {

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

        String[] premierSignalChat = chatCVS.chargerLingneFichier(0);
        float[] premierSignalChatConverti = chatCVS.convertirLigneFichier(premierSignalChat);
        CaracteristiqueTemporel caracteristiqueTemporelPremierSignalChat = new CaracteristiqueTemporel(premierSignalChatConverti);
        float[] resultsCaracteristiquesTemporellesPremierSignalChat = caracteristiqueTemporelPremierSignalChat.getResults();

        System.out.println("Premier signal représentant l'activité chat : ");

        for(int i=0;i<premierSignalChatConverti.length;i++) {
            System.out.print(premierSignalChatConverti[i] + " ");
        }

        System.out.println("\n");

        System.out.println("Résultats du calcul des caractéristiques temporelles : ");

        for(int i=0;i<resultsCaracteristiquesTemporellesPremierSignalChat.length;i++) {
            System.out.println(resultsCaracteristiquesTemporellesPremierSignalChat[i]);
        }

        String[] secondSignalChat = chatCVS.chargerLingneFichier(1);
        float[] secondSignalChatConverti = chatCVS.convertirLigneFichier(secondSignalChat);
        CaracteristiqueTemporel caracteristiqueTemporelSecondSignalChat = new CaracteristiqueTemporel(secondSignalChatConverti);
        float[] resultsCaracteristiquesTemporellesSecondSignalChat = caracteristiqueTemporelSecondSignalChat.getResults();

        System.out.println("Second signal représentant l'activité chat : ");

        for(int i=0;i<secondSignalChatConverti.length;i++) {
            System.out.print(secondSignalChatConverti[i] + " ");
        }

        System.out.println("\n");

        System.out.println("Résultats du calcul des caractéristiques temporelles : ");

        for(int i=0;i<resultsCaracteristiquesTemporellesSecondSignalChat.length;i++) {
            System.out.println(resultsCaracteristiquesTemporellesSecondSignalChat[i]);
        }

        String[] troisiemeSignalChat = chatCVS.chargerLingneFichier(2);
        float[] troisiemeSignalChatConverti = chatCVS.convertirLigneFichier(troisiemeSignalChat);
        CaracteristiqueTemporel caracteristiqueTemporelTroisiemeSignalChat = new CaracteristiqueTemporel(troisiemeSignalChatConverti);
        float[] resultsCaracteristiquesTemporellesTroisiemeSignalChat = caracteristiqueTemporelTroisiemeSignalChat.getResults();

        System.out.println("Troisième signal représentant l'activité chat : ");

        for(int i=0;i<troisiemeSignalChatConverti.length;i++) {
            System.out.print(troisiemeSignalChatConverti[i] + " ");
        }

        System.out.println("\n");

        System.out.println("Résultats du calcul des caractéristiques temporelles : ");

        for(int i=0;i<resultsCaracteristiquesTemporellesTroisiemeSignalChat.length;i++) {
            System.out.println(resultsCaracteristiquesTemporellesTroisiemeSignalChat[i]);
        }

        String[] premierSignalRead = readCVS.chargerLingneFichier(0);
        float[] premierSignalReadConverti = readCVS.convertirLigneFichier(premierSignalRead);
        CaracteristiqueTemporel caracteristiqueTemporelPremierSignalRead = new CaracteristiqueTemporel(premierSignalReadConverti);
        float[] resultsCaracteristiquesTemporellesPremierSignalRead = caracteristiqueTemporelPremierSignalRead.getResults();

        System.out.println("Premier signal représentant l'activité read : ");

        for(int i=0;i<premierSignalReadConverti.length;i++) {
            System.out.print(premierSignalReadConverti[i] + " ");
        }

        System.out.println("\n");

        System.out.println("Résultats du calcul des caractéristiques temporelles : ");

        for(int i=0;i<resultsCaracteristiquesTemporellesPremierSignalRead.length;i++) {
            System.out.println(resultsCaracteristiquesTemporellesPremierSignalRead[i]);
        }

        String[] secondSignalRead = readCVS.chargerLingneFichier(1);
        float[] secondSignalReadConverti = readCVS.convertirLigneFichier(secondSignalRead);
        CaracteristiqueTemporel caracteristiqueTemporelSecondSignalRead = new CaracteristiqueTemporel(secondSignalReadConverti);
        float[] resultsCaracteristiquesTemporellesSecondSignalRead = caracteristiqueTemporelSecondSignalRead.getResults();

        System.out.println("Second signal représentant l'activité read : ");

        for(int i=0;i<secondSignalReadConverti.length;i++) {
            System.out.print(secondSignalReadConverti[i] + " ");
        }

        System.out.println("\n");

        System.out.println("Résultats du calcul des caractéristiques temporelles : ");

        for(int i=0;i<resultsCaracteristiquesTemporellesSecondSignalRead.length;i++) {
            System.out.println(resultsCaracteristiquesTemporellesSecondSignalRead[i]);
        }

        String[] troisiemeSignalRead = readCVS.chargerLingneFichier(2);
        float[] troisiemeSignalReadConverti = readCVS.convertirLigneFichier(troisiemeSignalRead);
        CaracteristiqueTemporel caracteristiqueTemporelTroisiemeSignalRead = new CaracteristiqueTemporel(troisiemeSignalReadConverti);
        float[] resultsCaracteristiquesTemporellesTroisiemeSignalRead = caracteristiqueTemporelTroisiemeSignalRead.getResults();

        System.out.println("Troisième signal représentant l'activité read : ");

        for(int i=0;i<troisiemeSignalReadConverti.length;i++) {
            System.out.print(troisiemeSignalReadConverti[i] + " ");
        }

        System.out.println("\n");

        System.out.println("Résultats du calcul des caractéristiques temporelles : ");

        for(int i=0;i<resultsCaracteristiquesTemporellesTroisiemeSignalRead.length;i++) {
            System.out.println(resultsCaracteristiquesTemporellesTroisiemeSignalRead[i]);
        }

        String[] premierSignalRest = restCVS.chargerLingneFichier(0);
        float[] premierSignalRestConverti = restCVS.convertirLigneFichier(premierSignalRest);
        CaracteristiqueTemporel caracteristiqueTemporelPremierSignalRest = new CaracteristiqueTemporel(premierSignalRestConverti);
        float[] resultsCaracteristiquesTemporellesPremierSignalRest = caracteristiqueTemporelPremierSignalRest.getResults();

        System.out.println("Premier signal représentant l'activité rest : ");

        for(int i=0;i<premierSignalRestConverti.length;i++) {
            System.out.print(premierSignalRestConverti[i] + " ");
        }

        System.out.println("\n");

        System.out.println("Résultats du calcul des caractéristiques temporelles : ");

        for(int i=0;i<resultsCaracteristiquesTemporellesPremierSignalRest.length;i++) {
            System.out.println(resultsCaracteristiquesTemporellesPremierSignalRest[i]);
        }

        String[] secondSignalRest = restCVS.chargerLingneFichier(1);
        float[] secondSignalRestConverti = restCVS.convertirLigneFichier(secondSignalRest);
        CaracteristiqueTemporel caracteristiqueTemporelSecondSignalRest = new CaracteristiqueTemporel(secondSignalRestConverti);
        float[] resultsCaracteristiquesTemporellesSecondSignalRest = caracteristiqueTemporelSecondSignalRest.getResults();

        System.out.println("Second signal représentant l'activité rest : ");

        for(int i=0;i<secondSignalRestConverti.length;i++) {
            System.out.print(secondSignalRestConverti[i] + " ");
        }

        System.out.println("\n");

        System.out.println("Résultats du calcul des caractéristiques temporelles : ");

        for(int i=0;i<resultsCaracteristiquesTemporellesSecondSignalRest.length;i++) {
            System.out.println(resultsCaracteristiquesTemporellesSecondSignalRest[i]);
        }

        String[] troisiemeSignalRest = restCVS.chargerLingneFichier(2);
        float[] troisiemeSignalRestConverti = restCVS.convertirLigneFichier(troisiemeSignalRest);
        CaracteristiqueTemporel caracteristiqueTemporelTroisiemeSignalRest = new CaracteristiqueTemporel(troisiemeSignalRestConverti);
        float[] resultsCaracteeristiquesTemporellesTroisiemeSignalRest = caracteristiqueTemporelTroisiemeSignalRest.getResults();

        System.out.println("Troisième signal représsentant l'activité rest : ");

        for(int i=0;i<troisiemeSignalRestConverti.length;i++) {
            System.out.print(troisiemeSignalRestConverti[i] + " ");
        }

        System.out.println("\n");

        System.out.println("Résultats du calcul des caractéristiques temporelles : ");

        String[] premierSignalVideo = videoCVS.chargerLingneFichier(0);
        float[] premierSignalVideoConverti = videoCVS.convertirLigneFichier(premierSignalVideo);
        CaracteristiqueTemporel caracteristiqueTemporelPremierSignalVideo = new CaracteristiqueTemporel(premierSignalVideoConverti);
        float[] resultsCaracteristiquesTemporellesPremierSignalVideo = caracteristiqueTemporelPremierSignalVideo.getResults();

        System.out.println("Premier signal représentant l'activité video : ");

        for(int i=0;i<premierSignalVideoConverti.length;i++) {
            System.out.print(premierSignalVideoConverti[i] + " ");
        }

        System.out.println("\n");

        System.out.println("Résultats du calcul des caractéristiques temporelles : ");

        for(int i=0;i<resultsCaracteristiquesTemporellesPremierSignalVideo.length;i++) {
            System.out.println(resultsCaracteristiquesTemporellesPremierSignalVideo[i]);
        }

        String[] secondSignalVideo = videoCVS.chargerLingneFichier(1);
        float[] secondSignalVideoConverti = videoCVS.convertirLigneFichier(secondSignalVideo);
        CaracteristiqueTemporel caracteristiqueTemporelSecondSignalVideo = new CaracteristiqueTemporel(secondSignalVideoConverti);
        float[] resultsCaracteristiquesTemporellesSecondSignalVideo = caracteristiqueTemporelSecondSignalVideo.getResults();

        System.out.println("Second signal représentant l'activité video : ");

        for(int i=0;i<secondSignalVideoConverti.length;i++) {
            System.out.print(secondSignalVideoConverti[i] + " ");
        }

        System.out.println("\n");

        System.out.println("Résultats du calcul des caractéristiques temporelles : ");

        for(int i=0;i<resultsCaracteristiquesTemporellesSecondSignalVideo.length;i++) {
            System.out.println(resultsCaracteristiquesTemporellesSecondSignalVideo[i]);
        }

        String[] troisiemeSignalVideo = videoCVS.chargerLingneFichier(2);
        float[] troisiemeSignalVideoConverti = videoCVS.convertirLigneFichier(troisiemeSignalVideo);
        CaracteristiqueTemporel caracteristiqueTemporelTroisiemeSignalVideo = new CaracteristiqueTemporel(troisiemeSignalVideoConverti);
        float[] resultsCaracteristiquesTemporellesTroisiemeSignalVideo = caracteristiqueTemporelTroisiemeSignalVideo.getResults();

        System.out.println("Troisième signal représentant l'activité video : ");

        for(int i=0;i<troisiemeSignalVideoConverti.length;i++) {
            System.out.print(troisiemeSignalVideoConverti[i] + " ");
        }

        System.out.println("\n");

        System.out.println("Résultats du calcul des caractéristiques temporelles : ");

        for(int i=0;i<resultsCaracteristiquesTemporellesTroisiemeSignalVideo.length;i++) {
            System.out.println(resultsCaracteristiquesTemporellesTroisiemeSignalVideo[i]);
        }

        String[] premierSignalWork = workCVS.chargerLingneFichier(0);
        float[] premierSignalWorkConverti = workCVS.convertirLigneFichier(premierSignalWork);
        CaracteristiqueTemporel caracteristiqueTemporelPremierSignalWork = new CaracteristiqueTemporel(premierSignalWorkConverti);
        float[] resultsCaracteristiquesTemporellesPremierSignalWork = caracteristiqueTemporelPremierSignalWork.getResults();

        System.out.println("Premier signal représentant l'activité work : ");

        for(int i=0;i<premierSignalWorkConverti.length;i++) {
            System.out.print(premierSignalWorkConverti[i] + " ");
        }

        System.out.println("\n");

        System.out.println("Résultats du calcul des caractéristiques temporelles : ");

        for(int i=0;i<resultsCaracteristiquesTemporellesPremierSignalWork.length;i++) {
            System.out.println(resultsCaracteristiquesTemporellesPremierSignalWork[i]);
        }

        String[] secondSignalWork = workCVS.chargerLingneFichier(1);
        float[] secondSignalWorkConverti = workCVS.convertirLigneFichier(secondSignalWork);
        CaracteristiqueTemporel caracteristiqueTemporelSecondSignalWork = new CaracteristiqueTemporel(secondSignalWorkConverti);
        float[] resultsCaracteristiquesTemporellesSecondSignalWork = caracteristiqueTemporelSecondSignalWork.getResults();

        System.out.println("Second signal représentant l'activité work : ");

        for(int i=0;i<secondSignalWorkConverti.length;i++) {
            System.out.print(secondSignalWorkConverti[i] + " ");
        }

        System.out.println("\n");

        System.out.println("Résultats du calcul des caractéristiques temporelles : ");

        for(int i=0;i<resultsCaracteristiquesTemporellesSecondSignalWork.length;i++) {
            System.out.println(resultsCaracteristiquesTemporellesSecondSignalWork[i]);
        }

        String[] troisiemeSignalWork = workCVS.chargerLingneFichier(2);
        float[] troisiemeSignalWorkConverti = workCVS.convertirLigneFichier(troisiemeSignalWork);
        CaracteristiqueTemporel caracteristiqueTemporelTroisiemeSignalWork = new CaracteristiqueTemporel(troisiemeSignalWorkConverti);
        float[] resultsCaracteristiquesTemporellesTroisiemeSignalWork = caracteristiqueTemporelTroisiemeSignalWork.getResults();

        System.out.println("Troisième signal représentant l'activité work : ");

        for(int i=0;i<troisiemeSignalWorkConverti.length;i++) {
            System.out.print(troisiemeSignalWorkConverti[i] + " ");
        }

        System.out.println("\n");

        System.out.println("Résultats du calcul des caractéristiques temporelles : ");

        for(int i=0;i<resultsCaracteristiquesTemporellesTroisiemeSignalWork.length;i++) {
            System.out.println(resultsCaracteristiquesTemporellesTroisiemeSignalWork[i]);
        }

    }

    /**
     * Méthode qui s'occupe de faire apprendre les données au réseau de neurones.
     */

    public static void apprentissageReseauDeNeurones() {

    }

    /**
     * Teste de données sur le réseau de neurones pour voir s'il a bien appris.
     */

    public static void resultatsReseauxDeNeurones() {

    }

    /**
     * Méthode permettant de tester notre réseau de neurones sur les fichiers de données fournis.
     * @param args
     */

    public static void main(String[] args) {

        chargerCaracteristiquesTemporelles();
        apprentissageReseauDeNeurones();
        resultatsReseauxDeNeurones();
    }
}