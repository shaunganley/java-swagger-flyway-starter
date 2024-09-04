package org.example.utils;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.Test;
import static org.example.utils.JwtUtils.generateToken;
import static org.junit.jupiter.api.Assertions.*;

final class JwtUtilsTest {

    @Test
    public void generateToken_ShouldGenerateTokenWithCorrectClaims() {
        var result = generateToken("siema@gmail.com", 1);
        var resultEmail = Jwts.parser().setSigningKey(JwtUtils.getSecretKey()).build().parseSignedClaims(result)
                .getPayload().get("email", String.class);
        var resultRoleId = Jwts.parser().setSigningKey(JwtUtils.getSecretKey()).build().parseSignedClaims(result)
                .getPayload().get("role_id", Integer.class);

        assertEquals("siema@gmail.com", resultEmail);
        assertEquals(1, resultRoleId);
    }
    @Test
    public void testGenerateToken_NotNullOrEmpty() {
        String token = generateToken("test@example.com", 1);
        assertNotNull(token);
        assertFalse(token.isEmpty());
    }
}