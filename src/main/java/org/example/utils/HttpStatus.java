package org.example.utils;

public final class HttpStatus {

    public static final int OK = 200;
    public static final int INTERNAL_SERVER_ERROR = 500;
    public static final int NOT_FOUND = 404;

    private HttpStatus() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
