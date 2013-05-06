package com.si.sample;

import org.junit.Test;

public class PowerConverterTest {

    @Test
    public void testConvert() {
        final NumberToWordConverter powerConverter = new PowerConverter(6);
        TestHelper.convertHundreds(powerConverter);
        TestHelper.convertTens(powerConverter);
        TestHelper.convertUnits(powerConverter);
    }
}