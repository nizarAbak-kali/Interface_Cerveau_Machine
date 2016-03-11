package neuron;

/**
 * Created by nizar on 15/11/2015.
 *
 * @author(Nizar ABAK-KALI)
 * <p>
 * class contenant les caracteristique temporel .
 */
public class CaracteristiqueTemporel {

    float mean;
    float variance;
    float skewness;
    float kurtosis;
    float[] data;

    public CaracteristiqueTemporel(float[] data) {
        this.data = data;
        init();
    }

    private void init() {
        float mean = mean();
        float variance = variance();
        float ecartType = ecartType();
        float skewness = skewness();
        float kurtosis = kurtosis();
    }

    // moyenne des données ;
    private float mean() {
        float som = 0;

        for (int i = 0; i < data.length; i++) {
            som += data[i];
        }

        return som / data.length;

    }

    private float addition() {
        return this.mean + this.variance + this.skewness + this.kurtosis;
    }

    // il s'agit de l'ecart type au carré
    private float variance() {
        float som = 0;
        for (int i = 0; i < data.length; i++) {
            som += (mean - data[i]) * (mean - data[i]);
        }

        return som / data.length;

    }

    private float ecartType() {
        return (float) Math.sqrt(variance);
    }

    private float skewness() {
        float som = 0;
        for (int i = 0; i < data.length; i++) {
            som += (data[i] - mean) * (data[i] - mean) * (data[i] - mean);
        }
        float ec3 = ecartType();
        ec3 = ec3 * ec3 * ec3;
        return som / (data.length * ec3);
    }

    private float kurtosis() {
        float som = 0;
        for (int i = 0; i < data.length; i++) {
            som += (data[i] - mean) * (data[i] - mean) * (data[i] - mean) * (data[i] - mean);
        }
        float ec4 = ecartType();
        ec4 = ec4 * ec4 * ec4 * ec4;
        return som / (data.length * ec4);
    }

    private float variationCoeff() {
        return ecartType() / mean;
    }

    private float median_absolute_deviation() {
        float som = 0;

        for (int i = 0; i < data.length; i++) {
            som += data[i] - mean;
        }

        return som / data.length;
    }

    private float rms() {
        float som = 0;

        for (int i = 0; i < data.length; i++) {
            som += data[i] * data[i];
        }

        return (float) Math.sqrt(som / data.length);
    }

    private float iqr() {
        return data[3 * (data.length) / 4] - data[(data.length + 1) / 4];
    }

    private float shannon_entropy() {
        float som = 0;

        for (int i = 0; i < data.length; i++) {
            som += data[i] * Math.log(data[i]);
        }
        return -som;
    }
}
