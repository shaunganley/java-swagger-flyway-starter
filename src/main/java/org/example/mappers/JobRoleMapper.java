package org.example.mappers;

import org.example.models.JobRole;
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
                        jobRole.getCapabilityId(),
                        jobRole.getBandId(),
                        jobRole.getClosingDate()))
                .collect(Collectors.toList());
    }
}
