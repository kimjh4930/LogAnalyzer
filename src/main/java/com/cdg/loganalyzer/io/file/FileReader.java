package com.cdg.loganalyzer.io.file;

import com.cdg.loganalyzer.io.Reader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader implements Reader {

  private final String fileName;
  private BufferedReader reader;

  public FileReader(String fileName) {
    this.fileName = fileName;
  }

  public List<String> readLine(int lineNumber, int offset) throws IOException {
    open();

    int index = offset;
    String line = "";
    List<String> readLines = new ArrayList<>();

    while (index < lineNumber && (line = reader.readLine()) != null) {
      readLines.add(line);
      ++index;
    }

    return readLines;
  }

  private void open() throws IOException {
    if(reader == null) {
      this.reader = new BufferedReader(new java.io.FileReader(fileName));
    }
  }

  @Override
  public void close() throws Exception {
    this.reader.close();
  }
}
