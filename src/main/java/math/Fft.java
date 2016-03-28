package math;

/**
 * Created by nizar on 15/11/2015.
 * Il s'agit de l'implémentation de l'algorithme de fast fourrier transform
 *
 * @author(Nizar ABAK-KALI)
 */
public class Fft {

    /**
     * Constructeur par défaut d'un fft
     */

    public Fft() {
    }

    /**
     * compute the FFT of x[], assuming its length is a power of 2
     * @param x: tableau de ComplexNumber
     * @return fft of X[]
     */
    public static ComplexNumber[] fft(ComplexNumber[] x) {
        int N = x.length;

        // cas particulier
        if (N == 1) return new ComplexNumber[]{x[0]};
        if (N % 2 != 0) {
            throw new RuntimeException("N n'est pas une puissance de deux");
        }

        // fft de nombre pairs
        ComplexNumber[] paire = new ComplexNumber[N / 2];
        for (int k = 0; k < N / 2; k++) {
            paire[k] = x[2 * k];
        }
        ComplexNumber[] q = fft(paire);

        // fft de nombre impairs
        ComplexNumber[] impaire = paire;//ici on peut réutiliser paire
        for (int k = 0; k < N / 2; k++) {
            impaire[k] = x[2 * k + 1];
        }
        ComplexNumber[] r = fft(impaire);

        // on combine
        ComplexNumber[] y = new ComplexNumber[N];
        for (int i = 0; i < N / 2; i++) {
            double kth = -2 * i * Math.PI / N;
            ComplexNumber wk = new ComplexNumber(Math.cos(kth), Math.sin(kth));
            y[i] = q[i].plus(wk.times(r[i]));
            y[i + N / 2] = q[i].minus(wk.times(r[i]));
        }

        return y;
    }

    /**
     * Calcule le fft inverse de x[] en partant du principe que x est un nombre paire
     * @param x: tableau de ComplexNumber
     * @return fft inverse de X[]
     */

    // Calcule le fft innverse de x[] en partant du principe que x est un nb paire
    public static ComplexNumber[] ifft(ComplexNumber[] x) {
        int N = x.length;
        ComplexNumber[] y = new ComplexNumber[N];

        // prend le conjugué
        for (int i = 0; i < N; i++) {
            y[i] = x[i].conjugate();
        }

        // calcule le FFT dans le sens normale
        y = fft(y);

        // on  prend le conjugué un nouvelle fois
        for (int i = 0; i < N; i++) {
            y[i] = y[i].conjugate();
        }

        // on divise par N
        for (int i = 0; i < N; i++) {
            y[i] = y[i].times(1.0 / N);
        }

        return y;

    }


}

