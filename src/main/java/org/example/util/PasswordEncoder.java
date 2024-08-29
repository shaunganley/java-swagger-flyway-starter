package org.example.util;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

public final class PasswordEncoder {
    private PasswordEncoder() { }

    private static final Argon2PasswordEncoder ARGON_2_PASSWORD_ENCODER
            = new Argon2PasswordEncoder(16, 32, 1, 60000, 10);

    public static Argon2PasswordEncoder getPasswordEncoder() {
        return ARGON_2_PASSWORD_ENCODER;
    }
}
