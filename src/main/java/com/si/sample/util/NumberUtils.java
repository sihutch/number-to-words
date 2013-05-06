package com.si.sample.util;

/**
 * @author Simon Hutchinson
 * 
 *         Utility methods specific to numbers
 */
public final class NumberUtils {

    private NumberUtils() {
    }

    /**
     * Test that a number is between two values inclusive
     * 
     * @param min
     *            The minimum value
     * @param max
     *            The maximum value
     * @param value
     *            The value to test
     * 
     * @return true if {@code value} is between {@code min} and {@code max}
     *         otherwise false
     */
    public static boolean isBetween(final int min, final int max, final int value) {
        return (value >= min && value <= max);
    }

    /**
     * Keep a number of digits from the least significant end of a provided int
     * 
     * e.g given the number 123 and a request to keep 2 digits the return would
     * be 23
     * 
     * @param i
     *            The number from which to extract the digits
     * @param numberToKeep
     *            The number of digits to keep
     * @return The {@code numberToKeep} least significant digits
     */
    public static int keepDigits(final int i, final int numberToKeep) {
        return (int)(i % Math.pow(10, numberToKeep));
    }
}