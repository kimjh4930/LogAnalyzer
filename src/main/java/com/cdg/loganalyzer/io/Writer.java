package com.cdg.loganalyzer.io;

import java.io.IOException;

public interface Writer extends AutoCloseable {

  void write(String contents) throws IOException;
}
