package org.example.services;


import io.jsonwebtoken.Jwts;
import org.example.daos.AuthDao;
import org.example.daos.DatabaseConnector;
import org.example.exceptions.DatabaseConnectionException;
import org.example.models.LoginRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.security.Key;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class LoginServiceTests {

    Key jwtKey = Jwts.SIG.HS256.key().build();
    AuthDao authDao = Mockito.mock(AuthDao.class);
    DatabaseConnector databaseConnector = Mockito.mock(DatabaseConnector.class);
    AuthService authService = new AuthService(jwtKey, authDao, databaseConnector);

    LoginRequest loginRequest = new LoginRequest(
            "adam@random.com",
            "pass123"
    );

    Connection conn;

    @Test
    void login_ReturnDoesNotExistException_WhenDaoThrowsSqlException() throws
            SQLException, DatabaseConnectionException {
        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(authDao.getUser(loginRequest, conn))
                .thenThrow(SQLException.class);
        assertThrows(SQLException.class,
                () -> authService.login(loginRequest));
    }

    @Test
    void login_ThrowsDatabaseConnectionException_WhenDaoThrowsDatabaseConnectionException()
            throws
            SQLException, DatabaseConnectionException {
        Mockito.when(authDao.getUser(loginRequest, conn)).thenThrow(
                DatabaseConnectionException.class);
        assertThrows(DatabaseConnectionException.class,
                () -> authService.login(loginRequest));

    }


}
