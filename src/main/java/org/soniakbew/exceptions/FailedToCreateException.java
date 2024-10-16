package org.soniakbew.exceptions;

public class FailedToCreateException extends RuntimeException {
    public FailedToCreateException(final Entity entity) {
        super(entity.name() + " could not be created.");
    }
}
