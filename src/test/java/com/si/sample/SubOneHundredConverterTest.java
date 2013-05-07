package com.si.sample;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

public class SubOneHundredConverterTest {

    NumberToWordConverter converter;

    @Before
    public void setup() {
        converter = new SubOneHundredConverter();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNull() throws ParseException {
        converter.convert(null);
    }

    @Test
    public void testConvert() throws ParseException {
        TestHelper.convertTens(converter);
        TestHelper.convertUnits(converter);
    }
}