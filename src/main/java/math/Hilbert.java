package math;

/**
 * Created by nizar on 15/11/2015.
 *
 * @author(Nizar ABAK-KALI)
 */


/**
 * Computes the N-point Discrete Hilbert Transform of real valued vector x:
 * The algorithm consists of the following stages:
 * - X(w) = FFT(x) is computed
 * - H(w), DFT of a Hilbert transform filter h[n], is created:
 * H[0]=H[N/2]=1
 * H[w]=2 for w=1,2,...,N/2-1
 * H[w]=0 for w=N/2+1,...,N-1
 * - x[n] and h[n] are convolved (i.e. X(w) and H(w) multiplied)
 * - y[n], the Discrete Hilbert Transform of x[n] is computed by y[n]=IFFT(X(w)H(w)) for n=0,...,N-1
 */
public class Hilbert {

    /**
     * Fonction permettant d'appliquer la transformée de Fourrier sur un tableau de nombres flottants donné.
     * @param x: tableau de float
     * @return Le tableau de nombres complèxes résultant de la transformée de Fourrier.
     */

    public static ComplexNumber[] transform(float[] x) {
        return transform(x, x.length);
    }


    /**
     * Fonction permettant d'appliquer la transformée de Fourrier sur un tableau de nombres flottants d'une longueur donnée, ces deux variables étant passées en paramètres.
     * @param x: tableau de float
     * @param N: int
     * @return Le tableau de nombres complèxes résultant de la transformée de Fourrier.
     */

    public static ComplexNumber[] transform(float[] x, int N) {

        ComplexNumber[] tmp = new ComplexNumber[N];
        for (int i = 0; i < N; i++) {
            tmp[i].setReal(x[i]);
            tmp[i].setImag(0.0);
        }
        // on applique la transformé de fourrier
        ComplexNumber[] X = Fft.fft(tmp);

        // on creer un nouveau tab de reels ;
        float[] H = new float[N];

        // on récupere l'entier le plus proche inférieur ou égale à (N/2+0.5)
        int NOver2 = (int) Math.floor(N / 2 + 0.5);

        int w;
        H[0] = (float) 1.0;
        H[NOver2] = (float) 1.0;

        for (w = 1; w <= NOver2 - 1; w++)
            H[w] = (float) 2.0;

        for (w = NOver2 + 1; w <= N - 1; w++)
            H[w] = (float) 0.0;

        for (w = 0; w < N; w++) {
            X[w].setReal(X[w].getReal() * H[w]);
            X[w].setImag(X[w].getReal() * H[w]);
        }

        return Fft.ifft(X);
    }

}