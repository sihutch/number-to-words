package com.si.sample;

import static org.junit.Assert.*;

import org.junit.Test;

public class MagnitudeTest {

    @Test
    public void testPowers() {
        assertEquals("hundred", Magnitude.getName(2));
        assertEquals("thousand", Magnitude.getName(3));
        assertEquals("million", Magnitude.getName(6));
        assertNull(Magnitude.getName(1));
        assertNull(Magnitude.getName(7));
    }
}
