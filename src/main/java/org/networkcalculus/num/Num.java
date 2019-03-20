/*
 * This file is part of the Deterministic Network Calculator (DNC) Number Backend.
 *
 * Copyright (C) 2014 - 2018 Steffen Bondorf
 * Copyright (C) 2017 - 2018 The DiscoDNC contributors
 * Copyright (C) 2019+ The DNC contributors
 *
 * http://networkcalculus.org
 *
 *
 * The Deterministic Network Calculator (DNC) is free software;
 * you can redistribute it and/or modify it under the terms of the 
 * GNU Lesser General Public License as published by the Free Software Foundation; 
 * either version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 */

package org.networkcalculus.num;

import org.networkcalculus.num.implementations.RationalBigInt;
import org.networkcalculus.num.implementations.RationalInt;
import org.networkcalculus.num.implementations.RealDoublePrecision;
import org.networkcalculus.num.implementations.RealSinglePrecision;
import org.networkcalculus.num.values.NaN;
import org.networkcalculus.num.values.NegativeInfinity;
import org.networkcalculus.num.values.PositiveInfinity;

public interface Num {
    final Num NaN = new NaN(Double.NaN);
    final Num POSITIVE_INFINITY = new PositiveInfinity(Double.POSITIVE_INFINITY);
    final Num NEGATIVE_INFINITY = new NegativeInfinity(Double.NEGATIVE_INFINITY);

    public static Num getFactory(NumBackend backend) {
        switch (backend) {
            case REAL_SINGLE_PRECISION:
                return RealSinglePrecision.getInstance();
            case RATIONAL_INTEGER:
                return RationalInt.getInstance();
            case RATIONAL_BIGINTEGER:
                return RationalBigInt.getInstance();
            case REAL_DOUBLE_PRECISION:
            default:
                return RealDoublePrecision.getInstance();
        }
    }

    public static Num getUtils(NumBackend backend) {
    	return getFactory(backend);
    }
    
    // --------------------------------------------------------------------------------------------------------------
    // Constructors
    // --------------------------------------------------------------------------------------------------------------
    
    /*
     * When creating a class N that implements this Num interface,
     * please include at least these constructors:
     * 
     *  private N()
     *  public N(int num)
     *  public N(double value)
     *  public N(int num, int den)
     *  public N(N num)
     */

    /* 
     * Creating a class N extending Num, please add a method
     *		public static N getInstance() { return instance; }
     * to get a generic instance to be used as a factory and utils dispatcher above.
     */

    // --------------------------------------------------------------------------------------------------------------
    // Conversions
    // --------------------------------------------------------------------------------------------------------------
    
    double doubleValue();

    /*
     * When creating a class N that implements this Num interface,
     * that is either a primitive data type or 
     * an instance of a different class.
     */
    
    @Override
    int hashCode();
    
    @Override
    String toString();
    
    // --------------------------------------------------------------------------------------------------------------
    // Factory
    // --------------------------------------------------------------------------------------------------------------

    Num copy();
    
    Num getPositiveInfinity();

    Num createPositiveInfinity();

    Num getNegativeInfinity();

    Num createNegativeInfinity();

    Num getNaN();
    
    Num createNaN();

    Num getZero();

    Num createZero();

    Num create(int num);

    Num create(double value);

    Num create(int num, int den);

    Num create(String num_str) throws Exception;
    
    // --------------------------------------------------------------------------------------------------------------
    // Comparisons
    // --------------------------------------------------------------------------------------------------------------

    // Compare to zero: >, >=, =, <=, <
    boolean gtZero();

    boolean geqZero();

    boolean eqZero();

    boolean leqZero();

    boolean ltZero();

    // Compare to other number: >, >=, =, <=, <
    boolean gt(Num num);
    
    boolean geq(Num num);

    boolean eq(Num num);
    
    boolean eq(double num);

    @Override
    boolean equals(Object obj);
    
    boolean leq(Num num);

    boolean lt(Num num);

    // Properties
    boolean isFinite();

    boolean isInfinite();

    boolean isNaN();

    // --------------------------------------------------------------------------------------------------------------
    // Operations (Utils)
    // --------------------------------------------------------------------------------------------------------------

    Num add(Num num1, Num num2);

    Num sub(Num num1, Num num2);

    Num mult(Num num1, Num num2);

    Num div(Num num1, Num num2);

    Num abs(Num num);

    Num diff(Num num1, Num num2);

    Num max(Num num1, Num num2);

    Num min(Num num1, Num num2);

    Num negate(Num num);
}
