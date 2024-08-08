package org.example.exceptions;

import org.example.exceptions.Entity;

public class InvalidException extends Throwable {
    public InvalidException(Entity entity, String  reason) {
        super(entity.getEntity() + " is not valid: " + reason);
    }
}
