package charts;/**
 * Created by nizar on 11/11/2015.
 *
 * @author(Nizar ABAK-KALI)
 */

import javax.swing.*;

import donnees.LireCVS;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Graphique {

    public static void main(String[] args) {

        LireCVS lireCVS = new LireCVS("C:\\Users\\Alexou\\IdeaProjects\\Interface_Cerveau_Machine_5\\data\\Activity-Chat.csv");
        String[] donnees = lireCVS.chargerPremiereLigneFichier();
        Float[] donneesConverties = lireCVS.convertirPremiereLigneFichier(donnees);
        XYSeries series = new XYSeries("Affichage d'un signal représentant une activité cérébrale");
        for(int i=0;i<donneesConverties.length;i++) {
            series.add(i+10, (double)donneesConverties[i]);
        }
        XYDataset xyDataset = new XYSeriesCollection(series);

        JFreeChart chart = ChartFactory.createXYLineChart("chat signal", "Temps", "Hz", xyDataset, PlotOrientation.VERTICAL, true, true, false);

        ChartFrame frame = new ChartFrame("XYArea chart", chart);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}