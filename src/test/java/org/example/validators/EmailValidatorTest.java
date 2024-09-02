package org.example.validators;

import org.junit.jupiter.api.Test;

import static org.example.validators.EmailValidator.isValidEmail;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailValidatorTest {

    @Test
    public void isValidEmail_shouldReturnTrue_forValidEmail() {
        String VALID_EMAIL = "valid.user@gmail.com";
        assertTrue(isValidEmail(VALID_EMAIL));
    }

    @Test
    public void isValidEmail_shouldReturnFalse_forInvalidEmail() {
        String INVALID_EMAIL = "invalid.user";
        assertFalse(isValidEmail(INVALID_EMAIL));
    }

    @Test
    public void isValidEmail_shouldReturnFalse_forNullEmail() {
        String NULL_EMAIL = null;
        assertFalse(isValidEmail(NULL_EMAIL));
    }

    @Test
    public void isValidEmail_shouldReturnFalse_forEmptyEmail() {
        String EMPTY_EMAIL = "";
        assertFalse(isValidEmail(EMPTY_EMAIL));
    }

    @Test
    public void isValidEmail_shouldReturnFalse_forEmailWithoutAtSymbol() {
        String MISSING_AT_SYMBOL = "userdomain.com";
        assertFalse(isValidEmail(MISSING_AT_SYMBOL));
    }

    @Test
    public void isValidEmail_shouldReturnFalse_forEmailWithoutDomain() {
        String MISSING_DOMAIN = "user@";
        assertFalse(isValidEmail(MISSING_DOMAIN));
    }

    @Test
    public void isValidEmail_shouldReturnFalse_forEmailWithSpecialCharacters() {
        String SPECIAL_CHAR_EMAIL = "user!#$%&'*+/=?^_`{|}~@domain.com";
        assertFalse(isValidEmail(SPECIAL_CHAR_EMAIL));
    }

    @Test
    public void isValidEmail_shouldReturnTrue_forEmailWithUnderscore() {
        String EMAIL_WITH_UNDERSCORE = "first_last@domain.com";
        assertTrue(isValidEmail(EMAIL_WITH_UNDERSCORE));
    }

    @Test
    public void isValidEmail_shouldReturnTrue_forEmailWithHyphenInDomain() {
        String EMAIL_WITH_HYPHEN_DOMAIN = "user@domain-name.com";
        assertTrue(isValidEmail(EMAIL_WITH_HYPHEN_DOMAIN));
    }

    @Test
    public void isValidEmail_shouldReturnTrue_forEmailWithSubdomain() {
        String VALID_EMAIL_WITH_SUBDOMAIN = "user@sub.domain.com";
        assertTrue(isValidEmail(VALID_EMAIL_WITH_SUBDOMAIN));
    }

    @Test
    public void isValidEmail_shouldReturnFalse_forEmailWithTwoAtSymbols() {
        String EMAIL_WITH_TWO_ATS = "user@@domain.com";
        assertFalse(isValidEmail(EMAIL_WITH_TWO_ATS));
    }

    @Test
    public void isValidEmail_shouldReturnFalse_forEmailWithSpaces() {
        String EMAIL_WITH_SPACES = "user name@domain.com";
        assertFalse(isValidEmail(EMAIL_WITH_SPACES));
    }

    @Test
    public void isValidEmail_shouldReturnFalse_forEmailWithInvalidCharacterInDomain() {
        String INVALID_CHARACTER_IN_DOMAIN = "user@dom@in.com";
        assertFalse(isValidEmail(INVALID_CHARACTER_IN_DOMAIN));
    }

    @Test
    public void isValidEmail_shouldReturnTrue_forEmailWithUkDomain() {
        String UK_DOMAIN = "user@domain.co.uk";
        assertTrue(isValidEmail(UK_DOMAIN));
    }

}
