package com.si.sample;

import static org.junit.Assert.assertNotNull;

import com.si.sample.util.StringUtils;

public class PowerConverter extends AbstractNumberToWordConverter {

    private NumberToWordConverter converter;
    private final NumberToWordConverter hundredsConverter;
    private int power;

    public PowerConverter(final int power) {
        hundredsConverter = new HundredsConverter();
        if (power < 3) {
            converter = new HundredsConverter();
        } else {
            converter = new PowerConverter(power - 3);
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
            magnitude = "";
            rest = number;
        }

        final String magnitudeValue = hundredsConverter.convert(magnitude);
        final String restValue = converter.convert(rest);

        if (StringUtils.notEmpty(magnitudeValue)) {
            sb.append(magnitudeValue);
            final String magnitudeName = Magnitude.getName(power);
            if (magnitudeName != null) {
                sb.append(" ");
                sb.append(Magnitude.getName(power));
            }
        }

        if (StringUtils.notEmpty(restValue)) {
            sb.append(restValue);
        }

        return sb.toString();
    }
}