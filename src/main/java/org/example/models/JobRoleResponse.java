package org.example.models;

import java.sql.Date;

public class JobRoleResponse {
    private String roleName;
    private String jobRoleLocation;
    private String capabilityId;
    private String bandId;
    private Date closingDate;

    public JobRoleResponse(final String roleName,
                           final String jobRoleLocation,
                           final String capability,
                           final String band,
                           final Date closingDate) {
        this.roleName = roleName;
        this.jobRoleLocation = jobRoleLocation;
        this.capabilityId = capability;
        this.bandId = band;
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

    public String getCapabilityId() {
        return capabilityId;
    }

    public void setCapabilityId(final String capabilityId) {
        this.capabilityId = capabilityId;
    }

    public String getBandId() {
        return bandId;
    }

    public void setBandId(final String bandId) {
        this.bandId = bandId;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(final Date closingDate) {
        this.closingDate = closingDate;
    }
}
