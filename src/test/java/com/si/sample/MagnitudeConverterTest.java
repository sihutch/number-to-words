package com.si.sample;

import java.text.ParseException;

import org.junit.Test;

public class MagnitudeConverterTest {

    final NumberToWordConverter converter = new MagnitudeConverter(Magnitude.MILLION);

    @Test
    public void testConvertLessThanAThousand() throws ParseException {
        TestHelper.convertHundreds(converter);
        TestHelper.convertTens(converter);
        TestHelper.convertUnits(converter);
    }

    @Test
    public void testConvertMaximum() throws ParseException {
        final String input = "999999999";
        TestHelper.assertAsStringAndLong(converter, TestHelper.MAXIMUM_VALUE_IN_WORDS, input);
    }

    @Test
    public void testTrailingZeros() throws ParseException {
        final String input = "900000000";
        final String expected = "nine hundred million";
        TestHelper.assertAsStringAndLong(converter, expected, input);
    }


    @Test(expected = IllegalArgumentException.class)
    public void illegalNullContructur() {
        new MagnitudeConverter(null);
    }
}