package neuron;

import java.util.Arrays;

/**
 * Created by nizar on 15/11/2015.
 *
 * @author(Nizar ABAK-KALI)
 * <p>
 * class contenant les caracteristique temporelles .
 */
public class CaracteristiqueTemporel {

    float[][] data;
    float[][] results;

    /**
     * Constructeur d'une caractéristique temporelle à partir d'un tableau de flottants représentant les données passé en paramètre.
     * @param data: tableau de tableau de float
     */

    public CaracteristiqueTemporel(float[][] data) {
        this.data = data;
        this.results = init();
    }

    /**
     * Initialise toutes les données statistiques de la caractéristique temporelle.
     */

    private float[][] init() {
        float[][] results = new float[9][2560];
        results[0] = mean(data);
        results[1] = variance(data);
        results[2] = ecartType(data);
        results[3] = skewness(data);
        results[4] = kurtosis(data);
        results[5] = variationCoeff(data);
        results[6] = median_absolute_deviation(data);
        results[7] = rms(data);
        //results[8] = iqr(data);
        results[8] = shannon_entropy(data);

        return results;
    }

    /**
     * Permet de calculer la moyenne d'une caractéristique d'un tableau, ces deux paramètres étant indiqués à la méthode.
     * @param tableau: le tableau de données
     * @param n: la caractéristique
     * @return: la moyenne des caractéristiques communes données des trois signaux d'un fichier.
     */

    private float meanCaracteristique(float[][] tableau, int n) {
        float moyenneCaracteristique=0;

        for(int i=0;i<tableau.length;i++) {
            for(int j=0;j<tableau[i].length;j++) {
                if(j==n) {
                    moyenneCaracteristique+=tableau[i][n];
                }
            }
        }

        return moyenneCaracteristique/tableau.length;
    }

    /**
     * Calcule la moyenne des données.
     * @return La moyenne des données.
     */

    // moyenne des données ;
    private float[] mean(float[][] tableau) {
        /*float som = 0;

        for (int i = 0; i < data.length; i++) {
            som += data[i];
        }

        return som / data.length;*/

        float[] moyenne = new float[2560];

        for(int i=0;i<tableau.length;i++) {
            moyenne[i]=meanCaracteristique(tableau, i);
        }
        return moyenne;
    }

    /**
     * Permet de calculer la variance d'une caractéristique d'un tableau, ces deux paramètres étant indiqués à la méthode.
     * @param tableau: le tableau de données
     * @param n: la caractéristique
     * @return: la variance des caractéristiques communes données des trois signaux d'un fichier.
     */

    private float varianceCaracteristique(float[][] tableau, int n) {

        float varianceCaracteristique=0;

        for(int i=0;i<tableau.length;i++) {
            for(int j=0;j<tableau[i].length;j++) {
                if(j==n) {
                    varianceCaracteristique = (float) Math.sqrt(ecartTypeCaracteristique(tableau, n));
                }
            }
        }

        return varianceCaracteristique;

    }

    /**
     * Calcule la variance des données.
     * @return La variance des données.
     */

    // il s'agit de l'ecart type au carré
    private float[] variance(float[][] tableau) {
        float[] variance = new float[2560];

        for(int i=0;i<variance.length;i++) {
            variance[i]=varianceCaracteristique(tableau, i);
        }

        return variance;

    }

    /**
     * Permet de calculer l'écart-type d'une caractéristique d'un tableau, ces deux paramètres étant indiqués à la méthode.
     * @param tableau: le tableau de données
     * @param n: la caractéristique
     * @return: l'écart-type des caractéristiques communes données des trois signaux d'un fichier.
     */

    private float ecartTypeCaracteristique(float[][] tableau, int n) {

        float ecartTypeCaracteristique=0;

        for(int i=0;i<tableau.length;i++) {
            for(int j=0;j<tableau[i].length;j++) {
                if(j==n) {
                    ecartTypeCaracteristique += (meanCaracteristique(tableau, n) - tableau[i][n]);
                }
            }
        }
        return ecartTypeCaracteristique;

    }

    /**
     * Calcule l'éccart-type des données.
     * @return L'écart-type des données.
     */

    private float[] ecartType(float[][] tableau) {

        //return (float) Math.sqrt(variance);
        float[] ecartType=new float[2560];

        for(int i=0;i<ecartType.length;i++) {
            ecartType[i]=ecartTypeCaracteristique(tableau, i);
        }
        return ecartType;
    }

