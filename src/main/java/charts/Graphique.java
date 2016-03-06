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

    public Graphique() {
        DataFileSettings dfs = new DataFileSettings();
        dfs.setDataFile(data_path);
        dfs.setUpdateFrequency(1000);
        dfs.save("\\data\\startup.lgdfs");
    }

    public void run() {
        LiveGraph app = LiveGraph.application();
        app.execStandalone(new String[]{"-dfs", data_settings_path});
    }

    public static void main(String[] args) {
        Graphique g = new Graphique();
        g.run();

    }


}
