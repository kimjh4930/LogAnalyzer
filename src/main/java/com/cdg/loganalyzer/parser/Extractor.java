package com.cdg.loganalyzer.parser;

public interface Extractor<T> {

  T extract(String phase);

}
