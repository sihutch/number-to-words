package com.si.sample;

import org.junit.Before;
import org.junit.Test;

public class TensConverterTest {

    NumberToWordConverter converter;

    @Before
    public void setup() {
        converter = new TensConverter();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNull() {
        converter.convert(null);
    }

    @Test
    public void testConvert() {
        TestHelper.convertTens(converter);
        TestHelper.convertUnits(converter);
    }
}