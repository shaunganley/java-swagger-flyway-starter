package org.example.models;

import io.swagger.annotations.ApiModelProperty;
import java.sql.Date;
import java.util.List;
import javax.ws.rs.QueryParam;

public class JobRoleFilteredRequest {
    @ApiModelProperty(value = "Job role's name", required = true, example = "Delivery manager")
    @QueryParam("roleName")
    private String roleName;

    @ApiModelProperty(value = "Role's location, defined by ENUM value", required = true, example = "[Gdansk]")
    @QueryParam("jobRoleLocation")
    private List<String> jobRoleLocation;

    @ApiModelProperty(value = "Capability's name", required = true, example = "[1]")
    @QueryParam("capabilityName")
    private List<String> capabilityName;

    @ApiModelProperty(value = "Band's name", required = true, example = "[1]")
    @QueryParam("bandName")
    private List<String> bandName;

    @ApiModelProperty(value = "Expire date of offer", required = true, example = "2024-12-30")
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

    public List<String> getCapabilityName() {
        return capabilityName;
    }

    public void setCapabilityName(final List<String> capabilityName) {
        this.capabilityName = capabilityName;
    }

    public List<String> getBandName() {
        return bandName;
    }

    public void setBandName(final List<String> bandName) {
        this.bandName = bandName;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(final Date closingDate) {
        this.closingDate = closingDate;
    }
}
