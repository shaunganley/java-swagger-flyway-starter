package org.example.controller;
import org.example.controllers.AuthController;
import org.example.exceptions.DatabaseConnectionException;
import org.example.exceptions.DoesNotExistException;
import org.example.exceptions.InvalidException;
import org.example.models.LoginRequest;
import org.example.services.AuthService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class AuthControllerTest {
    AuthService authService = Mockito.mock(AuthService.class);
    private final AuthController authController = new AuthController(authService);

    private static final String EMAIL   = System.getenv("LOGIN_EMAIL_1");
    private static final String PASSWORD  = System.getenv("LOGIN_PASSWORD_1");

    private static final LoginRequest loginRequest = new LoginRequest(
                EMAIL,
                PASSWORD
    );

    @Test
    void login_shouldReturnJwtToken_whenSuccessful()
            throws DatabaseConnectionException, SQLException,
            DoesNotExistException, InvalidException {
        String jwtToken = "";

        when(authService.login(loginRequest)).thenReturn(jwtToken);

        Response response = authController.login(loginRequest);

        assertEquals(200, response.getStatus());
    }


}