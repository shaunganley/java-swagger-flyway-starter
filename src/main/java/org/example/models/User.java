package org.example.models;

public class User {

    String username;

    String password;

    int loginID;

    public User(String username, String password, int loginID) {
        this.username = username;
        this.password = password;
        this.loginID = loginID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLoginID() {
        return loginID;
    }

    public void setLoginID(int loginID) {
        this.loginID = loginID;
    }
}
