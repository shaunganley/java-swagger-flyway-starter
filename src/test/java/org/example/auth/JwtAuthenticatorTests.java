package org.example.auth;
import io.dropwizard.auth.AuthenticationException;
import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.SignatureAlgorithm;
import org.example.models.JwtToken;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.crypto.spec.SecretKeySpec;
import javax.swing.text.html.Option;
import java.security.Key;
import java.util.Date;
import java.util.Optional;

public class JwtAuthenticatorTests {
    private JwtAuthenticator jwtAuthenticator;
    private Key key;

    @BeforeEach
    public void setUp() {
        String secret = "secretKey";
        key = new SecretKeySpec(secret.getBytes(), SignatureAlgorithm.HS256
                .getJcaName());
        jwtAuthenticator = new JwtAuthenticator(key);
    }

    @Test
    public void testAuthenticateValid() throws AuthenticationException {
        String token = Jwts.builder()
                .claim("Role",1)
                .setSubject("user")
                .setIssuedAt(new Date())
                .signWith(key)
                .compact();

        Optional<JwtToken> result = jwtAuthenticator.authenticate(token);
        Assertions.assertTrue(result.isPresent());
//        Assertions.assertEquals(1, result.get().getUserRole()
//                .getRoleId());

    }

    @Test
    public void testAuthenticateInvalid() throws AuthenticationException {
        String token = "incorrectToken";

        Optional<JwtToken> result = jwtAuthenticator.authenticate(token);
        Assertions.assertFalse(result.isPresent());

    }
}
