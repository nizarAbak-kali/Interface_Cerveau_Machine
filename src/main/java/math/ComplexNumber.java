package math;

/**
 * Created by nizar on 15/11/2015.
 *
 * @author(Nizar ABAK-KALI)
 */

/**
 * A complex number: real+sqrt(-1).imag
 * implementation d'un model pour representer les nombres complexes
 */
public class ComplexNumber {

    private double real;
    private double imag;

    public ComplexNumber() {

    }

    public ComplexNumber(ComplexNumber c) {
        this.real = c.real;
        this.imag = c.imag;
    }

    public ComplexNumber(float realIn, float imagIn) {
        this.real = realIn;
        this.imag = imagIn;
    }

    public ComplexNumber(double realIn, double imagIn) {
        this.real = (float) realIn;
        this.imag = (float) imagIn;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    // retourne la valeur absolue du complexe j'ai lue aussi (modulus,magnitude)
    public double abs() {
        return Math.hypot(this.real, this.imag);
    } // Math.sqrt(re*re + im*im)

    // retourne l' angle du complexe j'ai lue aussi (phase,argument)
    public double phase() {
        return Math.atan2(this.real, this.imag);
    } // entre -pi et pi

    // retourne un nouvel objet complex dont la valeur est : this + c
    public ComplexNumber plus(ComplexNumber c) {
        ComplexNumber a = this; // reference a l'objet présent
        double reel = a.real + c.real;
        double imagi = a.imag + c.imag;
        return new ComplexNumber(reel, imagi);
    }

    // retourne un nouvel objet complex dont la valeur est : this + c
    public ComplexNumber minus(ComplexNumber c) {
        ComplexNumber a = this; // reference a l'objet présent
        double reel = a.real - c.real;
        double imagi = a.imag - c.imag;
        return new ComplexNumber(reel, imagi);
    }


    // retourne un nouvel objet complex dont la valeur est : this * c
    public ComplexNumber times(ComplexNumber c) {
        ComplexNumber a = this; // reference a l'objet présent
        double reel = a.real * c.real;
        double imagi = a.imag * c.imag;
        return new ComplexNumber(reel, imagi);
    }

    //multiplication scalaire
    // retourne un nouvel objet complex dont la valeur est : this * d
    public ComplexNumber times(double d) {
        return new ComplexNumber(d * this.real, d * this.imag);
    }

    // retourne un nouvel objet complex dont la valeur est le conjugué
    public ComplexNumber conjugate() {
        return new ComplexNumber(this.real, -this.imag);
    }

    // retourne un nouvel objet complex dont la valeur est le reciproque
    public ComplexNumber reciprocal() {
        double echelle = this.real * this.real + this.imag * this.imag;
        return new ComplexNumber(this.real / echelle, -this.imag / echelle);
    }

    // retourne a / b
    public ComplexNumber divides(ComplexNumber b) {
        ComplexNumber a = this;
        return a.times(b.reciprocal());
    }

    // retourne un nouvel objet complex dont la valeur est l'exponantiel de this
    public ComplexNumber exp() {
        return new ComplexNumber(Math.exp(this.real) * Math.cos(this.imag), Math.exp(this.real) * Math.sin(this.imag));
    }

    // retourne un nouvel objet complex dont la valeur est le sinus de this
    public ComplexNumber sin() {
        return new ComplexNumber(Math.cos(this.real) * Math.cosh(this.imag), Math.cos(this.real) * Math.sinh(this.imag));
    }

    // retourne un nouvel objet complex dont la valeur est le cosinus de this
    public ComplexNumber cos() {
        return new ComplexNumber(Math.cos(this.real) * Math.cosh(this.imag), -Math.sin(this.real) * Math.sinh(this.imag));
    }

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
