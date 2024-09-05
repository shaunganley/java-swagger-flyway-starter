package org.example.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;
import java.util.Objects;

@ApiModel(value = "Job Role", description = "Defines raw object for JobRole class present in DB")
public class JobRole {

    @ApiModelProperty(value = "unique JobRole id")
    private int jobRoleId;

    @ApiModelProperty(
            value = "Job role's name",
            required = true,
            example = "Delivery manager")
    private String roleName;

    @ApiModelProperty(
            value = "Role's location, defined by ENUM value",
            required = true,
            example = "Gdansk")
    private String jobRoleLocation;

    @ApiModelProperty(
            value = "Capability's name",
            required = true,
            example = "Digital Service")
    private String capabilityName;

    @ApiModelProperty(
            value = "Band's name",
            required = true,
            example = "Trainee")
    private String bandName;

    @ApiModelProperty(
            value = "Expire date of offer",
            required = true,
            example = "11/12/2024")
    private Date closingDate;

    @ApiModelProperty(
            value = "Open or Closed",
            required = true,
            example = "open")
    private String statusName;

    public JobRole(final int jobRoleId,
                   final String roleName,
                   final String jobRoleLocation,
                   final String capabilityName,
                   final String bandName,
                   final Date closingDate,
                   final String statusName) {
        this.jobRoleId = jobRoleId;
        this.roleName = roleName;
        this.jobRoleLocation = jobRoleLocation;
        this.capabilityName = capabilityName;
        this.bandName = bandName;
        this.closingDate = closingDate;
        this.statusName = statusName;
    }

    public int getJobRoleId() {
        return jobRoleId;
    }

    public void setJobRoleId(final int jobRoleId) {
        this.jobRoleId = jobRoleId;
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

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(final String statusName) {
        this.statusName = statusName;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        JobRole jobRole = (JobRole) o;
        return jobRoleId == jobRole.jobRoleId && Objects.equals(roleName, jobRole.roleName)
                && Objects.equals(jobRoleLocation, jobRole.jobRoleLocation)
                && Objects.equals(capabilityName, jobRole.capabilityName)
                && Objects.equals(bandName, jobRole.bandName)
                && Objects.equals(closingDate, jobRole.closingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobRoleId, roleName, jobRoleLocation, capabilityName, bandName, closingDate);
    }
}
