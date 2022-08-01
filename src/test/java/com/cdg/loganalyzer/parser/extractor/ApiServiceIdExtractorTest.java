package com.cdg.loganalyzer.parser.extractor;

import static org.assertj.core.api.Assertions.assertThat;

import com.cdg.loganalyzer.parser.Extractor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ApiServiceIdExtractorTest {

  private Extractor<String> extractor = new ApiServiceIdExtractor();

  @DisplayName("ApiServiceId를 추출할 수 있다.")
  @ParameterizedTest
  @CsvSource(value = {
    "news,[200][http://apis.daum.net/search/news?apikey=fwji&q=daum][Opera][2009-06-10 08:00:13]",
    "book,[200][http://apis.daum.net/search/book?apikey=fqwk&q=daum][IE][2009-06-10 08:00:14]",
    "knowledge,[200][http://apis.daum.net/search/knowledge?apikey=23jf&q=daum][IE][2009-06-10 08:00:21]",
    "image,[200][http://apis.daum.net/search/image?apikey=fwji&q=daum][IE][2009-06-10 08:00:24]",
    "vclip,[200][http://apis.daum.net/search/vclip?apikey=e3ea&q=daum][IE][2009-06-10 08:00:23]",
  }, delimiter = ',')
  void extractApiService(String apiServiceId, String log) {
    //given

    //when
    String extractedApiServiceId = extractor.extract(log);

    //then
    assertThat(extractedApiServiceId).isEqualTo(apiServiceId);
  }
}