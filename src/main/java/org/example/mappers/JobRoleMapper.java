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
                        jobRole.getRoleName(),
                        jobRole.getLocation(),
                        jobRole.getCapabilityName(),
                        jobRole.getBandName(),
                        jobRole.getClosingDate()))
                .collect(Collectors.toList());
    }

    public static List<JobRoleDetailedResponse> mapJobRoleListToJobRoleDetailResponseList(
            final List<JobRole> jobRoles) {
        return jobRoles.stream()
                .map(jobRole -> new JobRoleDetailedResponse(
                        jobRole.getRoleName(),
                        jobRole.getDescription(),
                        jobRole.getResponsibilities(),
                        jobRole.getSharepointUrl(),
                        jobRole.getLocation(),
                        jobRole.getCapabilityName(),
                        jobRole.getBandName(),
                        jobRole.getClosingDate(),
                        jobRole.getStatusName(),
                        jobRole.getNumberOfOpenPositions()))
                .collect(Collectors.toList());
    }

}
