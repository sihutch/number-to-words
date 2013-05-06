package com.si.sample;

import static org.junit.Assert.*;
import org.junit.Test;

public class MagnitudeTest {

    @Test
    public void testPowersOfTen() {
        assertPowerOfTen(0, Magnitude.ONE);
        assertPowerOfTen(1, Magnitude.TEN);
        assertPowerOfTen(2, Magnitude.HUNDRED);
        assertPowerOfTen(3, Magnitude.THOUSAND);
        assertPowerOfTen(6, Magnitude.MILLION);
    }

    @Test
    public void testFromPowersOfTen() {
        assertFromPowerOfTen(Magnitude.ONE, 0);
        assertFromPowerOfTen(Magnitude.TEN, 1);
        assertFromPowerOfTen(Magnitude.HUNDRED, 2);
        assertFromPowerOfTen(Magnitude.THOUSAND, 3);
        assertFromPowerOfTen(Magnitude.MILLION, 6);
    }

    @Test
    public void testGreaterThat() {
        assertTrue(Magnitude.TEN.isGreaterThan(Magnitude.ONE));
        assertFalse(Magnitude.ONE.isGreaterThan(Magnitude.ONE));
        assertFalse(Magnitude.ONE.isGreaterThan(Magnitude.TEN));
    }

    private void assertPowerOfTen(final int expected, final Magnitude magnitude) {
        assertEquals(expected, magnitude.getPowerOfTen());
    }

    private void assertFromPowerOfTen(final Magnitude expectedMagnitude, final int powerOfTen) {
        assertEquals(expectedMagnitude, Magnitude.fromPowerOfTen(powerOfTen));
    }
}