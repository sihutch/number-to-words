package com.si.sample;

public abstract class AbstractNumberToWordConverter implements NumberToWordConverter {

    public String convert(final long number) {
        return convert(Long.toString(number));
    }
}