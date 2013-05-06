package com.si.sample;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Simon Hutchinson
 * 
 *         Used to translate powers of ten into their respective words
 */
public enum Magnitude {
    /**
     * Represents 10^0
     */
    ONE(0),
    /**
     * Represents 10^1
     */
    TEN(1),
    /**
     * Represents 10^2
     */
    HUNDRED(2),
    /**
     * Represents 10^3
     */
    THOUSAND(3),
    /**
     * Represents 10^6
     */
    MILLION(6);

    private int power;

    private static final Map<Integer, Magnitude> POWER_TO_MAGNITUDE;
    static {
        final Map<Integer, Magnitude> map = new HashMap<Integer, Magnitude>(
            Magnitude.values().length);
        for (final Magnitude magnitude: Magnitude.values()) {
            map.put(magnitude.getPowerOfTen(), magnitude);
        }
        POWER_TO_MAGNITUDE = Collections.unmodifiableMap(map);
    }

    private Magnitude(final int power) {
        this.power = power;
    }

    /**
     * @return The lowercase name of the magnitude (in English)
     */
    public String getName() {
        return this.name().toLowerCase();
    }

    /**
     * @return the magnitude as a power of 10
     */
    public int getPowerOfTen() {
        return this.power;
    }

    /**
     * Get the {@link Magnitude} for the given power of 10
     * 
     * @param powerOfTen
     *            The power of 10
     * @return The {@link Magnitude} or null if there is no {@link Magnitude}
     *         for the given {@code power}
     */
    public Magnitude fromPowerOfTen(final int powerOfTen) {
        return POWER_TO_MAGNITUDE.get(power);
    }

    /**
     * Subtract the provided magnitude power of 10 from this
     * 
     * @param magnitude
     *            The {@link Magnitude} to subtract
     * @return The Magnitude matching the new power of 10 after subtraction or
     *         null if no such Magtinute exists
     */
    public Magnitude subtract(final Magnitude magnitude) {
        return POWER_TO_MAGNITUDE.get(this.power - magnitude.getPowerOfTen());
    }

    /**
     * @param magnitude
     *            The {@link Magnitude} to compare with this
     * @return true if this {@link Magnitude} is greater then the given
     *         {@link Magnitude}
     */
    public boolean isGreaterThan(final Magnitude magnitude) {
        return getPowerOfTen() > magnitude.getPowerOfTen();
    }
}