package neuron;

/**
 * Created by nizar on 15/11/2015.
 *
 * @author(Nizar ABAK-KALI)
 * <p>
 * class contenant les caracteristique temporelles .
 */
public class CaracteristiqueTemporel {

    float mean;
    float variance;
    float skewness;
    float kurtosis;
    float[] data;

    /**
     * Constructeur d'une caractéristique temporelle à partir d'un tableau de flottants représentant les données passé en paramètre.
     * @param data: tableau de float
     */

    public CaracteristiqueTemporel(float[] data) {
        this.data = data;
        init();
    }

    /**
     * Initialise toutes les données statistiques de la caractéristique temporelle.
     */

    private void init() {
        float mean = mean();
        float variance = variance();
        float ecartType = ecartType();
        float skewness = skewness();
        float kurtosis = kurtosis();
    }

    /**
     * Calcule la moyenne des données.
     * @return La moyenne des données.
     */

    // moyenne des données ;
    private float mean() {
        float som = 0;

        for (int i = 0; i < data.length; i++) {
            som += data[i];
        }

        return som / data.length;

    }

    /**
     * Additionne toutes les variables statistiques.
     * @return La somme des variables statistiques.
     */

    private float addition() {
        return this.mean + this.variance + this.skewness + this.kurtosis;
    }

    /**
     * Calcule la variance des données.
     * @return La variance des données.
     */

    // il s'agit de l'ecart type au carré
    private float variance() {
        float som = 0;
        for (int i = 0; i < data.length; i++) {
            som += (mean - data[i]) * (mean - data[i]);
        }

        return som / data.length;

    }

    /**
     * Calcule l'éccart-type des données.
     * @return L'écart-type des données.
     */

    private float ecartType() {
        return (float) Math.sqrt(variance);
    }

    /**
     * Calcule le coefficient de disymétrie de la série de données.
     * @return Le coefficient de disymétrie.
     */

    private float skewness() {
        float som = 0;
        for (int i = 0; i < data.length; i++) {
            som += (data[i] - mean) * (data[i] - mean) * (data[i] - mean);
        }
        float ec3 = ecartType();
        ec3 = ec3 * ec3 * ec3;
        return som / (data.length * ec3);
    }

    /**
     * Calcule le coefficient d'aplatissement des données.
     * @return Le coefficient d'aplatissement.
     */

    private float kurtosis() {
        float som = 0;
        for (int i = 0; i < data.length; i++) {
            som += (data[i] - mean) * (data[i] - mean) * (data[i] - mean) * (data[i] - mean);
        }
        float ec4 = ecartType();
        ec4 = ec4 * ec4 * ec4 * ec4;
        return som / (data.length * ec4);
    }

    /**
     * Calcule la variation du coefficient.
     * @return La variation du coefficient.
     */

    private float variationCoeff() {
        return ecartType() / mean;
    }

    /**
     * Calcule la déviation absolue du médian des données
     * @return La déviation absolue du médian..
     */

    private float median_absolute_deviation() {
        float som = 0;

        for (int i = 0; i < data.length; i++) {
            som += data[i] - mean;
        }

        return som / data.length;
    }

    /**
     * Calcule du rms
     * @return rms
     */

    private float rms() {
        float som = 0;

        for (int i = 0; i < data.length; i++) {
            som += data[i] * data[i];
        }

        return (float) Math.sqrt(som / data.length);
    }

    /**
     * Calcule iqr
     * @return iqr
     */

    private float iqr() {
        return data[3 * (data.length) / 4] - data[(data.length + 1) / 4];
    }

    /**
     * Calcule Shannon
     * @return Shannon
     */

    private float shannon_entropy() {
        float som = 0;

        for (int i = 0; i < data.length; i++) {
            som += data[i] * Math.log(data[i]);
        }
        return -som;
    }
}
