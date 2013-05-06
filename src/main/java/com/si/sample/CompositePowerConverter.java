package com.si.sample;

import static org.junit.Assert.assertNotNull;

import com.si.sample.util.StringUtils;

class CompositePowerConverter extends AbstractNumberToWordConverter {

    private NumberToWordConverter converter;
    private final NumberToWordConverter hundredsConverter;
    private final Magnitude magnitude;

    CompositePowerConverter(final Magnitude magnitude) {
        hundredsConverter = new HundredsConverter();
        this.magnitude = magnitude;
        if (magnitude.getPowerOfTen() < Magnitude.THOUSAND.getPowerOfTen()) {
            converter = new HundredsConverter();
        } else {
            converter = new CompositePowerConverter(magnitude.subtract(Magnitude.THOUSAND));
        }
    }

    @Override
    public String convert(final String number) {
        assertNotNull(number);
        final StringBuilder sb = new StringBuilder();

        // TODO Change these method names
        final String mag, rest;
        if (magnitude.getPowerOfTen() < number.length()) {
            final int index = number.length() - magnitude.getPowerOfTen();
            mag = number.substring(0, index);
            rest = number.substring(index);
        } else {
            mag = EMPTY;
            rest = number;
        }

        final String magnitudeValue = hundredsConverter.convert(mag);
        final String remainingValue = converter.convert(rest);

        if (StringUtils.notEmpty(magnitudeValue)) {
            sb.append(magnitudeValue);
            if (magnitude.isGreaterThan(Magnitude.TEN)) {
                sb.append(SEPARATOR);
                sb.append(magnitude.getName());
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