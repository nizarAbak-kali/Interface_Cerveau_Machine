package tests;

import junit.framework.Assert;
import junit.framework.TestCase;
import math.ComplexNumber;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Alexou on 26/03/2016.*
 * Classe permettant de tester la classe ComplexNumber
 */
public class ComplexNumberTest extends TestCase {

    private ComplexNumber c;
    private ComplexNumber c2;
    private double echelle_c;
    private double echelle_c2;

    @Before
    public void setUp() throws Exception {

        c = new ComplexNumber(2.5, -1);
        c2 = new ComplexNumber(5, -2);
        echelle_c = c.getReal()*c.getReal() + c.getImag()*c.getImag();
        echelle_c2 = c2.getReal()*c2.getReal() + c2.getImag()*c2.getImag();

    }

    @After
    public void tearDown() throws Exception {
        System.gc();

    }

    @Test
    public void testGetReal() throws Exception {

        assertEquals(2.5, c.getReal());

    }

    @Test
    public void testGetImag() throws Exception {

        assertEquals(-1.0, c.getImag());
    }

    @Test
    public void testAbs() throws Exception {
        assertEquals(Math.sqrt(7.25), c.abs());

    }

    @Test
    public void testPhase() throws Exception {

        assertEquals(3.14, c.phase());
    }

    @Test
    public void testPlus() throws Exception {

        assertEquals(new ComplexNumber(7.5, -3), c.plus(c2));

    }

    @Test
    public void testMinus() throws Exception {

        assertEquals(new ComplexNumber(-2.5, 1), c.minus(c2));
    }

    @Test
    public void testTimes() throws Exception {

        assertEquals(new ComplexNumber(12.5, 2), c.times(c2));

    }

    @Test
    public void testTimes1() throws Exception {

        assertEquals(new ComplexNumber(12.5, -5), c.times(5));
    }

    @Test
    public void testConjugate() throws Exception {

        assertEquals(new ComplexNumber(2.5, 1), c.conjugate());
    }

    @Test
    public void testReciprocal() throws Exception {

        assertEquals(new ComplexNumber(2.5/7.25, 1/7.25), c.reciprocal());

    }

    @Test
    public void testDivides() throws Exception {

        assertEquals(new ComplexNumber(12.5/29, 2/29), c.divides(c2));

    }

    @Test
    public void testExp() throws Exception {

        assertEquals(new ComplexNumber(6.58, 10.25), c.exp());

    }

    @Test
    public void testSin() throws Exception {

        assertEquals(new ComplexNumber(new ComplexNumber(1.541457, -1.173825)), c.sin());

    }

    @Test
    public void testCos() throws Exception {

        assertEquals(new ComplexNumber(new ComplexNumber(1.541457, 0.0517)), c.cos());

    }

    @Test
    public void testTan() throws Exception {

        assertEquals(new ComplexNumber(-1, 1), c.tan());

    }
}