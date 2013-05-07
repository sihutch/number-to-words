package com.si.sample;

import java.text.ParseException;

/**
 * @author Simon Hutchinson
 * 
 *         A converter that will convert a number to its equivalent in words
 * 
 */
public interface NumberToWordConverter {

    /**
     * Convert the supplied string of digits to its corresponding words
     * 
     * @param number
     *            The string of digits to convert
     * @return The number converted to words
     * @throws ParseException
     */
    String convert(String number) throws ParseException;

    /**
     * Convert the supplied {@code number} to its corresponding words
     * 
     * @param number
     *            The long to convert
     * @return The long converted to words
     */
    String convert(long number);
}