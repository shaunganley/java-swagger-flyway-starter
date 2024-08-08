package org.example.exceptions;

public enum Entity {

    DELIVERY("Delivery"), SALES("Sales");

    private final String entity;

    Entity(final String entity) {
        this.entity = entity;
    }

    public String getEntity() {
        return entity;
    }
}
