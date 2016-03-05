package donnees;

import java.io.*;

public class RecupFichier {

    //fonction qui sera modifiée en fonction de la base de données que nous aurons par la suite

    public void chargerFichier(int memoireNecessaire, String nomFichier) {
        File fichier = new File(nomFichier);
        String [] donnees = new String[memoireNecessaire];

        try {
            InputStream flux = new FileInputStream(fichier);
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader buff = new BufferedReader(lecture);
            String ligne;

            int i=0;

            while((ligne=buff.readLine())!=null) {
                donnees[i]=ligne;
                i++;
                }
            flux.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Fonction qui sera modifiée par la suite en fonction de la base de données que l'on aura par la suite.

    public float[] convertirDonnees(int memoireNecessaire, String [] donneesInitiales) {

        float [] donneesConverties = new float[memoireNecessaire];

        for(int i=0;i<donneesInitiales.length;i++) {
            donneesConverties[i]=Float.valueOf(donneesInitiales[i]);
        }
        return donneesConverties;
    }
}