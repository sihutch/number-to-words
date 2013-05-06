package com.si.sample;

import static org.junit.Assert.assertNotNull;

import com.si.sample.util.StringUtils;

public class CompositePowerConverter extends AbstractNumberToWordConverter {

    private static final int THOUSAND_POWER = 3;
    private NumberToWordConverter converter;
    private final NumberToWordConverter hundredsConverter;
    private int power;

    public CompositePowerConverter(final int power) {
        hundredsConverter = new HundredsConverter();
        if (power < THOUSAND_POWER) {
            converter = new HundredsConverter();
        } else {
            converter = new CompositePowerConverter(power - 3);
            this.power = power;
        }
    }

    @Override
    public String convert(final String number) throws NumberFormatException {
        assertNotNull(number);
        final StringBuilder sb = new StringBuilder();

        final String magnitude, rest;
        if (power < number.length()) {
            final int index = number.length() - power;
            magnitude = number.substring(0, index);
            rest = number.substring(index);
        } else {
            magnitude = EMPTY;
            rest = number;
        }

        final String magnitudeValue = hundredsConverter.convert(magnitude);
        final String remainingValue = converter.convert(rest);

        if (StringUtils.notEmpty(magnitudeValue)) {
            sb.append(magnitudeValue);
            final String magnitudeName = Magnitude.getName(power);
            if (magnitudeName != null) {
                sb.append(SEPARATOR);
                sb.append(Magnitude.getName(power));
            }
            if (StringUtils.notEmpty(remainingValue)) {
                sb.append(SEPARATOR);
            }
        }

        if (StringUtils.notEmpty(remainingValue)) {
            sb.append(remainingValue);
        }

        return sb.toString();
    }
}