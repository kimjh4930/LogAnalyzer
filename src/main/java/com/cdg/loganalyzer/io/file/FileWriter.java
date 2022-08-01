package com.cdg.loganalyzer.io.file;

import com.cdg.loganalyzer.io.Writer;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriter implements Writer {

  private final String fileName;
  private BufferedWriter writer;

  public FileWriter(String fileName) {
    this.fileName = fileName;
  }

  public void write(String contents) throws IOException {
    open();

    writer.write(contents);
    writer.flush();
  }

  private void open() throws IOException {
    if(writer == null) {
      writer = new BufferedWriter(new java.io.FileWriter(fileName));
    }
  }

  @Override
  public void close() throws Exception {
    writer.close();
  }
}
