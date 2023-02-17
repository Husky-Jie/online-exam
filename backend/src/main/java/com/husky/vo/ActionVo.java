package com.husky.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * User: 周圣杰
 * Date: 2023/2/16
 * Time: 10:31
 */
@Data
@ApiModel("ActionVo")
public class ActionVo {
    @JsonProperty("action")
    private String actionName;

    @JsonProperty("describe")
    private String actionDescription;

    @JsonProperty("defaultCheck")
    private Boolean defaultCheck;
}
