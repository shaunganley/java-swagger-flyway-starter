package org.example.controllers;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.example.auth.JwtTokenProvider;
import org.example.daos.AuthDao;
import org.example.exceptions.InvalidException;
import org.example.models.LoginRequest;
import org.example.models.User;
import org.example.services.AuthService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.security.Key;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class AuthControllerTest {
    JwtTokenProvider jwtTokenProvider = new JwtTokenProvider();
    AuthService authservice = Mockito.mock(AuthService.class);
    AuthDao authDao = Mockito.mock(AuthDao.class);
    LoginRequest loginRequest = new LoginRequest("admin", "admin");


    User user = new User("admin", "admin", 1);
    Key jwtkey = jwtTokenProvider.getJwtkey();


    private final AuthController authController = new AuthController(authservice);

//    @Test
//    void login_shouldReturnToken_whenLoginSuccesful() {
//        when(authservice.login(loginRequest)).thenReturn()
//    }

    @Test
    void authenticate_ShouldReturnValidJwtToken_WhenCredentialsAreValid() throws SQLException, InvalidException {
        System.out.println(jwtkey);
        // Arrange
        when(authDao.getUser(loginRequest)).thenReturn(user);

        // Act
        String token = authservice.login(loginRequest);
        System.out.println(token);

        // Assert
        assertNotNull(token);
        assertFalse(token.isEmpty());

        // Parse and validate the token
        Claims claims = Jwts.parser()
                .setSigningKey(jwtkey)
                .build()
                .parseClaimsJws(token)
                .getBody();

        assertEquals(user.getEmail(), claims.getSubject()); // Verify the username
        assertTrue(claims.containsKey("Email")); // Verify the username claim
        assertEquals("admin", claims.get("Email")); // Verify the username value
    }


}
