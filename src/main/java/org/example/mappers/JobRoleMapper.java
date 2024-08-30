package org.example.mappers;

import org.example.models.JobRole;
import org.example.models.JobRoleResponse;

import java.util.ArrayList;
import java.util.List;

public final class JobRoleMapper {

    private JobRoleMapper() {
    }

    public static List<JobRoleResponse> toResponse(final List<JobRole> jobRoles) {
        List<JobRoleResponse> jobRoleResponses = new ArrayList<>();
        for (JobRole j : jobRoles) {
            jobRoleResponses.add(toResponse(j));
        }
        return jobRoleResponses;
    }

    private static JobRoleResponse toResponse(final JobRole jobRole) {
        return new JobRoleResponse(
                jobRole.getRoleName(),
                jobRole.getJobRoleLocation(),
                jobRole.getCapabilityName(),
                jobRole.getBandName(),
                jobRole.getClosingDate(),
                jobRole.getStatus()
        );
    }

}
