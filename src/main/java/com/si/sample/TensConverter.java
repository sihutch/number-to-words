package com.si.sample;

import com.si.sample.util.Assert;
import com.si.sample.util.NumberUtils;
import com.si.sample.util.StringUtils;

/**
 * @author Simon Hutchinson
 * 
 *         Processor that can convert the numbers from 1 through 99 to the
 *         corresponding words
 */
class TensConverter extends AbstractNumberToWordConverter {

    private static final int MIN_CONVERT_VALUE = 20;
    private static final int RIGHT_OFFSET = 2;

    private final NumberToWordConverter unitAndTeensConverter = new UnitAndTeensConverter();

    private static final String[] NUMBER_WORDS = {
        "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };


    @Override
    public String convert(final String number) {
        Assert.notNull(number);
        final StringBuffer sb = new StringBuffer();
        int num = StringUtils.stripInt(number, RIGHT_OFFSET);
        if (num >= MIN_CONVERT_VALUE) {
            sb.append(NUMBER_WORDS[calculateIndexPosition(num)]);
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
            sb.append(SEPARATOR);
        }
        sb.append(unitAndTeensConverter.convert(num));
    }
}