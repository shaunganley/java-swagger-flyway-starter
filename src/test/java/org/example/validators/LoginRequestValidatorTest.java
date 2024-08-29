package org.example.validators;

import org.example.models.LoginRequest;
import org.junit.jupiter.api.Test;

import static org.example.validators.LoginRequestValidator.validateLoginRequest;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginRequestValidatorTest {
    @Test
    public void validateLoginRequest_shouldReturnTrue_forValidEmailAndPassword() {
        LoginRequest VALID_LOGIN_REQUEST = new LoginRequest("valid.email@gmail.com", "valid!Pa$$word123");
        assertTrue(validateLoginRequest(VALID_LOGIN_REQUEST));
    }

    @Test
    public void validateLoginRequest_shouldReturnFalse_withInvalidEmail() {
        LoginRequest INVALID_LOGIN_REQUEST = new LoginRequest("invalid.email.gmail.com", "valid!Pa$$word123");
        assertFalse(validateLoginRequest(INVALID_LOGIN_REQUEST));
    }

    @Test
    public void validateLoginRequest_shouldReturnFalse_withInvalidPassword() {
        LoginRequest INVALID_LOGIN_REQUEST = new LoginRequest("valid.email@gmail.com", "invalid");
        assertFalse(validateLoginRequest(INVALID_LOGIN_REQUEST));
    }
}
