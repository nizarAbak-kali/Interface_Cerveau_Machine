import junit.framework.TestCase;
import math.ComplexNumber;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by Alexou on 26/03/2016.*
 * Classe permettant de tester la classe ComplexNumber
 */
public class ComplexNumberTest extends TestCase {

    private ComplexNumber c;
    private ComplexNumber c2;
    private double echelle_c;
    private double echelle_c2;

    /**
     * Initialisation des variables pour les tests
     * @throws Exception
     */

    @Before
    public void setUp() throws Exception {

        c = new ComplexNumber(2.5, -1);
        c2 = new ComplexNumber(5, -2);
        echelle_c = c.getReal()*c.getReal() + c.getImag()*c.getImag();
        echelle_c2 = c2.getReal()*c2.getReal() + c2.getImag()*c2.getImag();

    }

    /**
     * Action réalisée à la fin des tests.
     * @throws Exception
     */

    @After
    public void tearDown() throws Exception {
        System.gc();

    }

    /**
     * Teste si la valeur réelle du nombre complexe est correcte.
     * @throws Exception
     */

    @Test
    public void testGetReal() throws Exception {

        assertEquals(2.5, c.getReal());

    }

    /**
     * Teste si la valeur imaginaire du nombre complexe est correcte.
     * @throws Exception
     */

    @Test
    public void testGetImag() throws Exception {

        assertEquals(-1.0, c.getImag());
    }

    /**
     * Teste si la valeur absolue du nombre est correcte.
     * @throws Exception
     */

    @Test
    public void testAbs() throws Exception {
        assertEquals(Math.sqrt(7.25), c.abs());

    }

    /**
     * Teste la phase d'un nombre complexe.
     * @throws Exception
     */

    @Test
    public void testPhase() throws Exception {

        assertTrue(-Math.PI < c.phase() || c.phase() > Math.PI);
    }

    /**
     * Teste l'addition de deux nombres complexes.
     * @throws Exception
     */

    @Test
    public void testPlus() throws Exception {

        assertEquals(new ComplexNumber(7.5, -3), c.plus(c2));

    }

    /**
     * Teste la soustraction de deux nombres complexes.
     * @throws Exception
     */

    @Test
    public void testMinus() throws Exception {

        assertEquals(new ComplexNumber(-2.5, 1), c.minus(c2));
    }

    /**
     * Teste la multiplication de deux nombres complexes.
     * @throws Exception
     */

    @Test
    public void testTimes() throws Exception {

        assertEquals(new ComplexNumber(12.5, 2), c.times(c2));

    }

    /**
     * Teste la multiplication d'un nombre complexe par un autre nombre complexe ou pas.
     * @throws Exception
     */

    @Test
    public void testTimes1() throws Exception {

        assertEquals(new ComplexNumber(12.5, -5), c.times(5));
    }

    /**
     * Teste si le conjugué du nombre complexe est correct.
     * @throws Exception
     */

    @Test
    public void testConjugate() throws Exception {

        assertEquals(new ComplexNumber(2.5, 1), c.conjugate());
    }

    /**
     * Teste la réciproque d'un nombre complexe.
     * @throws Exception
     */

    @Test
    public void testReciprocal() throws Exception {

        assertEquals(new ComplexNumber(2.5/7.25, 1/7.25), c.reciprocal());

    }

    /**
     * Teste la division de deux nombres complexes.
     * @throws Exception
     */

    @Test
    public void testDivides() throws Exception {

        assertEquals(new ComplexNumber(0.43103450536727905, -0.06896551698446274), c.divides(c2));
    }

    /**
     * Teste l'exponentielle d'un nombre complexe.
     * @throws Exception
     */

    @Test
    public void testExp() throws Exception {

        assertEquals(new ComplexNumber(6.5822296142578125, -10.251214981079102), c.exp());

    }

    /**
     * Teste le sinus d'un nombre complexe.
     * @throws Exception
     */

    @Test
    public void testSin() throws Exception {

        assertEquals(new ComplexNumber(new ComplexNumber(-1.2362291812896729, 0.941504955291748)), c.sin());

    }

    /**
     * Teste le cosinus d'un nombre complexe.
     * @throws Exception
     */

    @Test
    public void testCos() throws Exception {

        assertEquals(new ComplexNumber(new ComplexNumber(-1.2362291812896729, 0.7033251523971558)), c.cos());

    }

    /**
     * Teste la tangeante d'un nombre complexe.
     * @throws Exception
     */

    @Test
    public void testTan() throws Exception {

        assertEquals(new ComplexNumber(0.7554702758789062, -0.3273392915725708), c.tan());

    }
}