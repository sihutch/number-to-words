package com.si.sample;

import java.text.ParseException;

/**
 * @author Simon Hutchinson
 * 
 *         Base class for building number converters.
 * 
 */
public abstract class AbstractNumberToWordConverter implements NumberToWordConverter {

    /**
     * Convert the provide {@code number to a String} and then delegate to the
     * subclass implementation of {@link NumberToWordConverter#convert(String)}
     */
    @Override
    public String convert(final long number) {
        String converted = "";
        try {
            converted = convert(Long.toString(number));
        } catch (final ParseException ignored) {
            // Long can always be converted
        }
        return converted;
    }
}