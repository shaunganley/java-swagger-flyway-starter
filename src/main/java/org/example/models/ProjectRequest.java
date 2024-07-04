package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjectRequest {

    private String projectName;
    private double projectValue;
    private int clientID;

    @JsonCreator
    public ProjectRequest(
            @JsonProperty("projectName") String projectName,
            @JsonProperty("projectValue") double projectValue,
            @JsonProperty("clientID") int clientID) {
        this.projectName = projectName;
        this.projectValue = projectValue;
        this.clientID = clientID;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public double getProjectValue() {
        return projectValue;
    }

    public void setProjectValue(double projectValue) {
        this.projectValue = projectValue;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }
}
