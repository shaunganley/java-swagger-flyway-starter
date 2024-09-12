package org.example.mappers;

import org.example.models.JobRole;
import org.example.models.JobRoleDetailedResponse;
import org.example.models.JobRoleResponse;

import java.util.List;
import java.util.stream.Collectors;

public final class JobRoleMapper {

    private JobRoleMapper() {
    }

    public static List<JobRoleResponse> mapJobRolesListToJobRoleResponseList(
            final List<JobRole> jobRoles) {
        return jobRoles.stream()
                .map(jobRole -> new JobRoleResponse(
                        jobRole.getJobRoleId(),
                        jobRole.getRoleName(),
                        jobRole.getLocation(),
                        jobRole.getCapabilityName(),
                        jobRole.getBandName(),
                        jobRole.getClosingDate()))
                .collect(Collectors.toList());
    }

    public static JobRoleDetailedResponse mapJobRoleToJobRoleDetailedResponse(
            final JobRole jobRole) {
        return new JobRoleDetailedResponse(
                jobRole.getJobRoleId(),
                jobRole.getRoleName(),
                jobRole.getDescription(),
                jobRole.getResponsibilities(),
                jobRole.getSharepointUrl(),
                jobRole.getLocation(),
                jobRole.getCapabilityName(),
                jobRole.getBandName(),
                jobRole.getClosingDate(),
                jobRole.getStatusName(),
                jobRole.getNumberOfOpenPositions());
    }

}
