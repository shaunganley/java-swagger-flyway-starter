package org.example.models;

import org.joda.time.DateTime;

public class Project {
    private int projectId;
    private String name;
    private float value;
    private int technologyId;
    private int techLeadId;
    private int clientId;
    private int salesEmployeeId;
    private DateTime startDate;
    private DateTime finishDate;
    private float comissionRate;

    public Project(int projectId,String name,float value, int technologyId,int techLeadId, int clientId, int salesEmployeeId, DateTime startDate,DateTime finishDate, float comissionRate){
        this.projectId = projectId;
        this.name = name;
        this.value = value;
        this.technologyId = technologyId;
        this.techLeadId = techLeadId;
        this.clientId = clientId;
        this.salesEmployeeId = salesEmployeeId;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.comissionRate = comissionRate;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(int technologyId) {
        this.technologyId = technologyId;
    }

    public int getTechLeadId() {
        return techLeadId;
    }

    public void setTechLeadId(int techLeadId) {
        this.techLeadId = techLeadId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getSalesEmployeeId() {
        return salesEmployeeId;
    }

    public void setSalesEmployeeId(int salesEmployeeId) {
        this.salesEmployeeId = salesEmployeeId;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public DateTime getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(DateTime finishDate) {
        this.finishDate = finishDate;
    }

    public float getComissionRate() {
        return comissionRate;
    }

    public void setComissionRate(float comissionRate) {
        this.comissionRate = comissionRate;
    }
}
