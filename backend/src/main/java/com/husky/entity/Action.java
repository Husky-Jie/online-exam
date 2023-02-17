package com.husky.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("Action")
public class Action {

  private Integer actionId;
  private String actionName;
  private String actionDescription;
  private Boolean defaultCheck;


}
