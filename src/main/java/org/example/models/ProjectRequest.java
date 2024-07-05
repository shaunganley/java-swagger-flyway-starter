package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjectRequest {

    private String projectName;
    private double projectValue;
    private int clientID;

    @JsonCreator
    public ProjectRequest(
            @JsonProperty("projName") final String projName,
            @JsonProperty("projValue") final double projValue,
            @JsonProperty("clientID1") final int clientID1) {
        this.projectName = projName;
        this.projectValue = projValue;
        this.clientID = clientID1;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(final String projName) {
        this.projectName = projName;
    }

    public double getProjectValue() {
        return projectValue;
    }

    public void setProjectValue(final double projValue) {
        this.projectValue = projValue;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(final int clientID1) {
        this.clientID = clientID1;
    }
}
