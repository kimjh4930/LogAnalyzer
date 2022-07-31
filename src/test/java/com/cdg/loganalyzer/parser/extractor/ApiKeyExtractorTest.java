package com.cdg.loganalyzer.parser.extractor;

import static org.assertj.core.api.Assertions.assertThat;

import com.cdg.loganalyzer.parser.Extractor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ApiKeyExtractorTest {

  private Extractor<String> extractor = new ApiKeyExtractor();

  @DisplayName("apiKey를 추출할 수 있다.")
  @ValueSource(strings = {
    "[200][http://apis.daum.net/search/news?apikey=fwji&q=daum][Opera][2009-06-10 08:00:13]",
    "[200][http://apis.daum.net/search/book?apikey=fqwk&q=daum][IE][2009-06-10 08:00:14]",
    "[200][http://apis.daum.net/search/knowledge?apikey=23jf&q=daum][IE][2009-06-10 08:00:21]",
    "[200][http://apis.daum.net/search/image?apikey=fwji&q=daum][IE][2009-06-10 08:00:24]",
    "[200][http://apis.daum.net/search/vclip?apikey=e3ea&q=daum][IE][2009-06-10 08:00:23]",
  })
  @ParameterizedTest
  void extractApiKey(String log) {
    //given

    //when
    String extractedApiKey = extractor.extract(log);

    //then
    assertThat(extractedApiKey.length()).isEqualTo(4);
  }
}