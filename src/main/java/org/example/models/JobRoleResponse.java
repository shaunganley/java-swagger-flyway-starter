package org.example.models;

import java.sql.Date;

public class JobRoleResponse {
    private String roleName;
    private String jobRoleLocation;
    private String capabilityName;
    private String bandName;
    private Date closingDate;

    public JobRoleResponse(final String roleName,
                           final String jobRoleLocation,
                           final String capability,
                           final String band,
                           final Date closingDate) {
        this.roleName = roleName;
        this.jobRoleLocation = jobRoleLocation;
        this.capabilityName = capability;
        this.bandName = band;
        this.closingDate = closingDate;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(final String roleName) {
        this.roleName = roleName;
    }

    public String getJobRoleLocation() {
        return jobRoleLocation;
    }

    public void setJobRoleLocation(final String jobRoleLocation) {
        this.jobRoleLocation = jobRoleLocation;
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

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(final Date closingDate) {
        this.closingDate = closingDate;
    }
}
