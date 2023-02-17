package com.husky.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("Role")
public class Role {

  private Integer roleId;
  private String roleName;
  private String roleDescription;
  private String roleDetail;
  private String rolePageIds;

}
