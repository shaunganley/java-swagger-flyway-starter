package org.example.models;

public enum JobRoleStatus {
    OPEN(1),
    CLOSED(2);

    private final int status;

    JobRoleStatus(final int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
