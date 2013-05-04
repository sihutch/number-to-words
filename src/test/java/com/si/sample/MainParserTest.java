package com.si.sample;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MainParserTest {
  MainParser parser;

  @Before
  public void setup() {
    parser = new MainParser();
  }

  @Test
  public void parseZero() {
    assertEquals("zero", parser.parse(0));
  }
}