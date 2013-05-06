package com.si.sample;

/**
 * @author Simon Hutchinson
 * 
 *         Base class for building number converters.
 * 
 */
public abstract class AbstractNumberToWordConverter implements NumberToWordConverter {

    /**
     * Zero length string
     */
    public static final String EMPTY = "";
    /**
     * String with a single space character
     */
    public static final String SEPARATOR = " ";

    /**
     * Convert the provide {@code number to a String} and then delegate to the
     * subclass implementation of {@link NumberToWordConverter#convert(String)}
     */
    @Override
    public String convert(final long number) {
        return convert(Long.toString(number));
    }
}