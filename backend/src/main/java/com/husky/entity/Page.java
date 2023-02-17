package com.husky.entity;


import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("Page")
public class Page {

  private Integer pageId;
  private String pageName;
  private String pageDescription;
  private String actionIds;

}
