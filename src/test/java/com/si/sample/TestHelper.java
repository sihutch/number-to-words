package com.si.sample;

import static org.junit.Assert.assertEquals;

public class TestHelper {

    public static void convertUnits(final NumberToWordConverter converter) {
        final String[] expectedWords = { "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "forteen", "fifteen",
            "sixteen", "seventeen", "eighteen", "nineteen" };
        for (int i = 1; i < 10; i++) {
            assertEquals(expectedWords[i - 1], converter.convert(String.valueOf(i)));
        }
    }

    public static void convertTens(final NumberToWordConverter converter) {
        final String[] expectedWords = {
            "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"
        };
        for (int i = 20; i <= 90; i += 10) {
            assertEquals(expectedWords[(i / 10) - 2], converter.convert(String.valueOf(i)));
        }
    }

    public static void convertHundreds(final NumberToWordConverter converter) {
        assertEquals("one hundred", converter.convert(100));
        assertEquals("one hundred and eleven", converter.convert(111));
        assertEquals("one hundred and one", converter.convert(101));
        assertEquals("nine hundred and ninety nine", converter.convert(999));
    }
}