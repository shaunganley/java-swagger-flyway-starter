package org.example.exceptions;

public class FailedToCreateException extends RuntimeException {
  public FailedToCreateException(String message) {
    super(message);
  }
}
