package neuron;

/**
 * Created by nizar on 15/11/2015.
 *
 * @author(Nizar ABAK-KALI)
 * <p>
 * class contenant les caracteristique temporel .
 */
public class CaracteristiqueTemporel {

    float f1;
    float f2;
    float f3;
    float f4;

    public CaracteristiqueTemporel() {
        init();
    }

    private void init() {
        float mean = mean();
        float variance = variance();
        float ecartType = ecartType();
        float skewness = skewness();
        float kurtosis = kurtosis();
    }

    private float mean() {
        return addition()/4;

    }

    private float addition() {
        return this.f1+this.f2+this.f3+this.f4;
    }

    private float variance() {

        return ((1/4) * (f1 - mean() + f2 - mean() + f3 - mean() + f4 - mean()));

    }

    private float ecartType() {
        return (float) Math.sqrt(variance());
    }

    private float skewness() {
        return (addition()*addition()*addition())/(ecartType()*ecartType()*ecartType());
    }

    private float kurtosis() {

        return (addition()*addition()*addition()*addition())/(ecartType()*ecartType()*ecartType()*ecartType());
    }

}