    /**
     * Permet de calculer le coefficient de dissymétrie d'une série de données d'une caractéristique d'un tableau, ces deux paramètres étant indiqués à la méthode.
     * @param tableau: le tableau de données
     * @param n: la caractéristique
     * @return: le coefficient de dissymétrie des caractéristiques communes données des trois signaux d'un fichier.
     */

    private float skewnessCaracteristique(float[][] tableau, int n) {

        float skewnessCaracteristique=0;

        for(int i=0;i<tableau.length;i++) {
            for(int j=0;j<tableau[i].length;j++) {
                if(j==n) {
                    skewnessCaracteristique += (tableau[i][n] - meanCaracteristique(tableau, n)) * (tableau[i][n] - meanCaracteristique(tableau, n)) * (tableau[i][n] - meanCaracteristique(tableau, n));
                }
            }
        }

        float ec3 = ecartTypeCaracteristique(tableau, n);
        ec3 = ec3*ec3*ec3;

        return skewnessCaracteristique*ec3;

    }

    /**
     * Calcule le coefficient de disymétrie de la série de données.
     * @return Le coefficient de disymétrie.
     */

    private float[] skewness(float[][] tableau) {
        /*float som = 0;
        for (int i = 0; i < data.length; i++) {
            som += (data[i] - mean) * (data[i] - mean) * (data[i] - mean);
        }
        float[] ec3 = ecartType();
        ec3 = ec3 * ec3 * ec3;
        return som / (data.length * ec3);*/

        float[] skewness=new float[2560];

        for(int i=0;i<skewness.length;i++) {
            skewness[i]=skewnessCaracteristique(tableau, i);
        }
        return skewness;
    }

    /**
     * Permet de calculer le coefficient d'applatissement d'une série de données représentant une caractéristique d'un tableau, ces deux paramètres étant indiqués à la méthode.
     * @param tableau: le tableau de données
     * @param n: la caractéristique
     * @return: le coefficiant d'applatissement des caractéristiques communes données des trois signaux d'un fichier.
     */

    private float kurtosisCaracteristique(float[][] tableau, int n) {

        float kurtosisCaracteristique=0;

        for(int i=0;i<tableau.length;i++) {
            for(int j=0;j<tableau[i].length;j++) {
                if(j==n) {
                    kurtosisCaracteristique += (tableau[i][n] - meanCaracteristique(tableau, n)) * (tableau[i][n] - meanCaracteristique(tableau, n)) * (tableau[i][n] - meanCaracteristique(tableau, n));
                }
            }
        }

        float ec4 = ecartTypeCaracteristique(tableau, n);
        ec4 = ec4*ec4*ec4*ec4;

        return kurtosisCaracteristique*ec4;

    }

    /**
     * Calcule le coefficient d'aplatissement des données.
     * @return Le coefficient d'aplatissement.
     */

    private float[] kurtosis(float[][] tableau) {
        /*float som = 0;
        for (int i = 0; i < data.length; i++) {
            som += (data[i] - mean) * (data[i] - mean) * (data[i] - mean) * (data[i] - mean);
        }
        float ec4 = ecartType();
        ec4 = ec4 * ec4 * ec4 * ec4;
        return som / (data.length * ec4);*/

        float[] kurtosis = new float[2560];

        for(int i=0;i<kurtosis.length;i++) {
            kurtosis[i]=kurtosisCaracteristique(tableau, i);
        }
        return kurtosis;
    }

    /**
     *
     * @param tableau: le tableau de données
     * @param n: la caractéristique donnée
     * @return La variation de coefficient d'une caractéristique donnée
     */

    private float variationCoeffCaracteristique(float[][] tableau, int n) {

        float variationCoeffCaracteristique = 0;

        for(int i=0;i<tableau.length;i++) {
            for(int j=0;j<tableau[i].length;j++) {
                if(j==n) {
                    variationCoeffCaracteristique = ecartTypeCaracteristique(tableau, n)/meanCaracteristique(tableau, n);
                }
            }
        }

        return variationCoeffCaracteristique;
    }

    /**
     * Calcule la variation du coefficient.
     * @return La variation du coefficient.
     */

    private float[] variationCoeff(float[][] tableau) {
        //return ecartType() / mean;
        float[] variationCoeff = new float[2560];

        for(int i=0;i<variationCoeff.length;i++) {
            variationCoeff[i]=variationCoeffCaracteristique(tableau, i);
        }

        return variationCoeff;
    }

    /**
     * Permet de calculer la déviation des médiants d'une caractéristique d'un tableau, ces deux paramètres étant indiqués à la méthode.
     * @param tableau: le tableau de données
     * @param n: la caractéristique
     * @return: la déviation des médiants des caractéristiques communes données des trois signaux d'un fichier.
     */

