package org.example.models;

import java.sql.Date;

public class JobRole {
    private int jobRoleId;
    private String roleName;
    private String jobRoleLocation;
    private int capabilityId;
    private int bandId;
    private Date closingDate;

    public JobRole(int jobRoleId, String jobRoleLocation, String roleName, int capabilityId, Date closingDate, int bandId) {
        this.jobRoleId = jobRoleId;
        this.jobRoleLocation = jobRoleLocation;
        this.roleName = roleName;
        this.capabilityId = capabilityId;
        this.closingDate = closingDate;
        this.bandId = bandId;
    }

    public int getJobRoleId() {
        return jobRoleId;
    }

    public void setJobRoleId(int jobRoleId) {
        this.jobRoleId = jobRoleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getJobRoleLocation() {
        return jobRoleLocation;
    }

    public void setJobRoleLocation(String jobRoleLocation) {
        this.jobRoleLocation = jobRoleLocation;
    }

    public int getCapabilityId() {
        return capabilityId;
    }

    public void setCapabilityId(int capabilityId) {
        this.capabilityId = capabilityId;
    }

    public int getBandId() {
        return bandId;
    }

    public void setBandId(int bandId) {
        this.bandId = bandId;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }
}
