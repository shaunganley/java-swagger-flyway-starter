package org.example.models;

public enum JobRoleLocation {
    BELFAST("Belfast"),
    ATLANTA("Atlanta"),
    INDIANAPOLIS("Indianapolis"),
    BUENOS_AIRES("Buenos Aires"),
    ANTWERP("Antwerp"),
    TORONTO("Toronto"),
    COPENHAGEN("Copenhagen"),
    HELSINKI("Helsinki"),
    PARIS("Paris"),
    FRANKFURT_AM_MAIN("Frankfurt am Main"),
    GDANSK("Gdańsk");

    private final String jobRoleLocation;

    JobRoleLocation(final String jobRoleLocation) {
        this.jobRoleLocation = jobRoleLocation;
    }

    public String getJobRoleLocation() {
        return jobRoleLocation;
    }
}
