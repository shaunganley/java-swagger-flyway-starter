package org.example.exceptions;

public enum Entity {
    EMPLOYEE("Employee"),
    SALESEMPLOYEE("Sale Employee"),
    DELIVERYEMPLOYEE("Delivery Employee"),
<<<<<<< HEAD
    PROJECT("Project");
=======
    USER("User");

>>>>>>> a94f2bd (Adding Authentication and Authorisation)
    private final String entity;

    Entity(final String entity) {
        this.entity = entity;
    }

    public String getEntity() {
        return this.entity;
    }
}
