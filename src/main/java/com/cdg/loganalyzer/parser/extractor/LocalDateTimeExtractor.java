package com.cdg.loganalyzer.parser.extractor;

import com.cdg.loganalyzer.parser.Extractor;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LocalDateTimeExtractor implements Extractor<LocalDateTime> {

  private final static Pattern localDateTimePattern = Pattern.compile(
    "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");

  @Override
  public LocalDateTime extract(String phase) {
    Matcher matcher = localDateTimePattern.matcher(phase);

    if (!matcher.find()) {
      return null;
    }

    return LocalDateTime.parse(matcher.group(),
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
  }
}
