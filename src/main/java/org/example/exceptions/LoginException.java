package org.example.exceptions;

public class LoginException extends Exception {

    public LoginException(final Entity entity) {
        super(entity.getEntity() + ": Invalid Login Credentials");
    }
}
