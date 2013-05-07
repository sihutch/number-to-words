package com.si.sample;

import java.io.PrintStream;
import java.text.ParseException;

/**
 * @author Simon Hutchinson
 */
public final class Main {

    private static final String HELP_TEXT = "Run program with a single number between -999,999,999 and 999,999,999";

    private Main() {

    }

    public static void main(final String[] args) {
        if (args.length == 0) {
            print(System.out, HELP_TEXT);
            System.exit(1);
        }
        final NumberToWordConverter converter = new BritishEnglishNumberToWordConverter();
        try {
            print(System.out, converter.convert(args[0]));
        } catch (final ParseException e) {
            print(System.err, "Supplied argument is invalid:" + args[0] + "\n");
            print(System.err, HELP_TEXT);
        }
    }

    private static void print(final PrintStream stream, final String test) {
        stream.println(test);
    }
}