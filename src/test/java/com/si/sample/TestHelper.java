package com.si.sample;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

public class TestHelper {

    public static final String MAXIMUM_VALUE_IN_WORDS = "nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine";

    public static void convertUnits(final NumberToWordConverter converter) throws ParseException {
        final String[] expectedWords = { "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "forteen", "fifteen",
            "sixteen", "seventeen", "eighteen", "nineteen" };
        for (int i = 1; i < 10; i++) {
            assertAsStringAndLong(converter, expectedWords[i - 1], String.valueOf(i));
        }
    }

    public static void convertTens(final NumberToWordConverter converter) throws ParseException {
        final String[] expectedWords = {
            "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"
        };
        for (int i = 20; i <= 90; i += 10) {
            assertAsStringAndLong(converter, expectedWords[(i / 10) - 2], String.valueOf(i));
        }
    }

    public static void convertHundreds(final NumberToWordConverter converter) throws ParseException {
        assertAsStringAndLong(converter, "one hundred", "100");
        assertAsStringAndLong(converter, "one hundred and eleven", "111");
        assertAsStringAndLong(converter, "one hundred and one", "101");
        assertAsStringAndLong(converter, "nine hundred and ninety nine", "999");
    }

    public static void assertAsStringAndLong(final NumberToWordConverter converter,
        final String expectedWords, final String value) throws ParseException {
        assertEquals(expectedWords, converter.convert(value));
        assertEquals(expectedWords, converter.convert(Long.valueOf(value)));
    }
}