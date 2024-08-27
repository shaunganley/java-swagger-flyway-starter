package org.example.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;

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
            example = "Gdańsk")
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

    public JobRole(final int jobRoleId,
                   final String roleName,
                   final String jobRoleLocation,
                   final String capabilityName,
                   final String bandName,
                   final Date closingDate) {
        this.jobRoleId = jobRoleId;
        this.roleName = roleName;
        this.jobRoleLocation = jobRoleLocation;
        this.capabilityName = capabilityName;
        this.bandName = bandName;
        this.closingDate = closingDate;
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
}
