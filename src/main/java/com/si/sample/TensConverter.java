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
public class TensConverter implements NumberToWordConverter {

    private final NumberToWordConverter unitAndTeensConverter = new UnitAndTeensConverter();

    private static final String[] NUMBER_WORDS = {
        "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    private static final int RIGHT_OFFSET = 3;

    @Override
    public String convert(final String number) throws NumberFormatException {
        Assert.notNull(number);
        String text = "";
        final int num = StringUtils.stripInt(number, RIGHT_OFFSET);
        if (NumberUtils.isBetween(1, 19, num)) {
            text = NUMBER_WORDS[num - 1];
        }
        return text;
    }
}