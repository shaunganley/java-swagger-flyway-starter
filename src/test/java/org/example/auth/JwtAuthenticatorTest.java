package org.example.auth;

import org.example.models.JwtToken;
import org.example.models.UserRole;
import io.dropwizard.auth.AuthenticationException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.junit.Before;
import org.junit.Test;

import java.security.Key;
import java.util.Optional;

import static org.junit.Assert.*;

public class JwtAuthenticatorTest {

    private JwtAuthenticator authenticator;
    private Key key;

    @Before
    public void setUp() {
        key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        authenticator = new JwtAuthenticator(key);
    }

    @Test
    public void testAuthenticateSuccess() throws AuthenticationException {
        String token = Jwts.builder()
                .claim("Role", 1)
                .signWith(key)
                .compact();

        Optional<JwtToken> result = authenticator.authenticate(token);

        assertTrue(result.isPresent());
        assertEquals(1, result.get().getUserRole().getRoleId());
        assertEquals(UserRole.ADMIN, result.get().getUserRole().getRoleName());
    }

    @Test
    public void testAuthenticateFailure_InvalidToken() throws AuthenticationException {
        String invalidToken = "invalidToken";

        Optional<JwtToken> result = authenticator.authenticate(invalidToken);

        assertFalse(result.isPresent());
    }

    @Test
    public void testAuthenticateFailure_TokenParsingException() throws AuthenticationException {
        Key wrongKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String invalidToken = Jwts.builder()
                .claim("Role", 1)
                .signWith(wrongKey)
                .compact();

        Optional<JwtToken> result = authenticator.authenticate(invalidToken);

        assertFalse(result.isPresent());
    }
}
