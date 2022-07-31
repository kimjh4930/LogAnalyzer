package com.cdg.loganalyzer.parser.extractor;

import com.cdg.loganalyzer.parser.Extractor;
import java.time.LocalDateTime;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LocalDateTimeExtractorTest {

  private final Extractor<LocalDateTime> extractor = new LocalDateTimeExtractor();

  @DisplayName("LocalDateTime 을 추출한다.")
  @ValueSource(
    strings = {
      "[200][http://apis.daum.net/search/knowledge?apikey=fwji&q=daum][IE][2009-06-10 08:06:15]"
    })
  @ParameterizedTest
  void extractLocalDateTime(String log) {
    //given
    LocalDateTime expected = LocalDateTime.of(2009, 06, 10, 8, 06, 15);

    //when
    LocalDateTime extracted = extractor.extract(log);

    //then
    Assertions.assertThat(extracted).isEqualTo(expected);
  }
}