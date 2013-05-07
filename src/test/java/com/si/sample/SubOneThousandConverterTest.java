package com.si.sample;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

public class SubOneThousandConverterTest {

    NumberToWordConverter converter;

    @Before
    public void setup() {
        converter = new SubOneThousandConverter();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNull() throws ParseException {
        converter.convert(null);
    }

    @Test
    public void testConvert() throws ParseException {
        TestHelper.convertTens(converter);
        TestHelper.convertUnits(converter);
        TestHelper.convertHundreds(converter);
    }

    @Test
    public void testConvertZero() throws ParseException {
        final String expected = "";
        TestHelper.assertAsStringAndLong(converter, expected, "0");
    }
}