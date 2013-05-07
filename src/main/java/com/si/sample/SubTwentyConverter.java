package com.si.sample;

import com.si.sample.util.Assert;
import com.si.sample.util.NumberUtils;
import com.si.sample.util.StringUtils;

/**
 * @author Simon Hutchinson Processor that can convert the numbers 1 to 19 to
 *         the corresponding word
 */
class SubTwentyConverter extends AbstractNumberToWordConverter {

    public static final int MIN_CONVERT_VALUE = 1;
    public static final int MAX_CONVERT_VALUE = 19;

    private static final String[] NUMBER_WORDS = { "one", "two", "three", "four", "five",
        "six", "seven", "eight", "nine", "ten",
        "eleven", "twelve", "thirteen", "forteen", "fifteen",
        "sixteen", "seventeen", "eighteen", "nineteen" };

    /**
     * The maximum string of digits to attempt to strip from the right of the
     * provided string
     */
    private static final int RIGHT_OFFSET = 2;

    /**
     * Convert the last 1-2 digits from the provided string to the corresponding
     * words between the values of 1 to 19.
     * 
     * For example given the String "9113" Return "thirteen"
     * 
     * @param number
     *            - The string of digits to process
     * @return The corresponding word(s) for the string of digits. Or if the
     *         numbers are outside of the range 1-19 then return an empty string
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