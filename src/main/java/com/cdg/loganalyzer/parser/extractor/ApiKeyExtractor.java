package com.cdg.loganalyzer.parser.extractor;

import com.cdg.loganalyzer.parser.Extractor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApiKeyExtractor implements Extractor<String> {

  private static final Pattern apiKeyPattern = Pattern.compile("apikey=.+&");

  @Override
  public String extract(String phase) {
    System.out.println("phase : " + phase);
    Matcher matcher = apiKeyPattern.matcher(phase);

    if (!matcher.find()) {
      return null;
    }

    return matcher.group()
      .replace("apikey=","")
      .replace("&", "");
  }
}
