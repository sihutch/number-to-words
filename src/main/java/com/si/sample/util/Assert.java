package com.si.sample.util;

/**
 * @author Simon Hutchinson Utility class for testing preconditions
 */
public final class Assert {

    private Assert() {
    }

    /**
     * Assert that the provided {@code value} is not null
     * 
     * @param value
     *            The value to test
     * @throws IllegalArgumentException
     *             if {@code value} is null
     */
    public static final void notNull(final Object value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
    }

    /**
     * Assert that the provided {@code value} if greater then the supplied
     * {@code minimum}
     * 
     * @param floor
     *            The number that {@value} must be greater than
     * @param value
     *            The number to test
     * 
     * @throws IllegalArgumentException
     *             if {@code value} is less that or equal {@code floor}
     */
    public static void greaterThan(final int floor, final int value) {
        if (value <= floor) {
            throw new IllegalArgumentException("value must be greater than " + floor);
        }
    }
}