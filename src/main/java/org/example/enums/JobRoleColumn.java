package org.example.enums;

public enum JobRoleColumn {
    ROLENAME("roleName"),
    LOCATION("location"),
    BANDNAME("bandName"),
    CAPABILITYNAME("capabilityName"),
    CLOSINGDATE("closingDate"),
    STATUSNAME("statusName");

    private final String columnName;

    JobRoleColumn(final String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }
}
