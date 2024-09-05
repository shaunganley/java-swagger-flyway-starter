package org.example.exceptions;

public class RoleApplicationCVFileTooBig extends Throwable{

    private final static String BASE_MESSAGE = "File should not exceed 10MB but was: ";
    public RoleApplicationCVFileTooBig(String message) {
        super(BASE_MESSAGE + message);
    }
}
