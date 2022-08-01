package com.cdg.loganalyzer.io;

import java.io.IOException;
import java.util.List;

public interface Reader extends AutoCloseable {

  List<String> readLine(int lineNumber, int offset) throws IOException;

}
