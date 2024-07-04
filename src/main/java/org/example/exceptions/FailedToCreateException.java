package org.example.exceptions;

public class FailedToCreateException extends Throwable {
    /**
     * Exception thrown if system fails to create a record or records in
     * the database.
     * @param entity is the entity for which creation failed.
     */
    public FailedToCreateException(final Entity entity) {
        super(entity.getEntity() + "could not be created!");
    }
}
