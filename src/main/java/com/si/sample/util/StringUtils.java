package com.si.sample.util;


/**
 * @author Simon Hutchinson
 * 
 *         Utility methods specific to Strings
 * 
 */
public class StringUtils {

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
     * @throws NumberFormatException
     *             If the characters stripped from the string cannot be
     *             converted to an int
     */
    public static int stripInt(final String numberString, final int rightOffset)
        throws NumberFormatException {
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
}