package org.example.models;

import java.sql.Date;

public class JobRoleResponse {
    private String roleName;
    private String location;
    private Date closingDate;
    private String capabilityName;
    private String bandName;

    public JobRoleResponse(final String roleName, final String location,
                           final String capabilityName,
                           final String bandName, final Date closingDate) {
        this.roleName = roleName;
        this.location = location;
        this.capabilityName = capabilityName;
        this.bandName = bandName;
        this.closingDate = closingDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(final String location) {
        this.location = location;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(final String roleName) {
        this.roleName = roleName;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(final Date closingDate) {
        this.closingDate = closingDate;
    }

    public String getCapabilityName() {
        return capabilityName;
    }

    public void setCapabilityName(final String capabilityName) {
        this.capabilityName = capabilityName;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(final String bandName) {
        this.bandName = bandName;
    }
}
