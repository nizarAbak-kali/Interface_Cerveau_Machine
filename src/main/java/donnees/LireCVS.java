package donnees;

import java.io.*;

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
     * Charge en mémoire le fichier passé en paramètre.
     * @return Le fichier chargé en mémoire.
     */

    public String[][] chargerFichier() {

        String [][] donnees = new String[3][2560];

        try {
            FileReader monFichier = new FileReader(file_p);
            BufferedReader tampon = new BufferedReader(monFichier);
            String[] tabIntermediaire = new String[2560];
            String ligne;
            int i=0;

            while((ligne=tampon.readLine())!=null && i!=donnees.length) {
                tabIntermediaire=ligne.split(",");
                donnees[i]=tabIntermediaire;
                i++;
            }
            tampon.close();
            monFichier.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
        return donnees;
    }

    /**
     * Convertit le fichier texte chargé en mémoire en tableau de tableau de floats.
     * @param tableau
     * @return Le fichier texte converti.
     */

    public float[][] conversionTableau(String[][] tableau) {

        float [][] tableauConverti = new float[3][2560];

        for(int i=0;i<tableau.length;i++) {
            for(int j=0;j<tableau[i].length-1;j++) {
                tableauConverti[i][j]=Float.valueOf(tableau[i][j]);
            }
        }
        return tableauConverti;
    }

    /**
     * Charge la ligne du fichier dont le numéro est passé en paramètre.
     * @param numLigne
     * @return
     */

    public String[] chargerLingneFichier(int numLigne) {
        FileReader monFichier = null;
        BufferedReader tampon = null;
        String[] tabIntermediaire = new String[2560];

        try {
            monFichier = new FileReader(file_p);
            int i = 0;
            while(i!=numLigne) {
                i++;
            }
            tampon = new BufferedReader(monFichier);
            String ligne = tampon.readLine();
            tabIntermediaire=ligne.split(",");
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

    public float[] convertirLigneFichier(String[] donnees) {
        float[] ligneConvertie = new float[donnees.length];
        for(int i=0;i<donnees.length;i++) {
            ligneConvertie[i]=Float.valueOf(donnees[i]);
        }
        return ligneConvertie;
    }
}