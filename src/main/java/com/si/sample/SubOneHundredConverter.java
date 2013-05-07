package com.si.sample;

import com.si.sample.util.Assert;
import com.si.sample.util.Constants;
import com.si.sample.util.NumberUtils;
import com.si.sample.util.StringUtils;

/**
 * @author Simon Hutchinson
 * 
 *         Convert the numbers from 1 through 99 to the corresponding words
 */
class SubOneHundredConverter extends AbstractNumberToWordConverter {

    private static final int MIN_CONVERT_VALUE = 20;

    /**
     * The maximum string of digits to attempt to strip from the rigt of the
     * provided string
     */
    private static final int RIGHT_OFFSET = 2;

    private final NumberToWordConverter subTwentyConverter = new SubTwentyConverter();

    private static final String[] TENS_WORDS = {
        "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    /**
     * Convert the last 2 characters from the provided string to the
     * corresponding words between the values of 1 to 99.
     * 
     * For example given the String "9199" Return "ninety nine"
     * 
     * @param number
     *            - The string of digits to process
     * @return The corresponding word(s) for the string of digits. Or if the
     *         characters are all zero then return the empty string
     */
    @Override
    public String convert(final String number) {
        Assert.notNull(number);
        final StringBuffer sb = new StringBuffer();
        int num = StringUtils.stripInt(number, RIGHT_OFFSET);
        if (num >= MIN_CONVERT_VALUE) {
            sb.append(TENS_WORDS[calculateIndexPosition(num)]);
            // Keep a single digit for the unit converter
            num = NumberUtils.keepDigits(num, 1);
        } else {
            num %= MIN_CONVERT_VALUE;
        }
        if (num != 0) {
            convertUnits(sb, num);
        }
        return sb.toString();
    }

    private int calculateIndexPosition(final int num) {
        return (num / 10) - 2;
    }

    private void convertUnits(final StringBuffer sb, final int num) {
        if (sb.length() > 0) {
            sb.append(Constants.SEPARATOR);
        }
        sb.append(subTwentyConverter.convert(num));
    }
}