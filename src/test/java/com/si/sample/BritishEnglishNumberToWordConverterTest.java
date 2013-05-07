package com.si.sample;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.si.sample.util.Constants;

public class BritishEnglishNumberToWordConverterTest {

    NumberToWordConverter converter;

    @Before
    public void setup() {
        converter = new BritishEnglishNumberToWordConverter();
    }

    @Test
    public void testZero() throws ParseException {
        final String input = "0";
        TestHelper.assertAsStringAndLong(converter, "zero", "0");
    }

    @Test
    public void testManyZeros() throws ParseException {
        TestHelper.assertAsStringAndLong(converter, "zero", "00000000");
    }

    @Test
    public void testNonZero() throws ParseException {
        TestHelper.assertAsStringAndLong(converter, "one", "00000001");
    }

    @Test
    public void testDecmialIgnored() throws ParseException {
        assertEquals("one", converter.convert("1.5"));
    }

    @Test
    public void testCommasAllowed() throws ParseException {
        assertEquals(TestHelper.MAXIMUM_VALUE_IN_WORDS, converter.convert("999,999,999.99"));
    }

    @Test
    public void testNegativeMinimum() throws ParseException {
        assertEquals(Constants.MINUS + " " + TestHelper.MAXIMUM_VALUE_IN_WORDS,
            converter.convert("-999,999,999.99"));
    }

    @Test(expected = ParseException.class)
    public void testUnparsableNumber() throws Exception {
        assertEquals(Constants.MINUS + " " + TestHelper.MAXIMUM_VALUE_IN_WORDS,
            converter.convert("xyz"));
    }
}