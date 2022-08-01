package com.cdg.loganalyzer.io.file;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.cdg.loganalyzer.io.Writer;
import java.io.File;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FileWriterTest {

  private static final String FILE_NAME = "output.log";

  @DisplayName("output 파일을 만들 수 있다.")
  @Test
  void writeFile() {
    try (Writer writer = new FileWriter(FILE_NAME)) {
      writer.write("test");
    } catch (Exception e) {
      throw new RuntimeException();
    }

    assertTrue(new File(FILE_NAME).exists());
  }

  @AfterEach
  void removeFile() {
    File file = new File(FILE_NAME);

    if (file.exists()) {
      file.delete();
    }
  }
}