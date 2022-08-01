package com.cdg.loganalyzer.io.file;

import static org.assertj.core.api.Assertions.assertThat;

import com.cdg.loganalyzer.io.Reader;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FileReaderTest {

  private static final String FILE_NAME = "input.log";

  @DisplayName("input.text 파일을 읽을 수 있다.")
  @Test
  void readFile() {
    try (Reader reader = new FileReader(FILE_NAME)) {
      List<String> readLine = reader.readLine(10, 0);

      readLine.forEach(System.out::println);

      assertThat(readLine.size()).isEqualTo(10);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}