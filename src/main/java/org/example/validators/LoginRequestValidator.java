package org.example.validators;

import org.example.models.LoginRequest;

import static org.example.validators.EmailValidator.isValidEmail;
import static org.example.validators.PasswordValidator.isValidPassword;

public final class LoginRequestValidator {
    private LoginRequestValidator() {
    }

    public static boolean validateLoginRequest(
            final LoginRequest loginRequest
    ) {
        return isValidEmail(loginRequest.getEmail())
                && isValidPassword(loginRequest.getPassword());
    }
}
