package charts;/**
 * Created by nizar on 11/11/2015.
 *
 * @author(Nizar ABAK-KALI)
 */

import org.LiveGraph.LiveGraph;
import org.LiveGraph.settings.DataFileSettings;

public class Graphique {
    private static final String data_path = "\\data\\toto.cvs";
    private static final String data_settings_path = "\\data\\startup.lgdfs";

    /**
     * @return Constructeur d'un graphique représentant les données analysées par le réseau de neurones
     */

    public Graphique() {
        DataFileSettings dfs = new DataFileSettings();
        dfs.setDataFile(data_path);
        dfs.setUpdateFrequency(1000);
        dfs.save("\\data\\startup.lgdfs");
    }

    /**
     * Lance la création du graphique.
     */

    public void run() {
        LiveGraph app = LiveGraph.application();
        app.execStandalone(new String[]{"-dfs", data_settings_path});
    }

    /**
     * Méthode principale qui lancera tout le programme.
     * @param args:String
     */

    public static void main(String[] args) {
        Graphique g = new Graphique();
        g.run();

    }


}
