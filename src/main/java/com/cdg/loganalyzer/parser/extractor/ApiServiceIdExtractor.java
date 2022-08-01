package com.cdg.loganalyzer.parser.extractor;

import com.cdg.loganalyzer.parser.Extractor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApiServiceIdExtractor implements Extractor<String> {
  private static final Pattern apiServiceIdPattern = Pattern.compile("\\/search\\/.+\\?");

  @Override
  public String extract(String phase) {
    Matcher matcher = apiServiceIdPattern.matcher(phase);

    if(!matcher.find()) {
      return null;
    }

    System.out.println("matcher : " + matcher.group());

    return matcher.group()
      .replace("/search/", "")
      .replace("?", "");
  }
}
