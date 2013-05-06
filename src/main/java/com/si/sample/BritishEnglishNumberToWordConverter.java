package com.si.sample;

import com.si.sample.util.StringUtils;

/**
 * @author Simon Hutchinson
 * 
 */
public class BritishEnglishNumberToWordConverter extends AbstractNumberToWordConverter {

    private final NumberToWordConverter compositePowerConverter = new CompositePowerConverter(
        Magnitude.MILLION);

    @Override
    public String convert(final String number) {
        final String converted = compositePowerConverter.convert(number);
        return StringUtils.empty(converted) ? ZERO : converted;
    }
}