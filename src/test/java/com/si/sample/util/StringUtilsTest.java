package com.si.sample.util;

import static org.junit.Assert.*;
import org.junit.Test;

import com.si.sample.util.StringUtils;

public class StringUtilsTest {

    @Test
    public void testStrip() {
        final int expectedInt = 1;
        final String numberString = ("001");
        assertEquals(1, StringUtils.stripInt(numberString, 3));
    }

    @Test
    public void testEmpty() {
        assertTrue(StringUtils.empty(null));
        assertTrue(StringUtils.empty(""));
        assertTrue(StringUtils.empty("     "));
        assertFalse(StringUtils.empty("   a  "));
    }

    @Test
    public void testNotEmptyString() {
        assertFalse(StringUtils.notEmpty(null));
        assertFalse(StringUtils.notEmpty(""));
        assertFalse(StringUtils.notEmpty("     "));
        assertTrue(StringUtils.notEmpty("   a  "));
    }
}