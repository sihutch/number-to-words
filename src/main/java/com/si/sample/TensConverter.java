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
public class TensConverter extends AbstractNumberToWordConverter {

    private final NumberToWordConverter unitAndTeensConverter = new UnitAndTeensConverter();
    public static final String CONJUNCTION_AND = " and ";

    private static final String[] NUMBER_WORDS = {
        "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    private static final int RIGHT_OFFSET = 3;

    @Override
    public String convert(final String number) throws NumberFormatException {
        Assert.notNull(number);
        final StringBuffer sb = new StringBuffer();
        int num = NumberUtils.keepDigits(StringUtils.stripInt(number, RIGHT_OFFSET), 2);
        if (num >= 20) {
            sb.append(NUMBER_WORDS[((num / 10) - 2)]);
            // Keep a single digit for the unit converter
            num = NumberUtils.keepDigits(num, 1);
        } else {
            num %= 20;
        }
        if (num != 0) {
            convertUnits(sb, num);
        }
        return sb.toString();
    }

    private void convertUnits(final StringBuffer sb, final int num) {
        if (sb.length() > 0) {
            sb.append(" ");
        }
        sb.append(unitAndTeensConverter.convert(num));
    }
}