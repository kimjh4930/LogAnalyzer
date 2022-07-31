package com.cdg.loganalyzer.parser.extractor;

import static org.assertj.core.api.Assertions.assertThat;

import com.cdg.loganalyzer.parser.Browser;
import com.cdg.loganalyzer.parser.Extractor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BrowserExtractorTest {

  private Extractor<Browser> browserExtractor = new BrowserExtractor();

  @DisplayName("브라우저를 추출할 수 있다.")
  @ParameterizedTest
  @CsvSource(
    value = {
      "IE,[200][http://apis.daum.net/search/vclip?apikey=fwji&q=daum][IE][2009-06-10 08:00:10]",
      "Firefox,[200][http://apis.daum.net/search/news?apikey=23jf&q=daum][Firefox][2009-06-10 08:00:11]",
      "Opera,[200][http://apis.daum.net/search/news?apikey=fwji&q=daum][Opera][2009-06-10 08:00:13]",
      "Chrome,[200][http://apis.daum.net/search/image?apikey=2jdc&q=daum][Chrome][2009-06-10 08:03:16]",
      "Safari,[200][http://apis.daum.net/search/vclip?apikey=23jf&q=daum][Safari][2009-06-10 08:03:22]"
    },
    delimiter = ','
  )
  void extractBrowser(String browser, String log) {
    //given

    //when
    Browser extractedBrowser = browserExtractor.extract(log);
    System.out.println("test : " + Browser.valueOf(browser.toUpperCase()));

    //then
    assertThat(extractedBrowser).isEqualTo(Browser.valueOf(browser.toUpperCase()));
  }

}