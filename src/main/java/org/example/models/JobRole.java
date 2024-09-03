package org.example.models;

import java.sql.Date;

public class JobRole {
    private int jobRoleId;
    private String roleName;
    private String location;
    private Date closingDate;
    private String capabilityName;
    private String bandName;
    private String statusName;
    private String description;
    private String responsibilities;
    private String sharepointUrl;
    private int numberOfOpenPositions;

    public JobRole(final String roleName, final String location,
                   final String capabilityName,
                   final String bandName, final Date closingDate) {
        this.roleName = roleName;
        this.location = location;
        this.capabilityName = capabilityName;
        this.bandName = bandName;
        this.closingDate = closingDate;
    }

    public JobRole(final String roleName, final String description,
                   final String responsibilities,
                   final String sharepointUrl, final String location,
                   final String capabilityName,
                   final String bandName, final Date closingDate,
                   final String statusName,
                   final int numberOfOpenPositions) {
        this.roleName = roleName;
        this.description = description;
        this.responsibilities = responsibilities;
        this.sharepointUrl = sharepointUrl;
        this.location = location;
        this.capabilityName = capabilityName;
        this.bandName = bandName;
        this.closingDate = closingDate;
        this.statusName = statusName;
        this.numberOfOpenPositions = numberOfOpenPositions;
    }

    public int getJobRoleId() {
        return jobRoleId;
    }
    public void setJobRoleId(final int jobRoleId) {
        this.jobRoleId = jobRoleId;
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

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(final String statusName) {
        this.statusName = statusName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getSharepointUrl() {
        return sharepointUrl;
    }

    public void setSharepointUrl(final String sharepointUrl) {
        this.sharepointUrl = sharepointUrl;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(final String responsibilities) {
        this.responsibilities = responsibilities;
    }

    public int getNumberOfOpenPositions() {
        return numberOfOpenPositions;
    }

    public void setNumberOfOpenPositions(final int numberOfOpenPositions) {
        this.numberOfOpenPositions = numberOfOpenPositions;
    }
}


