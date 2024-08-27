package org.example.exceptions;

public enum Entity {

    JOBROLE("JobRole");

    private final String entity;

    Entity(final String entity) {
        this.entity = entity;
    }

    public String getEntity() {
        return entity;
    }
}
