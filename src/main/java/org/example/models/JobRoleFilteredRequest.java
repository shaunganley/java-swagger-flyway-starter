package org.example.models;

import io.swagger.annotations.ApiModelProperty;

import javax.ws.rs.QueryParam;
import java.sql.Date;
import java.util.List;

public class JobRoleFilteredRequest {
    @ApiModelProperty(
            value = "Job role's name",
            required = true,
            example = "Delivery manager")
    @QueryParam("roleName")
    private String roleName;

    @ApiModelProperty(
            value = "Role's location, defined by ENUM value",
            required = true,
            example = "[Gdańsk]")
    @QueryParam("jobRoleLocation")
    private List<String> jobRoleLocation;

    @ApiModelProperty(
            value = "Capability's name",
            required = true,
            example = "[1]")
    @QueryParam("capabilityId")
    private List<Integer> capabilityId;

    @ApiModelProperty(
            value = "Band's name",
            required = true,
            example = "[1]")
    @QueryParam("bandId")
    private List<Integer> bandId;

    @ApiModelProperty(
            value = "Expire date of offer",
            required = true,
            example = "2024-12-30")
    @QueryParam("closingDate")
    private Date closingDate;

    public String getRoleName() {
        return roleName;
    }

    public String getLikeRoleName() {
        return "%" + roleName + "%";
    }

    public void setRoleName(final String roleName) {
        this.roleName = roleName;
    }

    public List<String> getJobRoleLocation() {
        return jobRoleLocation;
    }

    public void setJobRoleLocation(final List<String> jobRoleLocation) {
        this.jobRoleLocation = jobRoleLocation;
    }

    public List<Integer> getCapabilityId() {
        return capabilityId;
    }

    public void setCapabilityId(final List<Integer> capabilityId) {
        this.capabilityId = capabilityId;
    }

    public List<Integer> getBandId() {
        return bandId;
    }

    public void setBandId(final List<Integer> bandId) {
        this.bandId = bandId;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(final Date closingDate) {
        this.closingDate = closingDate;
    }
}
