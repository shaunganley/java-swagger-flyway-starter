package org.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class JobRole {

    public JobRole() {
    };

    @JsonProperty
    private int id;

    @JsonProperty
    private String roleName;

    @JsonProperty
    private String location;

    @JsonProperty
    private String capability;

    @JsonProperty
    private String band;

    @JsonProperty
    private Date closingDate;

    @JsonProperty
    private String status;

    @JsonProperty
    private String description;

    @JsonProperty
    private String responsibilities;

    @JsonProperty
    private String jobSpec;

    private JobRole(final Builder builder) {
        this.id = builder.id;
        this.roleName = builder.roleName;
        this.location = builder.location;
        this.capability = builder.capability;
        this.band = builder.band;
        this.closingDate = builder.closingDate;
        this.status = builder.status;
        this.description = builder.description;
        this.responsibilities = builder.responsibilities;
        this.jobSpec = builder.jobSpec;
    }

    public static class Builder {
        private int id;
        private String roleName;
        private String location;
        private String capability;
        private String band;
        private Date closingDate;
        private String status;
        private String description;
        private String responsibilities;
        private String jobSpec;

        public Builder id(final int paramId) {
            this.id = paramId;
            return this;
        }

        public Builder roleName(final String paramRoleName) {
            this.roleName = paramRoleName;
            return this;
        }

        public Builder location(final String paramLocation) {
            this.location = paramLocation;
            return this;
        }

        public Builder capability(final String paramCapability) {
            this.capability = paramCapability;
            return this;
        }

        public Builder band(final String paramBand) {
            this.band = paramBand;
            return this;
        }

        public Builder closingDate(final Date paramClosingDate) {
            this.closingDate = paramClosingDate;
            return this;
        }

        public Builder status(final String paramStatus) {
            this.status = paramStatus;
            return this;
        }

        public Builder description(final String paramDescription) {
            this.description = paramDescription;
            return this;
        }

        public Builder responsibilities(final String paramResponsibilities) {
            this.responsibilities = paramResponsibilities;
            return this;
        }

        public Builder jobSpec(final String paramJobSpec) {
            this.jobSpec = paramJobSpec;
            return this;
        }

        public JobRole build() {
            return new JobRole(this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(final String roleName) {
        this.roleName = roleName;
    }

    public String getCapability() {
        return capability;
    }

    public void setCapability(final String capability) {
        this.capability = capability;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(final String location) {
        this.location = location;
    }

    public String getBand() {
        return band;
    }

    public void setBand(final String band) {
        this.band = band;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(final Date closingDate) {
        this.closingDate = closingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(final String responsibilities) {
        this.responsibilities = responsibilities;
    }

    public String getJobSpec() {
        return jobSpec;
    }

    public void setJobSpec(final String jobSpec) {
        this.jobSpec = jobSpec;
    }
}
