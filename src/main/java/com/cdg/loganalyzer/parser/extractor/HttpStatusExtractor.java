package com.cdg.loganalyzer.parser.extractor;

import com.cdg.loganalyzer.parser.Extractor;
import com.cdg.loganalyzer.parser.HttpStatus;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

public class HttpStatusExtractor implements Extractor<HttpStatus> {

  private static final Pattern httpStatusPattern = Pattern.compile("\\[[\\d]{2,3}\\]");

  @Override
  public HttpStatus extract(String phase) {
    Matcher matcher = httpStatusPattern.matcher(phase);

    if (!matcher.find()) {
      return null;
    }

    return HttpStatus.valueOf(
      Integer.valueOf(StringUtils.substringBetween(matcher.group(), "[", "]")));
  }
}
