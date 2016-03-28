package math;

/**
 * Created by nizar on 15/11/2015.
 *
 * @author(Nizar ABAK-KALI)
 */

/**
 * A complex number: real+sqrt(-1).imag
 * implementation d'un modèle pour representer les nombres complexes
 */
public class ComplexNumber {

    private double real;
    private double imag;

    public ComplexNumber() {

    }

    /**
     * Constructeur d'un nombre complèxe.
     * @param c
     */

    public ComplexNumber(ComplexNumber c) {
        this.real = c.real;
        this.imag = c.imag;
    }

    /**
     * Constructeur d'un nombre complèxe.
     * @param realIn: float
     * @param imagIn: float
     */

    public ComplexNumber(float realIn, float imagIn) {
        this.real = realIn;
        this.imag = imagIn;
    }

    /**
     * Constructeur d'un nombre complèxe.
     * @param realIn: double
     * @param imagIn: double
     */

    public ComplexNumber(double realIn, double imagIn) {
        this.real = (float) realIn;
        this.imag = (float) imagIn;
    }

    /**
     *
     * @return La partie réelle du nombre complèxe.
     */

    public double getReal() {
        return real;
    }

    /**
     * Permet de modifier la partie réelle du nombre complèxe.
     * @param real: double
     */

    public void setReal(double real) {
        this.real = real;
    }

    /**
     *
     * @return La partie imaginaire du nombre complèxe.
     */

    public double getImag() {
        return imag;
    }

    /**
     * Perme de modifier la partie imaginaire du nombre complèxe.
     * @param imag: double
     */

    public void setImag(double imag) {
        this.imag = imag;
    }

    /**
     *
     *
     * @return La valeur absolue du nombre complèxe.
     */

    // retourne la valeur absolue du complexe j'ai lue aussi (modulus,magnitude)
    public double abs() {
        return Math.hypot(this.real, this.imag);
    } // Math.sqrt(re*re + im*im)

    /**
     *
     * @return L'angle du nombre complèxe.
     */

    // retourne l' angle du complexe j'ai lue aussi (phase,argument)
    public double phase() {
        return Math.atan2(this.real, this.imag);
    } // entre -pi et pi

    /**
     *
     * @param c: ComplexNumber
     * @return L'addition d'un autre nombre complèxe à celui passé en paramètre.
     */

    // retourne un nouvel objet complex dont la valeur est : this + c
    public ComplexNumber plus(ComplexNumber c) {
        ComplexNumber a = this; // reference a l'objet présent
        double reel = a.real + c.real;
        double imagi = a.imag + c.imag;
        return new ComplexNumber(reel, imagi);
    }

    /**
     *
     * @param c: ComplexNumber
     * @return La soustraction d'un autre nombre complèxe à celui passé en paramètre.
     */

    // retourne un nouvel objet complex dont la valeur est : this - c
    public ComplexNumber minus(ComplexNumber c) {
        ComplexNumber a = this; // reference a l'objet présent
        double reel = a.real - c.real;
        double imagi = a.imag - c.imag;
        return new ComplexNumber(reel, imagi);
    }


    /**
     *
     * @param c: ComplexNumber
     * @return La multiplication d'un nombre complèxe par celui passé en paramètre.
     */

    // retourne un nouvel objet complex dont la valeur est : this * c
    public ComplexNumber times(ComplexNumber c) {
        ComplexNumber a = this; // reference a l'objet présent
        double reel = a.real * c.real;
        double imagi = a.imag * c.imag;
        return new ComplexNumber(reel, imagi);
    }

    /**
     *
     * @param d: double
     * @return La multiplication scalaire d'un complèxe par celui passé en paramètre.
     */

    //multiplication scalaire
    // retourne un nouvel objet complex dont la valeur est : this * d
    public ComplexNumber times(double d) {
        return new ComplexNumber(d * this.real, d * this.imag);
    }

    /**
     *
     * @return Le conjugué du nombre complèxe.
     */

    // retourne un nouvel objet complex dont la valeur est le conjugué
    public ComplexNumber conjugate() {
        return new ComplexNumber(this.real, -this.imag);
    }

    /**
     *
     * @return Le réciproque du nombre complèxe.
     */

    // retourne un nouvel objet complex dont la valeur est le reciproque
    public ComplexNumber reciprocal() {
        double echelle = this.real * this.real + this.imag * this.imag;
        return new ComplexNumber(this.real / echelle, -this.imag / echelle);
    }

    /**
     *
     * @param b: ComplexNumber
     * @return La division du nombre complèxe par celui passé en paramètre.
     */

    // retourne a / b
    public ComplexNumber divides(ComplexNumber b) {
        ComplexNumber a = this;
        return a.times(b.reciprocal());
    }

    /**
     *
     * @return L'exponentielle du nombre complèxe.
     */

    // retourne un nouvel objet complex dont la valeur est l'exponantiel de this
    public ComplexNumber exp() {
        return new ComplexNumber(Math.exp(this.real) * Math.cos(this.imag), Math.exp(this.real) * Math.sin(this.imag));
    }

    /**
     *
     * @return Le sinus du nombre complèxe.
     */

    // retourne un nouvel objet complex dont la valeur est le sinus de this
    public ComplexNumber sin() {
        return new ComplexNumber(Math.cos(this.real) * Math.cosh(this.imag), Math.cos(this.real) * Math.sinh(this.imag));
    }

    /**
     *
     * @return Le cosinus du nombre complèxe.
     */

    // retourne un nouvel objet complex dont la valeur est le cosinus de this
    public ComplexNumber cos() {
        return new ComplexNumber(Math.cos(this.real) * Math.cosh(this.imag), -Math.sin(this.real) * Math.sinh(this.imag));
    }

    /**
     *
     * @return La tangeante du nombre complèxe.
     */

    // retourne un nouvel objet complex dont la valeur est la tangeante de this
    public ComplexNumber tan() {
        return sin().divides(cos());
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ComplexNumber)) {
            return false;
        }
        ComplexNumber cn = (ComplexNumber) other;
        if (real != cn.real)
            return false;
        if (imag != cn.imag)
            return false;

        return true;
    }

    public String toString() {
        if (imag == 0) return real + "";
        if (real == 0) return imag + "i";
        if (imag < 0) return real + " - " + (-imag) + "i";
        return real + " + " + imag + "i";
    }
}
