package org.example.controllers;

import io.dropwizard.auth.Auth;
import io.jsonwebtoken.Jwts;
import org.example.daos.AuthDao;
import org.example.daos.DatabaseConnector;
import org.example.exceptions.DatabaseConnectionException;
import org.example.exceptions.DoesNotExistException;
import org.example.exceptions.InvalidException;
import org.example.models.LoginRequest;
import org.example.models.User;
import org.example.services.AuthService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;
import java.security.Key;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginControllerTest {
    Key jwtKey = Jwts.SIG.HS256.key().build();
    AuthDao authDao = Mockito.mock(AuthDao.class);
    DatabaseConnector databaseConnector = Mockito.mock(DatabaseConnector.class);
    AuthService authService = new AuthService(jwtKey, authDao, databaseConnector);
    AuthController authController = new AuthController(authService);

    private static final String EMAIL   = System.getenv("LOGIN_EMAIL");
    private static final String PASSWORD  = System.getenv("LOGIN_PASSWORD");
    LoginRequest loginRequest = new LoginRequest(
            EMAIL,
            PASSWORD
    );

    User user = new User(EMAIL, "","",1);
    Connection conn;

    @Test
    void login_shouldReturnJwtToken_WhenValidUser() throws SQLException,
            DatabaseConnectionException, DoesNotExistException,
            InvalidException {
        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(authDao.getUser(loginRequest, conn)).thenReturn(user);
        Mockito.when(authService.login(loginRequest)).thenReturn(jwtKey.toString());
        Response response = authController.login(loginRequest);
        assertEquals(201, response.getStatus());
        assertEquals(jwtKey.toString(), response.getEntity());

    }
}