    private float median_absolute_deviation_caracteristique(float[][] tableau, int n) {
        float median_absolute_deviation_caracteristique=0;

        for(int i=0;i<tableau.length;i++) {
            for(int j=0;j<tableau[i].length;j++) {
                if(j==n) {
                    median_absolute_deviation_caracteristique+=tableau[i][j] - meanCaracteristique(tableau, n);
                }
            }
        }

        return median_absolute_deviation_caracteristique;
    }

    /**
     * Calcule la déviation absolue du médian des données
     * @return La déviation absolue du médian..
     */

    private float[] median_absolute_deviation(float[][] tableau) {
        /*float som = 0;

        for (int i = 0; i < data.length; i++) {
            som += data[i] - mean;
        }

        return som / data.length;*/

        float[] median_absolute_deviation = new float[2560];

        for(int i=0;i<median_absolute_deviation.length;i++) {
            median_absolute_deviation[i]=median_absolute_deviation_caracteristique(tableau, i);
        }
        return median_absolute_deviation;
    }

    /**
     * Permet de calculer le rms d'une caractéristique d'un tableau, ces deux paramètres étant indiqués à la méthode.
     * @param tableau: le tableau de données
     * @param n: la caractéristique
     * @return: le rms des caractéristiques communes données des trois signaux d'un fichier.
     */

    private float rmsCaracteristique(float[][] tableau, int n) {

        float rmsCaracteristique=0;

        for(int i=0;i<tableau.length;i++) {
            for(int j=0;j<tableau.length;j++) {
                if(j==n) {
                    rmsCaracteristique+=tableau[i][n]*tableau[i][n];
                }
            }
        }

        return rmsCaracteristique;
    }

    /**
     * Calcule du rms
     * @return rms
     */

    private float[] rms(float[][] tableau) {
        /*float som = 0;

        for (int i = 0; i < data.length; i++) {
            som += data[i] * data[i];
        }

        return (float) Math.sqrt(som / data.length);*/

        float[] rms = new float[2560];

        for(int i=0;i<rms.length;i++) {
            rms[i]=rmsCaracteristique(tableau, i);
        }

        return rms;
     }

    /**
     * Permet de calculer le iqr d'une caractéristique d'un tableau, ces deux paramètres étant indiqués à la méthode.
     * @param tableau: le tableau de données
     * @param n: la caractéristique
     * @return: le iqr des caractéristiques communes données des trois signaux d'un fichier.
     */

    private float iqrCaracteristique(float[][] tableau, int n) {

        float iqrCaracteristique=0;

        for(int i=0;i<tableau.length;i++) {
            for(int j=0;j<tableau[i].length;j++) {
                iqrCaracteristique=tableau[i][3*(tableau[i].length)/4] - tableau[i][tableau[i].length+1]/4;
            }
        }

        return iqrCaracteristique;
    }

    /**
     * Calcule iqr
     * @return iqr
     */

    private float[] iqr(float[][] tableau) {
        //return data[3 * (data.length) / 4] - data[(data.length + 1) / 4];
        float[] iqr = new float[2560];

        for(int i=0;i<iqr.length;i++) {
            iqr[i]=iqrCaracteristique(tableau, i);
        }

        return iqr;
    }

    /**
     * Permet de calculer le shannon d'une caractéristique d'un tableau, ces deux paramètres étant indiqués à la méthode.
     * @param tableau: le tableau de données
     * @param n: la caractéristique
     * @return: le shannon des caractéristiques communes données des trois signaux d'un fichier.
     */

    private float shannon_entroyy_caracteristique(float[][] tableau, int n) {

        float shannon_entropy_caracteristique=0;

        for(int i=0;i<tableau.length;i++) {
            for(int j=0;j<tableau[i].length;j++) {
                if(j==n) {
                    shannon_entropy_caracteristique+=tableau[i][n] * Math.log(tableau[i][n]);
                }
            }
        }

        return shannon_entropy_caracteristique;

    }

    /**
     * Calcule Shannon
     * @return Shannon
     */

    private float[] shannon_entropy(float[][] tableau) {
        /*float som = 0;

        for (int i = 0; i < data.length; i++) {
            som += data[i] * Math.log(data[i]);
        }
        return -som;*/

        float[] shannon_entropy=new float[2560];

        for(int i=0;i<shannon_entropy.length;i++) {
            shannon_entropy[i]=shannon_entroyy_caracteristique(tableau, i);
        }

        return shannon_entropy;
    }

    /**
     *
     * @return Les résultats des calculs effectués sur les données.
     */

    public float[][] getResults() {
        return this.results;
    }
}