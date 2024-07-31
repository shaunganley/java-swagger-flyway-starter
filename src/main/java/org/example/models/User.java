package org.example.models;

public class User {

    String username;

    String password;

    int UserRoleID;

    public User(final String username, final String password,
                final int UserRoleID) {
        this.username = username;
        this.password = password;
        this.UserRoleID = UserRoleID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public int getUserRoleID() {
        return UserRoleID;
    }

    public void setUserRoleID(final int UserRoleID) {
        this.UserRoleID = UserRoleID;
    }
}
