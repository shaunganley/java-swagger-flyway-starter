package org.example.models;

import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;

public class JobRoleDetails {

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

    @ApiModelProperty(
            value = "Open or Closed",
            required = true,
            example = "open")
    private String statusName;

    @ApiModelProperty(
            value = "Job role description",
            required = true,
            example = "Description"
    )
    private String description;

    @ApiModelProperty(
            value = "Job role responsibilities",
            required = true,
            example = "responsibilities"
    )
    private String responsibilities;

    @ApiModelProperty(
            value = "https://url.com",
            required = true,
            example = "https://url.com"
    )
    private String sharepointUrl;

    @ApiModelProperty(
            value = "Number of open positions",
            required = true,
            example = "2"
    )
    private int numberOfOpenPositions;

    public JobRoleDetails(String roleName, String jobRoleLocation,
                          String capabilityName, String bandName,
                          Date closingDate,
                          String statusName, String description,
                          String responsibilities, String sharepointUrl,
                          int numberOfOpenPositions) {
        this.roleName = roleName;
        this.jobRoleLocation = jobRoleLocation;
        this.capabilityName = capabilityName;
        this.bandName = bandName;
        this.closingDate = closingDate;
        this.statusName = statusName;
        this.description = description;
        this.responsibilities = responsibilities;
        this.sharepointUrl = sharepointUrl;
        this.numberOfOpenPositions = numberOfOpenPositions;
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

    public String getCapabilityName() {
        return capabilityName;
    }

    public void setCapabilityName(String capabilityName) {
        this.capabilityName = capabilityName;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    public String getSharepointUrl() {
        return sharepointUrl;
    }

    public void setSharepointUrl(String sharepointUrl) {
        this.sharepointUrl = sharepointUrl;
    }

    public int getNumberOfOpenPositions() {
        return numberOfOpenPositions;
    }

    public void setNumberOfOpenPositions(int numberOfOpenPositions) {
        this.numberOfOpenPositions = numberOfOpenPositions;
    }
}
