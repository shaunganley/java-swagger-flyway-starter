package com.kainos.ea.mapper;

import org.example.mappers.JobRoleMapper;
import org.example.models.JobRole;
import org.example.models.JobRoleResponse;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JobRoleMapperTest {

    @Test
    public void mapJobRolesListToJobRoleResponseList_shouldMapCorrectly() {

        long millis=System.currentTimeMillis();
        Date closingDate = new Date(millis);
        JobRole testJobRole = new JobRole("SE", "Derry",
                "Eng", "Band 4", closingDate);
        List<JobRole> jobRoles = new ArrayList<>();
        jobRoles.add(testJobRole);

        List<JobRoleResponse> jobRoleResponses = JobRoleMapper.mapJobRolesListToJobRoleResponseList(jobRoles);

        Assert.assertEquals(1, jobRoleResponses.size());

        JobRoleResponse response = jobRoleResponses.get(0);
        Assert.assertEquals("SE", response.getRoleName());
        Assert.assertEquals("Derry", response.getLocation());
        Assert.assertEquals("Eng", response.getCapabilityName());
        Assert.assertEquals("Band 4", response.getBandName());
        Assert.assertEquals(closingDate, response.getClosingDate());

    }

    @Test
    public void mapJobRolesListToJobRoleResponseList_shouldHandleEmptyList() {

        List<JobRole> jobRoles = Collections.emptyList();

        List<JobRoleResponse> jobRoleResponses = JobRoleMapper.mapJobRolesListToJobRoleResponseList(jobRoles);

        Assert.assertTrue(jobRoleResponses.isEmpty());
    }

    @Test
    public void mapJobRolesListToJobRoleResponseList_shouldHandleNullValues() {

        long millis=System.currentTimeMillis();
        Date closingDate = new Date(millis);
        JobRole testJobRole = new JobRole(null, null, null, null, closingDate);
        List<JobRole> jobRoles = new ArrayList<>();
        jobRoles.add(testJobRole);

        List<JobRoleResponse> jobRoleResponses = JobRoleMapper.mapJobRolesListToJobRoleResponseList(jobRoles);

        Assert.assertEquals(1, jobRoleResponses.size());
        JobRoleResponse response = jobRoleResponses.get(0);
        Assert.assertNull(response.getRoleName());
        Assert.assertNull(response.getLocation());
        Assert.assertNull(response.getCapabilityName());
        Assert.assertNull(response.getBandName());
        Assert.assertEquals(closingDate, response.getClosingDate());
    }

}
