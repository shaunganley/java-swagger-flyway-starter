package org.example.models;

public class User {
    final String email;
    final String username;
    final String password;
    final int roleId;

    public User(String email, final String username,
                final String password,
                final int roleId) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.roleId = roleId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getRoleId() {
        return roleId;
    }

    public String getEmail() {
        return email;
    }
}


