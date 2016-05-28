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
     * Méthode qui permet de lire les données d'un fichier donné et de les afficher dans la console.
     */

    private ArrayList<String[]> chargerFichier() {

        ArrayList<String[]> listeDonnees = new ArrayList<String[]>();
        File fichier = new File(file_p);
        String[] tabIntermediaire = new String[1000];

        try {
            InputStream flux = new FileInputStream(fichier);
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader buff = new BufferedReader(lecture);
            String ligne;
            int i=0;

            while((ligne=buff.readLine())!=null && i!=listeDonnees.size()) {
                tabIntermediaire=ligne.split(",");
                tabIntermediaire=ligne.split("-");
                listeDonnees.add(tabIntermediaire);
                i++;
            }
            buff.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return listeDonnees;

    }

    private ArrayList<Float[]> convertirDonnees(ArrayList<String[]> donnees) {

        ArrayList<Float[]> donneesConverties = new ArrayList<Float[]>();
        Float[] tabIntermediaire = new Float[1000];

        for(int i=0;i<donnees.size();i++) {
            for(int j=0;j<donnees.get(i).length;j++) {
                tabIntermediaire[j]=Float.valueOf(donnees.get(i)[i]);
            }
            donneesConverties.add(tabIntermediaire);
        }

        return donneesConverties;

    }

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

    public Float[] convertirPremiereLigneFichier(String[] donnees) {
        Float[] premiereLigneConvertie = new Float[donnees.length];
        for(int i=0;i<donnees.length;i++) {
            premiereLigneConvertie[i]=Float.valueOf(donnees[i]);
        }
        return premiereLigneConvertie;
    }

    public void run() {
        ArrayList<String[]> donneesFichier = chargerFichier();
        ArrayList<Float[]> donneesConverties = convertirDonnees(donneesFichier);
    }
}