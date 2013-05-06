package com.si.sample;

/**
 * @author Simon Hutchinson
 * 
 *         A converter that will convert a number to its equivalent in words
 * 
 *         For example, given the string "101" the processor will return
 *         "one hundred and one"
 * 
 */
public interface NumberToWordConverter {

    /**
     * Convert the supplied {@code number} string to its corresponding words
     * 
     * @param number
     *            The number string to convert
     * @return The number converted to words
     */
    String convert(String number);

    /**
     * Convert the supplied {@code number} string to its corresponding words
     * 
     * @param number
     *            The number to convert
     * @return The number converted to words
     */
    String convert(long number);
}