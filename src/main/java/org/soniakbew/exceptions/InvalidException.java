package org.soniakbew.exceptions;

public class InvalidException extends RuntimeException {
    public InvalidException(final Entity entity) {
        super(entity.name() + " could not be created.");
    }
}
