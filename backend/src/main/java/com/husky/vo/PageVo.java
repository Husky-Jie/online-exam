package com.husky.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: 周圣杰
 * Date: 2023/2/16
 * Time: 10:35
 */
@Data
@ApiModel("PageVo")
public class PageVo {
    @JsonProperty("actionEntitySet")
    private List<ActionVo> actionVoList;

    @JsonProperty("permissionId")
    private String pageName;

    @JsonProperty("permissionName")
    private String pageDescription;
}
