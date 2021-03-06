package math;
/**
 * Copyright 2004-2006 DFKI GmbH.
 * All Rights Reserved.  Use is subject to license terms.
 * <p>
 * This file is part of MARY TTS.
 * <p>
 * MARY TTS is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, version 3 of the License.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.util.Arrays;


/**
 * This is a wrapper class that can hold two double arrays, one of which is interpreted as containing the real values, the other
 * the imaginary values of the complex numbers.
 *
 * @author nizar
 *
 */
public class ComplexArray {
    public double[] real;
    public double[] imag;

    /**
     * Construction d'un tableau de nombres complèxes de longueur passée en paramètres.
     * @param len:int
     */

    public ComplexArray(int len) {
        init(len);
    }

    /**
     * Construction d'un tableau de nombres complèxes grâce à un tableau de valeurs réelles et un autre de valeurs imaginaires passées en paramètres.
     * @param realVals:tableau de double
     * @param imagVals: tableau de double
     */

    public ComplexArray(double[] realVals, double[] imagVals) {
        if (realVals != null && imagVals != null && realVals.length == imagVals.length) {
            init(realVals.length);
            System.arraycopy(realVals, 0, real, 0, realVals.length);
            System.arraycopy(imagVals, 0, imag, 0, imagVals.length);
        }
    }

    /**
     * Construction d'un tableau de complèxe à partir d'un ComplexArray passé en paramètre.
     * @param c: ComplexArray
     */

    public ComplexArray(ComplexArray c) {
        this(c.real, c.imag);
    }

    /**
     * Initialise le tableau de nombres complèxe en donnant la longueur passée en paramètre aux deux tableaux d'imaginaires et de réels.
     * @param len: int
     */

    public void init(int len) {
        if (len > 0) {
            real = new double[len];
            imag = new double[len];

            Arrays.fill(real, 0.0);
            Arrays.fill(imag, 0.0);
        } else {
            real = null;
            imag = null;
        }
    }

    /**
     *
     * @param index: int
     * @return Le nombre complèxe se trouvant à l'index passé en paramètre.
     */

    public ComplexNumber get(int index) {
        return new ComplexNumber((float) real[index], (float) imag[index]);
    }
}