package com.si.sample;

import org.junit.Test;

public class CompositePowerConverterTest {

    final NumberToWordConverter converter = new CompositePowerConverter(Magnitude.MILLION);

    @Test
    public void testConvertLessThanAThousand() {
        TestHelper.convertHundreds(converter);
        TestHelper.convertTens(converter);
        TestHelper.convertUnits(converter);
    }

    @Test
    public void testConvertMaximum() {
        final String input = "999999999";
        final String expected = "nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine";
        TestHelper.assertAsStringAndLong(converter, expected, input);
    }

    @Test
    public void testTrailingZeros() {
        final String input = "900000000";
        final String expected = "nine hundred million";
        TestHelper.assertAsStringAndLong(converter, expected, input);
    }
}