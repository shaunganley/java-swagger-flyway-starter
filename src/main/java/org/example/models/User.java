package org.example.models;

public class User {

     String email;
     String salt;
     String hash;
     int roleId;

    public User(final String email, final String salt, final String hash,
                final int roleId) {
        this.email = email;
        this.salt = salt;
        this.hash = hash;
        this.roleId = roleId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(final String salt) {
        this.salt = salt;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(final String hash) {
        this.hash = hash;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(final int roleId) {
        this.roleId = roleId;
    }
}
