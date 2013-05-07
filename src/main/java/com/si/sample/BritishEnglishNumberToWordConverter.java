package com.si.sample;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import com.si.sample.util.Assert;
import com.si.sample.util.Constants;
import com.si.sample.util.StringUtils;

/**
 * Convert a number in the range -999,999,999 to 999,999,999 to the equivalent
 * British English words. Decimal values are not supported are simply ignored if
 * provided i.e the String 10.99 is simply treated as 10
 * 
 * @author Simon Hutchinson
 * 
 */
public class BritishEnglishNumberToWordConverter extends AbstractNumberToWordConverter {

    private final NumberToWordConverter magnitudeConverter = new MagnitudeConverter(
        Magnitude.MILLION);

    @Override
    public String convert(final String number) throws ParseException {
        Assert.notNull(number);
        String numberToConvert;
        boolean isNegative = false;
        if (number.startsWith(Constants.MINUS_SIGN)) {
            numberToConvert = number.substring(1);
            isNegative = true;
        } else {
            numberToConvert = number;
        }
        final NumberFormat numberFormat = NumberFormat.getInstance(Locale.UK);
        final Number parsedNumber = numberFormat.parse(numberToConvert);
        // take the floor as we are ignoring the decimal
        final long flooredNumer = (long)Math.floor(parsedNumber.doubleValue());
        final String converted = magnitudeConverter.convert(flooredNumer);
        if (StringUtils.empty(converted)) {
            return Constants.ZERO;
        } else {
            return isNegative ? Constants.MINUS + " " + converted : converted;
        }
    }
}