package com.si.sample.util;

import static org.junit.Assert.fail;

import org.junit.Test;

public class AssertTest {

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionIfNullNull() {
        Assert.notNull(null);
    }

    @Test
    public void testNotNullOK() {
        try {
            Assert.notNull("");
        } catch (final IllegalArgumentException e) {
            fail();
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testErrorIfLessThanRequested() {
        Assert.greaterThan(1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testErrorIfEqual() {
        Assert.greaterThan(1, 1);
    }

    @Test
    public void testGreaterThan() {
        try {
            Assert.greaterThan(1, 2);
        } catch (final IllegalArgumentException e) {
            fail();
        }
    }
}