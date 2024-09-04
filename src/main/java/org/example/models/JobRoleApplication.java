package org.example.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Job Role Application", description = "Stores information about users applications and its statuses")
public class JobRoleApplication {

    @ApiModelProperty(
            value = "Role's name",
            required = true
    )
    private String roleName;

    @ApiModelProperty(
            value = "Application status name",
            required = true,
            example = "hired"
    )
    private String status;

    public JobRoleApplication(String roleName, String status) {
        this.roleName = roleName;
        this.status = status;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
