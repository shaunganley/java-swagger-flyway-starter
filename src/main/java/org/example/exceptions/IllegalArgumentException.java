package org.example.exceptions;

public class IllegalArgumentException extends Throwable {
    public IllegalArgumentException(final Entity entity) {
        super(entity.getEntity() + " is an illegal argument");
    }
}
