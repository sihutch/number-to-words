package com.si.sample;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CompositePowerConverterTest {

    final NumberToWordConverter powerConverter = new CompositePowerConverter(Magnitude.MILLION);

    @Test
    public void testConvertLessThanAThousand() {
        TestHelper.convertHundreds(powerConverter);
        TestHelper.convertTens(powerConverter);
        TestHelper.convertUnits(powerConverter);
    }

    @Test
    public void testConvertMaximum() {
        final String input = "999999999";
        final String expected = "nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine";
        assertEquals(expected, powerConverter.convert(input));
    }
}