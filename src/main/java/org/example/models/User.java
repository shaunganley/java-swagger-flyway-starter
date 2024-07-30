package org.example.models;

public class User {

    String username;

    String password;

    int loginID;

    public User() {
    }

    public User(final String username, final String password,
                final int loginID) {
        this.username = username;
        this.password = password;
        this.loginID = loginID;
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

    public int getLoginID() {
        return loginID;
    }

    public void setLoginID(final int loginID) {
        this.loginID = loginID;
    }
}
