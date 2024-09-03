package org.example.auth;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.jsonwebtoken.Jwts;
import org.example.models.JwtToken;
import org.example.models.UserPrincipal;
import org.example.models.UserRole;

import java.security.Key;
import java.util.Optional;

public class JwtAuthenticator implements Authenticator<String, JwtToken> {
    private final Key key;

    public JwtAuthenticator(final Key key) {
        this.key = key;
    }

    public Key getKey() {
        return key;
    }

    @Override
    public Optional<JwtToken> authenticate(final String token)
            throws AuthenticationException {
        try {
            Integer roleId = Jwts.parser()
                    .setSigningKey(key)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload()
                    .get("role_id", Integer.class);

            JwtToken jwtToken = new JwtToken(new UserRole(roleId));

            return Optional.of(jwtToken);
        } catch (Exception e) {
            return Optional.empty();
        }
    }


    public Optional<UserPrincipal> getSubject(String jwtToken) throws AuthenticationException {
        // Validate and parse the JWT token
        // You can use a library like JJWT or Nimbus JOSE + JWT

        // Example using JJWT
        try {
            String email = Jwts.parser()
                    .setSigningKey("SECRET_KEY") // Use your secret key
                    .parseSignedClaims(jwtToken)
                    .getBody()
                    .getSubject(); // Assuming the email is stored as the subject

            return Optional.of(new UserPrincipal(email));
        } catch (JwtException e) {
            return Optional.empty();
        }
    }

}
