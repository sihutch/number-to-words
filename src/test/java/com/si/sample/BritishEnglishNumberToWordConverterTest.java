package com.si.sample;

import org.junit.Before;
import org.junit.Test;

public class BritishEnglishNumberToWordConverterTest {

    NumberToWordConverter converter;

    @Before
    public void setup() {
        converter = new BritishEnglishNumberToWordConverter();
    }

    @Test
    public void testZero() {
        final String input = "0";
        TestHelper.assertAsStringAndLong(converter, "zero", "0");
    }

    @Test
    public void testManyZeros() {
        TestHelper.assertAsStringAndLong(converter, "zero", "00000000");
    }

    @Test
    public void testNonZero() {
        TestHelper.assertAsStringAndLong(converter, "one", "00000001");
    }
}