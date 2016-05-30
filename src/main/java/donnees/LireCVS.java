package donnees;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by nizar on 04/03/2016.
 *
 * @author(Nizar ABAK-KALI)
 */
public class LireCVS {
    private String file_p;

    /**
     * Constructeur d'une instance de LireCVS.
     * @param file_path
     */

    public LireCVS(String file_path) {
        this.file_p = file_path;
    }

    /**
     * Méthode permettant de charger en mémoire le fichier passé en paramètre.
     * @return Un tableau de tableau de String représentant les trois signaux du fichier
     */

    public String[][] chargerFichier() {

        String[][] listeDonnees = new String[3][1000];
        File fichier = new File(file_p);
        String[] tabIntermediaire = new String[1000];

        try {
            InputStream flux = new FileInputStream(fichier);
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader buff = new BufferedReader(lecture);
            String ligne;
            int i=0;

            while((ligne=buff.readLine())!=null && i!=listeDonnees.length) {
                tabIntermediaire=ligne.split(",");
                listeDonnees[i]=tabIntermediaire;
                i++;
            }
            buff.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return listeDonnees;

    }

    /**
     * Méthode permettant de convertir les données de type String en float (ou nombres flottants)
     * @param donnees
     * @return Le tableau de données converties.
     */

    public Float[][] convertirDonnees(String[][] donnees) {

        Float[][] donneesConverties = new Float[3][1000];

        for(int i=0;i<donnees.length;i++) {
            for(int j=0;j<donnees[i].length;j++) {
                donneesConverties[i][j]=Float.valueOf(donnees[i][j]);
            }
        }

        return donneesConverties;

    }

    /**
     * Permet de charger en mémoire la première ligne du fichier passé en paramètre (le premier signal parmi les trois).
     * @return un tableau de String représentant l'ensemble du signal chargé en mémoire.
     */

    public String[] chargerPremiereLigneFichier() {
        FileReader monFichier = null;
        BufferedReader tampon = null;
        String[] tabIntermediaire = new String[1000];

        try {
            monFichier = new FileReader(file_p);
            tampon = new BufferedReader(monFichier);
            String ligne = tampon.readLine();
            tabIntermediaire=ligne.split(",");
            for(int i=0;i<tabIntermediaire.length;i++) {
                System.out.println(tabIntermediaire[i]);
            }
        } catch(IOException exception) {
            exception.printStackTrace();
        } finally {
            try {
                tampon.close();
                monFichier.close();
            } catch(IOException exception1) {
                exception1.printStackTrace();
            }
        }
        return tabIntermediaire;
    }

    /**
     * Convertie le teste de la première ligne du fichier passé en paramètre en ligne de nombre flottants.
     * @param donnees
     * @return Un tableau de nombres flottants représentant le premier signal du fichier converti.
     */

    public Float[] convertirPremiereLigneFichier(String[] donnees) {
        Float[] premiereLigneConvertie = new Float[donnees.length];
        for(int i=0;i<donnees.length;i++) {
            premiereLigneConvertie[i]=Float.valueOf(donnees[i]);
        }
        return premiereLigneConvertie;
    }
}