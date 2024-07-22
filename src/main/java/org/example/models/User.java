package org.example.models;

public class User {

     String email;
     String password;
     int roleId;

    public User(final String password, final String email, final int roleId) {
        this.password = password;
        this.email = email;
        this.roleId = roleId;
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

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(final int roleId) {
        this.roleId = roleId;
    }
}
