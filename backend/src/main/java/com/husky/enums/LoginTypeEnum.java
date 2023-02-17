package com.husky.enums;

import lombok.Getter;

@Getter
public enum LoginTypeEnum {
    USERNAME(1, "用户名"),
    EMAIL(2, "邮箱");

    private Integer type;
    private String name;

    LoginTypeEnum(Integer type, String name) {
        this.type = type;
        this.name = name;
    }
}
