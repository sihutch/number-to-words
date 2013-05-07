package com.si.sample;

import com.si.sample.util.Assert;
import com.si.sample.util.Constants;
import com.si.sample.util.StringUtils;

/**
 * @author Simon Hutchinson
 * 
 *         Processor that can convert the numbers from 1 through 999 to the
 *         corresponding words
 */
class SubOneThousandConverter extends AbstractNumberToWordConverter {

    /**
     * Basic conjunction string constant
     */
    public static final String CONJUNCTION_AND = " and ";

    /**
     * The maximum string of digits to attempt to strip from the right of the
     * provided string
     */
    private static final int RIGHT_OFFSET = 3;

    private final NumberToWordConverter subOneHundredConverter = new SubOneHundredConverter();
    private final NumberToWordConverter subTwentyConverter = new SubTwentyConverter();

    /**
     * Convert the last 1-3 characters from the provided string to the
     * corresponding words between the values of 1 to 999.
     * 
     * For example given the String "9113" Return "one hundred and thirteen"
     * 
     * @param number
     *            - The string of digits to process
     * @return The corresponding word(s) for the string of digits Or if the
     *         characters are all zero then return the empty string
     */
    @Override
    public String convert(final String number) {
        Assert.notNull(number);
        final StringBuffer sb = new StringBuffer();
        final int num = StringUtils.empty(number) ? 0 : StringUtils.stripInt(number, RIGHT_OFFSET);

        // Calculate the hundreds
        if (num >= Magnitude.HUNDRED.getValue()) {
            sb.append(subTwentyConverter.convert(num / Magnitude.HUNDRED.getValue()));
            sb.append(Constants.SEPARATOR);
            sb.append(Magnitude.HUNDRED.getName());
        }

        // Calculate the tens and units
        final String subOneHundred = subOneHundredConverter.convert(num
            % Magnitude.HUNDRED.getValue());
        if (StringUtils.notEmpty(subOneHundred) && num >= Magnitude.HUNDRED.getValue()) {
            sb.append(CONJUNCTION_AND);
        }
        sb.append(subOneHundred);
        return sb.toString();
    }
}