package com.cdg.loganalyzer.parser;

import java.util.Arrays;

public enum HttpStatus {
  WRONG(10, "Wrong Parameter"),
  SUCCESS(200, "Success"),
  NOT_FOUND(404, "Not Found");

  private static final HttpStatus[] VALUES = values();

  int statusCode;
  String statusMessage;

  HttpStatus(int statusCode, String statusMessage) {
    this.statusCode = statusCode;
    this.statusMessage = statusMessage;
  }

  public static HttpStatus valueOf(int statusCode) {
    HttpStatus status = find(statusCode);

    if(status == null){
      throw new IllegalArgumentException();
    }

    return status;
  }

  private static HttpStatus find(int statusCode) {
    for(HttpStatus status : VALUES) {
      if(status.statusCode == statusCode) {
        return status;
      }
    }
    return null;
  }
}
