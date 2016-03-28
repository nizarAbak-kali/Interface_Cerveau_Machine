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

    public ArrayList<String> chargerFichier() {

        ArrayList<String> listeDonnees = new ArrayList<String>();

        String backSlash = System.getProperty("file.separator");
        String virgule = System.clearProperty("file.separator");
        file_p.replace(backSlash, "\\");
        File fichierDonneesIris = new File(file_p);

        try {
            InputStream flux = new FileInputStream(fichierDonneesIris);
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader buff = new BufferedReader(lecture);
            String ligne;
            int i=0;

            while((ligne=buff.readLine())!=null && i!=listeDonnees.size()) {
                listeDonnees.add(ligne);
                i++;
            }
            buff.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return listeDonnees;

    }

    public ArrayList<Float> convertirDonnees(ArrayList<String> donnees) {

        ArrayList<Float> donneesConverties = new ArrayList<Float>();

        for(int i=0;i<donnees.size();i++) {
            donneesConverties.add(Float.valueOf(donnees.get(i)));
        }

        return donneesConverties;

    }

    public void run() {
        ArrayList<String> donneesFichier = chargerFichier();
        ArrayList<Float> donneesConverties = convertirDonnees(donneesFichier);
    }
}
