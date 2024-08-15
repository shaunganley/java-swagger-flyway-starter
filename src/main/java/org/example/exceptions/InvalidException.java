package org.example.exceptions;

public class InvalidException extends Throwable {

    public InvalidException(final Entity entity, final String reason) {
        super(entity.getEntity() + " is not valid: " + reason);
<<<<<<< HEAD

=======
>>>>>>> a94f2bd (Adding Authentication and Authorisation)
    }
}
