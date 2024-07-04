package org.example.exceptions;

public class DoesNotExistException extends Throwable {
    /**
     * DoesNotExistException thrown if attempting to retrieve data that
     * does not exist.
     * @param entity is the enum value of
     * the entity that could not be retrieved.
     */
    public DoesNotExistException(final Entity entity) {
        super(entity.getEntity() + "does not exist");
    }
}
