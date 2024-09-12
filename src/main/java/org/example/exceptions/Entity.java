package org.example.exceptions;


public enum Entity {

    USER("User"),
    JOB_ROLE("JobRole"),
    LOGIN_REQUEST("Login Request");
    private final String entity;

    Entity(final String entity) {
        this.entity = entity;
    }

    public String getEntity() {
        return this.entity;
    }
}
