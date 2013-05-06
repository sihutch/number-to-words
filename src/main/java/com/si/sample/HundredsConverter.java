package com.si.sample;

import com.si.sample.util.Assert;
import com.si.sample.util.StringUtils;

/**
 * @author Simon Hutchinson
 * 
 *         Processor that can convert the numbers from 1 through 999 to the
 *         corresponding words
 */
public class HundredsConverter extends AbstractNumberToWordConverter {

    private final NumberToWordConverter tensConverter = new TensConverter();
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
        final int num = StringUtils.empty(number) ? 0 : StringUtils.stripInt(number, RIGHT_OFFSET);

        if (num >= 100) {
            sb.append(unitAndTeensConverter.convert(num / 100));
            sb.append(" ");
            sb.append(Magnitude.getName(2));
        }

        final String tens = tensConverter.convert(num % 100);
        if (StringUtils.notEmpty(tens) && num >= 100) {
            sb.append(CONJUNCTION_AND);
        }
        sb.append(tens);
        return sb.toString();
    }
}