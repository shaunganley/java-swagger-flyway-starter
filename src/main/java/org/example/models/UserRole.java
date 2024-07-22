package org.example.models;

import java.util.Map;

public class UserRole {
    public static final String ADMIN = "admin";
    public static final String USER = "USER";
    int roleId;

    public UserRole(final int roleId) {
        this.roleId = roleId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(final int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return rolesMap.get(getRoleId());
    }

    private static final Map<Integer, String> rolesMap = Map.of(
            1, ADMIN,
            2, USER
    );


}

