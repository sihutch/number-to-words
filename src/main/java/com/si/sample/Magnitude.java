package com.si.sample;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Simon Hutchinson
 * 
 *         Used to translate powers of ten into their respective words
 */
public class Magnitude {

    private static final Map<Integer, String> magnitudes;
    static {
        final Map<Integer, String> map = new HashMap<>(3);
        map.put(2, "hundred");
        map.put(3, "thousand");
        map.put(6, "million");
        magnitudes = Collections.unmodifiableMap(map);
    }

    /**
     * Get the name (in english) of a power of ten
     * 
     * @param power
     *            The power of ten
     * @return The name or null if no mapping exists for that power
     */
    public static String getName(final int power) {
        return magnitudes.get(power);
    }

    public static Set<Integer> getPowers() {
        return magnitudes.keySet();
    }
}