package org.example.validators;

import org.junit.jupiter.api.Test;

import static org.example.validators.EmailValidator.isValidEmail;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailValidatorTest {

    @Test
    public void isValidEmail_shouldReturnTrue_forValidEmail() {
        String VALID_EMAIL = "valid.address@gmail.com";
        assertTrue(isValidEmail(VALID_EMAIL));
    }

    @Test
    public void isValidEmail_shouldReturnFalse_forInvalidEmail() {
        String INVALID_EMAIL = "invalid.address";
        assertFalse(isValidEmail(INVALID_EMAIL));
    }
}
