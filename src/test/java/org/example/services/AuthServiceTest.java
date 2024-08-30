package org.example.services;

import org.example.daos.AuthDao;
import org.example.exceptions.DatabaseConnectionException;
import org.example.exceptions.LoginException;
import org.example.models.LoginRequest;
import org.example.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AuthServiceTest {
    private static final User
            USER = new User("validUser@email.com", "ValidPa$$word!123", 1);
    private static final LoginRequest LOGIN_REQUEST = new LoginRequest("validUser@email.com", "ValidPa$$word!123");
    AuthDao mockAuthDao = Mockito.mock(AuthDao.class);
    private Key jwtKey;
    AuthService authService;
    @BeforeEach
    public void setUp() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
        keyGen.init(256); // for example
        SecretKey secretKey = keyGen.generateKey();
        this.jwtKey = secretKey;
        authService = new AuthService(mockAuthDao, jwtKey);
    }

    @Test
    public void login_shouldThrowInvalidException_whenNoValidUserFound() throws
            DatabaseConnectionException, SQLException {
        when(mockAuthDao.getUser(LOGIN_REQUEST)).thenReturn(null);
        LoginException exception = assertThrows(LoginException.class, () -> {
            authService.login(LOGIN_REQUEST);
        });
        String expectedExceptionMessage = "Login Request: Invalid Login Credentials";
        String actualExceptionMessage = exception.getMessage();
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
        verify(mockAuthDao, times(1)).getUser(LOGIN_REQUEST);
    }

    @Test
    public void login_shouldReturnJwtToken_whenValidUserFound()
            throws DatabaseConnectionException, SQLException, LoginException {
        when(mockAuthDao.getUser(LOGIN_REQUEST)).thenReturn(USER);
        assertNotNull(authService.login(LOGIN_REQUEST));
        verify(mockAuthDao, times(1)).getUser(LOGIN_REQUEST);
    }

    @Test
    public void login_shouldThrowDBConnException_whenDaoThrowsDBConnectionException() throws DatabaseConnectionException, SQLException {
        when(mockAuthDao.getUser(LOGIN_REQUEST)).thenThrow(new DatabaseConnectionException(new Exception("Connection Error")));
        assertThrows(DatabaseConnectionException.class, () -> authService.login(LOGIN_REQUEST));
        verify(mockAuthDao, times(1)).getUser(LOGIN_REQUEST);
    }

    @Test
    public void login_shouldThrowSqlException_whenDaoThrowsSqlException() throws DatabaseConnectionException, SQLException {
        when(mockAuthDao.getUser(LOGIN_REQUEST)).thenThrow(new SQLException());
        assertThrows(SQLException.class, () -> authService.login(LOGIN_REQUEST));
        verify(mockAuthDao, times(1)).getUser(LOGIN_REQUEST);
    }
}