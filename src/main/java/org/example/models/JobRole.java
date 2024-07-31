package org.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class JobRole {

    @JsonProperty
    private int id;

    @JsonProperty
    private String roleName;

    @JsonProperty
    private String location;

    @JsonProperty
    private int capabilityID;

    @JsonProperty
    private int bandID;

    @JsonProperty
    private Date closingDate;

    @JsonProperty
    private String status;

    public JobRole(final int id,
                   final String roleName,
                   final String location,
                   final int capabilityID,
                   final int bandID,
                   final Date closingDate,
                   final String status) {
        this.id = id;
        this.roleName = roleName;
        this.location = location;
        this.capabilityID = capabilityID;
        this.bandID = bandID;
        this.closingDate = closingDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(final String roleName) {
        this.roleName = roleName;
    }

    public int getCapabilityID() {
        return capabilityID;
    }

    public void setCapability(final int capabilityID) { this.capabilityID = capabilityID; }

    public String getLocation() {
        return location;
    }

    public void setLocation(final String location) {
        this.location = location;
    }

    public int getBandID() {
        return bandID;
    }

    public void setBandID(final int bandID) { this.bandID = bandID; }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(final Date closingDate) {
        this.closingDate = closingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }
}
