package org.example.exceptions;

public enum Entity {

    /**
     * Employee entity.
     */
    EMPLOYEE("Employee"),
    /**
     * Sales Employee entity.
     */
    SALES_EMPLOYEE("SalesEmployee"),
    /**
     * Delivery Employee entity.
     */
    DELIVERY_EMPLOYEE("DeliveryEmployee"),
    /**
     * Client entity.
     */
    CLIENT("Client"),
    /**
     * HR entity.
     */
    HR_EMPLOYEE("HR"),
    /**
     * Tech Lead entity.
     */
    TECH_LEAD("TechLead"),
    /**
     * Project entity.
     */
    PROJECT("Project");

    /**
     * Entity value.
     */
    private final String entity;

    Entity(final String ent) {
        this.entity = ent;
    }

    /**
     * Get the entity value.
     * @return the value corresponding to the
     * entity enum value.
     */
    public String getEntity() {
        return this.entity;
    }
}
