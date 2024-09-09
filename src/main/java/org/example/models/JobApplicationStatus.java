package org.example.models;

public enum JobApplicationStatus {
    IN_PROGRESS("in progress"),
    HIRED("hired"),
    REJECTED("rejected");

    private final String jobApplicationStatus;

    JobApplicationStatus(String jobApplicationStatus) {
        this.jobApplicationStatus = jobApplicationStatus;
    }

    public String getJobApplicationStatus() {
        return jobApplicationStatus;
    }
}
