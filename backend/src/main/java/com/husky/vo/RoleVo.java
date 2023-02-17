package com.husky.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: 周圣杰
 * Date: 2023/2/16
 * Time: 10:37
 */
@Data
@ApiModel("RoleVo")
public class RoleVo {
    @JsonProperty("id")
    private String roleName;

    @JsonProperty("name")
    private String roleDescription;

    @JsonProperty("describe")
    private String roleDetail;

    @JsonProperty("permissions")
    private List<PageVo> pageVoList;
}
