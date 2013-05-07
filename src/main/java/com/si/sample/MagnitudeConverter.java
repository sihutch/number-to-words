package com.si.sample;

import java.text.ParseException;

import com.si.sample.util.Assert;
import com.si.sample.util.Constants;
import com.si.sample.util.StringUtils;

/**
 * @author Simon Hutchinson
 * 
 *         Number converter that can convert numbers to words up to a specified
 *         {@link Magnitude}
 * 
 */
class MagnitudeConverter extends AbstractNumberToWordConverter {

    private NumberToWordConverter converter;
    private final NumberToWordConverter subOneThousandConverter;
    private final Magnitude magnitude;

    /**
     * Construct a converter that can convert a string of numbers based on a
     * provided magnitude.
     * 
     * The maximum number that can be converted is 999 *
     * {@link Magnitude#getValue()}
     * 
     * @param magnitude
     *            The magnitude to limit the conversion
     */
    MagnitudeConverter(final Magnitude magnitude) {
        Assert.notNull(magnitude);
        subOneThousandConverter = new SubOneThousandConverter();
        this.magnitude = magnitude;
        if (magnitude.isLessThan(Magnitude.THOUSAND)) {
            converter = new SubOneThousandConverter();
        } else {
            // Recursively construct subtracting 10 ^ 3
            converter = new MagnitudeConverter(magnitude.subtract(Magnitude.THOUSAND));
        }
    }

    @Override
    public String convert(final String number) throws ParseException {
        Assert.notNull(number);
        final StringBuilder sb = new StringBuilder();

        final String magnitudeDigits, remainderDigits;
        if (magnitude.getPowerOfTen() < number.length()) {
            // Split the number into the digits representing the magnitude
            // and those remaining to the right
            final int index = number.length() - magnitude.getPowerOfTen();
            magnitudeDigits = number.substring(0, index);
            remainderDigits = number.substring(index);
        } else {
            magnitudeDigits = Constants.EMPTY;
            remainderDigits = number;
        }

        final String magnitudeConverted = subOneThousandConverter.convert(magnitudeDigits);
        final String remainderConverted = converter.convert(remainderDigits);

        appendValues(sb, magnitudeConverted, remainderConverted);

        return sb.toString();
    }

    private void appendValues(final StringBuilder sb, final String magnitudeConverted,
        final String remainderConverted) {
        if (StringUtils.notEmpty(magnitudeConverted)) {
            sb.append(magnitudeConverted);
            if (magnitude.isGreaterThan(Magnitude.TEN)) {
                sb.append(Constants.SEPARATOR);
                sb.append(magnitude.getName());
            }

            if (StringUtils.notEmpty(remainderConverted)) {
                sb.append(Constants.SEPARATOR);
            }
        }

        if (StringUtils.notEmpty(remainderConverted)) {
            sb.append(remainderConverted);
        }
    }
}