package donnees;

import java.io.*;

public class RecupFichier {

    public void chargerFichier(File fichier, int memoireNecessaire, String cheminFichier) {
        String chaine = cheminFichier;
        String backSlash = System.getProperty("file.separator");
        String virgule = System.clearProperty("file.separator");
        chaine.replace(backSlash, "\\");
        fichier = new File(chaine);
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
}