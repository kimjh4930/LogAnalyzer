package com.cdg.loganalyzer.parser.extractor;

import static org.assertj.core.api.Assertions.assertThat;

import com.cdg.loganalyzer.parser.Extractor;
import com.cdg.loganalyzer.parser.HttpStatus;
import com.cdg.loganalyzer.parser.extractor.HttpStatusExtractor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HttpStatusExtractorTest {

  private Extractor<HttpStatus> extractor = new HttpStatusExtractor();

  @DisplayName("상태코드 '10' 을 가져올 수 있다.")
  @Test
  void extractFail() {
    //given
    String line = "[10][http://apis.daum.net/search/news?q=daum][IE][2009-06-10 08:01:37]";

    //when
    HttpStatus httpStatus = extractor.extract(line);

    //then
    assertThat(HttpStatus.WRONG).isEqualTo(httpStatus);
  }

  @DisplayName("상태코드 '200' 을 가져올 수 있다.")
  @Test
  void extractSuccess() {
    //given
    String line = "[200][http://apis.daum.net/search/knowledge?apikey=23jf&q=daum][IE][2009-06-10 08:00:00]";

    //when
    HttpStatus httpStatus = extractor.extract(line);

    //then
    assertThat(HttpStatus.SUCCESS).isEqualTo(httpStatus);
  }


  @DisplayName("상태코드 '404' 을 가져올 수 있다.")
  @Test
  void extractNotFound() {
    //given
    String line = "[404][http://apis.daum.net/search/aaaaapikey=e3ea&q=daum][IE][2009-06-10 08:01:07]";

    //when
    HttpStatus httpStatus = extractor.extract(line);

    //then
    assertThat(HttpStatus.NOT_FOUND).isEqualTo(httpStatus);
  }
}