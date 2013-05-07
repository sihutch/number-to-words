package com.si.sample;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

public class SubTwentyConverterTest {

    NumberToWordConverter converter;

    @Before
    public void setup() {
        converter = new SubTwentyConverter();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNull() throws ParseException {
        converter.convert(null);
    }

    @Test
    public void testConvert() throws ParseException {
        TestHelper.convertUnits(converter);
    }

    /**
     * Ensure that the last two units are extracted from a longer string of
     * digits
     * 
     * @throws ParseException
     */
    @Test
    public void testConvertLarger() throws ParseException {
        final String expected = "fifteen";
        final String input = "99915";
        TestHelper.assertAsStringAndLong(converter, expected, input);
    }

    @Test
    public void testOutOfRangeMax() throws ParseException {
        final String expected = "";
        final String input = String.valueOf(SubTwentyConverter.MAX_CONVERT_VALUE + 1);
        TestHelper.assertAsStringAndLong(converter, expected, input);
    }

    @Test
    public void testOutOfRangeMin() throws ParseException {
        final String expected = "";
        final String input = String.valueOf(SubTwentyConverter.MIN_CONVERT_VALUE - 1);
        TestHelper.assertAsStringAndLong(converter, expected, input);
    }
}