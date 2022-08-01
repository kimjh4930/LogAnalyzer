package com.cdg.loganalyzer.parser.extractor;

import com.cdg.loganalyzer.parser.Browser;
import com.cdg.loganalyzer.parser.Extractor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BrowserExtractor implements Extractor<Browser> {

  private static final Pattern browserPattern = Pattern.compile("IE|Firefox|Safari|Chrome|Opera");

  @Override
  public Browser extract(String phase) {
    Matcher matcher = browserPattern.matcher(phase);

    if (!matcher.find()) {
      return null;
    }

    return Browser.valueOf(matcher.group().toUpperCase());
  }
}
