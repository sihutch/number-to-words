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
        final String[] expectedWords = { "", "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "forteen", "fifteen",
            "sixteen", "seventeen", "eighteen", "nineteen" };
        for (int i = 1; i < 10; i++) {
            assertEquals(expectedWords[i], converter.convert(String.valueOf(i)));
        }
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