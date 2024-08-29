package org.example.auth;

import io.jsonwebtoken.Jwts;

import java.security.Key;

public class JwtToken {
    Key jwtkey = Jwts.SIG.HS256.key().build();

}
