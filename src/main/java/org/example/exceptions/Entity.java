package org.example.exceptions;

public enum Entity {
    EMPLOYEE("Employee"),
    SALES_EMPLOYEE("SalesEmployee"),
    DELIVERY_EMPLOYEE("DeliveryEmployee"),
    CLIENT("Client"),
    HR_EMPLOYEE("HR"),
    TECH_LEAD("TechLead"),
    PROJECT("Project");

    private final String entity;

    Entity(final String ent) {
        this.entity = ent;
    }

    public String getEntity() {
        return this.entity;
    }
}