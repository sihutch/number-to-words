package com.si.sample;

import com.si.sample.util.Assert;
import com.si.sample.util.StringUtils;

/**
 * @author Simon Hutchinson
 * 
 *         Processor that can convert the numbers from 1 through 999 to the
 *         corresponding words
 */
class HundredsConverter extends AbstractNumberToWordConverter {

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
    public String convert(final String number) {
        Assert.notNull(number);
        final StringBuffer sb = new StringBuffer();
        final int num = StringUtils.empty(number) ? 0 : StringUtils.stripInt(number, RIGHT_OFFSET);

        if (num >= Magnitude.HUNDRED.getValue()) {
            sb.append(unitAndTeensConverter.convert(num / Magnitude.HUNDRED.getValue()));
            sb.append(SEPARATOR);
            sb.append(Magnitude.HUNDRED.getName());
        }

        final String tens = tensConverter.convert(num % Magnitude.HUNDRED.getValue());
        if (StringUtils.notEmpty(tens) && num >= Magnitude.HUNDRED.getValue()) {
            sb.append(CONJUNCTION_AND);
        }
        sb.append(tens);
        return sb.toString();
    }
}