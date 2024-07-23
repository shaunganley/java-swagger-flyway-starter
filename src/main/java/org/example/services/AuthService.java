package org.example.services;

import io.jsonwebtoken.Jwts;
import org.example.daos.AuthDao;
import org.example.daos.DatabaseConnector;
import org.example.exceptions.DatabaseConnectionException;
import org.example.exceptions.Entity;
import org.example.exceptions.InvalidException;
import org.example.models.LoginRequest;
import org.example.models.User;

import java.security.Key;
import java.sql.SQLException;
import java.util.Date;

public class AuthService {
    private final AuthDao authDao;
    private final DatabaseConnector databaseConnector;
    private final Key key;

    public AuthService(final Key key, final AuthDao authDao,
                       final DatabaseConnector databaseConnector) {
        this.key = key;
        this.authDao = authDao;
        this.databaseConnector = databaseConnector;
    }

    public String login(final LoginRequest loginRequest) throws SQLException,
            InvalidException, DatabaseConnectionException {
        User user = authDao.getUser(loginRequest, databaseConnector
                .getConnection());

        if (user == null) {
            throw new InvalidException(Entity.USER, "Invalid Credentials");
        }
        return generateJwtToken(user);
    }

    public String generateUsers()
            throws SQLException, DatabaseConnectionException {
        authDao.generateUsers(databaseConnector.getConnection());
        return "generated two users.";
    }

    private String generateJwtToken(final User user)  {
        return Jwts.builder()
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 28800000))
                .claim("Role", user.getRoleId())
                .subject(user.getEmail())
                .issuer("DropwizardDemo")
                .signWith(key)
                .compact();
    }
}
