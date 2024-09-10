package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public class JobRoleRequest {

    private String roleName;
    private String description;
    private String sharepointUrl;
    private String responsibilities;
    private int numberOfOpenPositions;
    private String location;
    private Date closingDate;
    private int capabilityId;
    private int bandId;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(final String roleName) {
        this.roleName = roleName;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(final String location) {
        this.location = location;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(final Date closingDate) {
        this.closingDate = closingDate;
    }

    public int getCapabilityId() {
        return capabilityId;
    }

    public void setCapabilityId(final int capabilityId) {
        this.capabilityId = capabilityId;
    }

    public int getBandId() {
        return bandId;
    }

    public void setBandId(final int bandId) {
        this.bandId = bandId;
    }

    @JsonCreator
    public JobRoleRequest(
            @JsonProperty("roleName") final String roleName,
            @JsonProperty("description") final String description,
            @JsonProperty("sharepointUrl") final String sharepointUrl,
            @JsonProperty("responsibilities") final String responsibilities,
            @JsonProperty("numberOfOpenPositions") final int numberOfOpenPositions,
            @JsonProperty("location") final String location,
            @JsonProperty("closingDate") final Date closingDate,
            @JsonProperty("capabilityName") final String capabilityName,
            @JsonProperty("bandName") final String bandName) {
        this.roleName = roleName;
        this.description = description;
        this.sharepointUrl = sharepointUrl;
        this.responsibilities = responsibilities;
        this.numberOfOpenPositions = numberOfOpenPositions;
        this.location = location;
        this.closingDate = closingDate;
        this.capabilityName = capabilityName;
        this.bandName = bandName;
    }

}
