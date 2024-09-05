package org.example.services;

import io.jsonwebtoken.Jwts;
import org.example.daos.AuthDao;
import org.example.exceptions.DatabaseConnectionException;
import org.example.exceptions.Entity;
import org.example.exceptions.LoginException;
import org.example.models.LoginRequest;
import org.example.models.User;

import java.security.Key;
import java.sql.Date;
import java.sql.SQLException;

import static org.example.validators.LoginRequestValidator.validateLoginRequest;

public class AuthService {
    private final AuthDao authDao;
    private final Key key;
    private final int expirationTime = 28800000;

    public AuthService(final AuthDao authDao, final Key key) {
        this.authDao = authDao;
        this.key = key;
    }

    public String login(final LoginRequest loginRequest)
            throws SQLException, DatabaseConnectionException, LoginException {
        if (!validateLoginRequest(loginRequest)) {
            throw new LoginException(Entity.LOGIN_REQUEST);
        }
        User user = authDao.getUser(loginRequest);

        if (user == null) {
            throw new LoginException(Entity.LOGIN_REQUEST);
        }
        return generateJwtToken(user);
    }

    private String generateJwtToken(final User user) {
        return Jwts.builder()
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()
                        + expirationTime))
                .claim("Role", user.getRoleId())
                .subject(user.getEmail())
                .issuer("DropwizardDemo")
                .signWith(key)
                .compact();
    }
}
