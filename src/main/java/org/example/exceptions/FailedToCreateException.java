package org.example.exceptions;

public class FailedToCreateException extends Throwable {
    public FailedToCreateException(final Entity entity) {
        super(entity.getEntity() + "could not be created!");
    }
}
