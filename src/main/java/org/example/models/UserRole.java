package org.example.models;

import java.util.Map;

public class UserRole {

    public static final String HR = "hr";
    public static final String MANAGEMENT = "management";
    public static final String SALES = "sales";
    public static final String DELIVERY = "sales";
    public static final String TEAMLEAD = "teamlead";
    int id;

    private static final Map<Integer, String> ROLES_MAP = Map.of(
            1, HR,
            2, MANAGEMENT,
            3, SALES,
            4, DELIVERY,
            5, TEAMLEAD
    );

    public UserRole(final int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getRoleName() {
        return ROLES_MAP.get(getId());
    }

}
