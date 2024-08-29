package org.example.validators;

import org.junit.jupiter.api.Test;

import static org.example.validators.PasswordValidator.isValidPassword;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordValidatorTest {
    @Test
    public void isValidPassword_shouldReturnTrue_forValidPassword() {
        String VALID_PASSWORD = "validPa$$word123!";
        assertTrue(isValidPassword(VALID_PASSWORD));
    }

    @Test
    public void isValidPassword_shouldReturnFalse_forPasswordTooLong() {
        String INVALID_PASSWORD = "1nval!dP@ssword" +
                "InvalidPa$$word123" +
                "InvalidPa$$word123" +
                "InvalidPa$$word123" +
                "InvalidPa$$word123" +
                "InvalidPa$$word123" +
                "InvalidPa$$word123" +
                "InvalidPa$$word123";
        assertFalse(isValidPassword(INVALID_PASSWORD));
    }

    @Test
    public void isValidPassword_shouldReturnFalse_forPasswordTooShort() {
        String INVALID_PASSWORD = "a1$A";
        assertFalse(isValidPassword(INVALID_PASSWORD));
    }

    @Test
    public void isValidPassword_shouldReturnFalse_forPasswordWithNoSpecialCharacter() {
        String INVALID_PASSWORD = "InvalidPassword123";
        assertFalse(isValidPassword(INVALID_PASSWORD));
    }

    @Test
    public void isValidPassword_shouldReturnFalse_forPasswordWithWhitespace() {
        String INVALID_PASSWORD = "Invalid Pa$sword123!";
        assertFalse(isValidPassword(INVALID_PASSWORD));
    }

    @Test
    public void isValidPassword_shouldReturnFalse_forPasswordWithNoDigits() {
        String INVALID_PASSWORD = "InvalidPa$$word";
        assertFalse(isValidPassword(INVALID_PASSWORD));
    }

    @Test
    public void isValidPassword_shouldReturnFalse_forPasswordWithNoUppercase() {
        String INVALID_PASSWORD = "invalidpa$$word123";
        assertFalse(isValidPassword(INVALID_PASSWORD));
    }

    @Test
    public void isValidPassword_shouldReturnFalse_forPasswordWithNoLowercase() {
        String INVALID_PASSWORD = "INVALIDPA$$WORD123";
        assertFalse(isValidPassword(INVALID_PASSWORD));
    }
}