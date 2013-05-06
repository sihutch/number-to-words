package com.si.sample;

import com.si.sample.util.Assert;
import com.si.sample.util.NumberUtils;
import com.si.sample.util.StringUtils;

/**
 * @author Simon Hutchinson Processor that can convert the numbers 1 to 19 to
 *         the corresponding word
 */
public class UnitAndTeensConverter extends AbstractNumberToWordConverter {

    private static final String[] NUMBER_WORDS = { "one", "two", "three", "four", "five",
        "six", "seven", "eight", "nine", "ten",
        "eleven", "twelve", "thirteen", "forteen", "fifteen",
        "sixteen", "seventeen", "eighteen", "nineteen" };
    private static final int RIGHT_OFFSET = 3;


    /**
     * Convert the last 1 to 3 (to allow for a leading zero) characters from the
     * provided string to the corresponding words between the values of one to
     * nineteen.
     * 
     * For example give the String "9013" Return "thirteen"
     * 
     * @param number
     *            - The number string to process
     * @return The If the string of numbers is outside of this range then return
     *         an empty string
     * @throws IllegalArgumentException
     *             If {@code number} is is null or if the last 1 to 3 characters
     *             cannot be converted to an integer value
     */
    @Override
    public String convert(final String number) {
        Assert.notNull(number);
        String text = "";
        final int num = NumberUtils.keepDigits(StringUtils.stripInt(number, RIGHT_OFFSET), 2);
        if (NumberUtils.isBetween(1, 19, num)) {
            text = NUMBER_WORDS[num - 1];
        }
        return text;
    }
}