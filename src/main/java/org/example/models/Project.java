package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Project {

    private String projectName;
    private double projectValue;
    private int clientID;

    @JsonCreator
    public Project(
            @JsonProperty("projectName1") final String projectName1,
            @JsonProperty("projectValue1") final double projectValue1,
            @JsonProperty("clientID1") final int clientID1) {
        this.projectName = projectName1;
        this.projectValue = projectValue1;
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

    public void setClientID(final int cliID) {
        this.clientID = cliID;
    }
}
