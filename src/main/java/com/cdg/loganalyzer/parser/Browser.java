package com.cdg.loganalyzer.parser;

public enum Browser {
  IE("IE"),
  FIREFOX("Firefox"),
  SAFARI("Safari"),
  CHROME("Chrome"),
  OPERA("Opera");

  String browserName;

  Browser(String browserName) {
    this.browserName = browserName;
  }
}
