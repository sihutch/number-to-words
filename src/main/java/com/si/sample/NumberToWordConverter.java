package com.si.sample;

/**
 * @author si
 * 
 *         A converter that will convert a number string to its equivalent in
 *         words
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
     * @throws NumberFormatException
     *             If the supplied {@link String} cannot be converted to a
     *             number
     */
    String convert(String number) throws NumberFormatException;
}