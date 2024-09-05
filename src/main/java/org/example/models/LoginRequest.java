package org.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

public class LoginRequest {
    String email;
    String password;

    @JsonCreator
    public LoginRequest(
            @JsonProperty ("email")
            final String email,
            @JsonProperty ("password")
            final String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }
}
