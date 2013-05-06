package com.si.sample.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.si.sample.util.StringUtils;

public class StringUtilsTest {

    @Test
    public void testStrip() {
        final int expectedInt = 1;
        final String numberString = ("001");
        assertEquals(1, StringUtils.stripInt(numberString, 3));
    }
}