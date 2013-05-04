package com.si.sample;

public class MainParser {

  private static final String[] UNIT_WORDS = { "", "one", "two", "three", "four", "five",
    "six", "seven", "eight", "nine", "ten",
    "eleven", "twelve", "thirteen", "forteen", "fifteen",
    "sixteen", "seventeen", "eighteen", "nineteen" };
  private static final String ZERO = "zero";

  public String parse(int i) {
    if (i == 0) {
      return ZERO;
    }
    return null;
  }
}