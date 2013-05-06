package com.si.sample.util;

import static org.junit.Assert.*;
import org.junit.Test;

public class NumberUtilsTest {

    @Test
    public void testBetween() {
        assertTrue(NumberUtils.isBetween(1, 3, 2));
    }

    @Test
    public void testBetweenInclusiveMinimum() {
        assertTrue(NumberUtils.isBetween(2, 3, 2));
    }

    @Test
    public void testBetweenInclusiveMaximum() {
        assertTrue(NumberUtils.isBetween(2, 3, 3));
    }

    @Test
    public void testBetweenBelowMinimum() {
        assertFalse(NumberUtils.isBetween(2, 3, 1));
    }

    @Test
    public void testBetweenAboveMaximum() {
        assertFalse(NumberUtils.isBetween(1, 2, 3));
    }

    @Test
    public void testKeepDigits() {
        final int i = 11111;
        assertEquals(1, NumberUtils.keepDigits(i, 1));
        assertEquals(11, NumberUtils.keepDigits(i, 2));
        assertEquals(111, NumberUtils.keepDigits(i, 3));
        assertEquals(1111, NumberUtils.keepDigits(i, 4));
        assertEquals(11111, NumberUtils.keepDigits(i, 5));
        assertEquals(11111, NumberUtils.keepDigits(i, 20));

        System.out.println(Integer.MAX_VALUE);
    }
}