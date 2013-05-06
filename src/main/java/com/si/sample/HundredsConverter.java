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

    private static final String HUNDRED = Magnitude.getName(2);
    /**
     * Basic conjunction string constant
     */
    public static final String CONJUNCTION_AND = " and ";

    /**
     * The offset to use when stripping int value from the right of the provided
     * number string
     */
    private static final int RIGHT_OFFSET = 3;

    private final NumberToWordConverter tensConverter = new TensConverter();
    private final NumberToWordConverter unitAndTeensConverter = new UnitAndTeensConverter();

    // TODO: Add java doc
    @Override
    public String convert(final String number) throws NumberFormatException {
        Assert.notNull(number);
        final StringBuffer sb = new StringBuffer();
        final int num = StringUtils.empty(number) ? 0 : StringUtils.stripInt(number, RIGHT_OFFSET);

        if (num >= 100) {
            sb.append(unitAndTeensConverter.convert(num / 100));
            sb.append(SEPARATOR);
            sb.append(HUNDRED);
        }

        final String tens = tensConverter.convert(num % 100);
        if (StringUtils.notEmpty(tens) && num >= 100) {
            sb.append(CONJUNCTION_AND);
        }
        sb.append(tens);
        return sb.toString();
    }
}