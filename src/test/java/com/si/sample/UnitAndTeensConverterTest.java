package com.si.sample;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UnitAndTeensConverterTest {

    NumberToWordConverter converter;

    @Before
    public void setup() {
        converter = new UnitAndTeensConverter();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNull() {
        converter.convert(null);
    }

    @Test
    public void testConvert() {
        TestHelper.convertUnits(converter);
    }

    /**
     * Ensure that the units can be extracted from a longer string of digits
     */
    @Test
    public void testConvertLarger() {
        final String expected = "fifteen";
        final String input = "99915";
        assertEquals(expected, converter.convert(input));
    }

    @Test
    public void testOutOfRange() {
        final String expected = "";
        final String input = "999";
        assertEquals(expected, converter.convert(input));
    }
}