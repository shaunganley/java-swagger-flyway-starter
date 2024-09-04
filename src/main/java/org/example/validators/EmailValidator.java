package org.example.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class EmailValidator {
    private EmailValidator() { }

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@"
            + "[a-zA-Z0-9.-]+\\."
            + "[a-zA-Z]{2,6}$";
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile(EMAIL_REGEX);
    public static boolean isValidEmail(final String email) {
        if (email == null) {
            return false;
        }
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }
}
