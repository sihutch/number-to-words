package com.si.sample;

import com.si.sample.util.Assert;
import com.si.sample.util.NumberUtils;
import com.si.sample.util.StringUtils;

/**
 * @author Simon Hutchinson Processor that can convert the numbers 1 to 19 to
 *         the corresponding word
 */
class UnitAndTeensConverter extends AbstractNumberToWordConverter {

    private static final int MIN_CONVERT_VALUE = 1;
    private static final int MAX_CONVERT_VALUE = 19;

    private static final String[] NUMBER_WORDS = { "one", "two", "three", "four", "five",
        "six", "seven", "eight", "nine", "ten",
        "eleven", "twelve", "thirteen", "forteen", "fifteen",
        "sixteen", "seventeen", "eighteen", "nineteen" };
    private static final int RIGHT_OFFSET = 2;

    /**
     * Convert the last 2 characters from the provided string to the
     * corresponding words between the values of one to nineteen.
     * 
     * For example give the String "9113" Return "thirteen"
     * 
     * @param number
     *            - The number string to process
     * @return The corresponding word for the string of numbers. Or if the
     *         string of numbers is outside of this range then return an empty
     *         string
     */
    @Override
    public String convert(final String number) {
        Assert.notNull(number);
        String text = "";
        final int num = StringUtils.stripInt(number, RIGHT_OFFSET);
        if (NumberUtils.isBetween(MIN_CONVERT_VALUE, MAX_CONVERT_VALUE, num)) {
            text = NUMBER_WORDS[num - 1];
        }
        return text;
    }
}