package org.example.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class JwtUtils {
    // Generate a SecretKey for HS256
    private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long EXPIRATION_TIME = 86400000; // 1 day in milliseconds

    private JwtUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static String generateToken(final String email, final int roleId) {
        System.out.println(SECRET_KEY);
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", email);
        claims.put("role_id", roleId);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    public static SecretKey getSecretKey() {
        return SECRET_KEY;
    }

    public static boolean validateToken(final String token) {
        try {
            // Parse the token and validate its signature
            Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (SignatureException | SecurityException e) {
            // Invalid signature / token tampering
            throw new IllegalArgumentException("Invalid JWT signature: " + e.getMessage(), e);
        } catch (io.jsonwebtoken.ExpiredJwtException e) {
            // Token expired
            throw new IllegalArgumentException("JWT token is expired: " + e.getMessage(), e);
        } catch (io.jsonwebtoken.MalformedJwtException e) {
            // Malformed token
            throw new IllegalArgumentException("Invalid JWT token: " + e.getMessage(), e);
        } catch (io.jsonwebtoken.UnsupportedJwtException e) {
            // Unsupported JWT
            throw new IllegalArgumentException("JWT token is unsupported: " + e.getMessage(), e);
        } catch (IllegalArgumentException e) {
            // Invalid argument (e.g., null or empty token)
            throw new IllegalArgumentException("JWT claims string is empty or null: " + e.getMessage(), e);
        }
    }
}

