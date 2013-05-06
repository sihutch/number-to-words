package com.si.sample.util;


/**
 * @author Simon Hutchinson
 * 
 *         Utility methods specific to Strings
 * 
 */
public final class StringUtils {

    private StringUtils() {
    }

    /**
     * Convert the right substring of a {@link String} of digits into a int.
     * 
     * @param numberString
     *            The String of digits. The numbers from requested substring
     *            must be between 0 and {@link Integer#MAX_VALUE}
     * @param rightOffset
     *            The number of characters to read from the right of the
     *            {@code numberString} Only used if the {@code numberString} is
     *            greater than {@code rightOffset} otherwise the value of
     *            {@code numberString} can be handled directly
     * @return The int value of the stripped string.
     * 
     */
    public static int stripInt(final String numberString, final int rightOffset) {
        Assert.notNull(numberString);
        Assert.greaterThan(0, rightOffset);
        final int num;
        if (numberString.length() > rightOffset) {
            num = Integer.valueOf(numberString.substring(numberString.length() - rightOffset));
        } else {
            num = Integer.valueOf(numberString);
        }
        return num;
    }

    /**
     * Test whether a string is null or simply whitespace
     * 
     * @param s
     *            The {@link String} to test
     * @return true if the string is null or simply whitespace otherwise false
     */
    public static boolean empty(final String s) {
        return s == null || s.trim().equals("");
    }

    /**
     * Test whether a string has at least one non-whitespace character
     * 
     * @param s
     *            The {@link String} to test
     * @return true if the string has at least one non-whitespace character
     *         otherwise false
     */
    public static boolean notEmpty(final String s) {
        return !empty(s);
    }
}