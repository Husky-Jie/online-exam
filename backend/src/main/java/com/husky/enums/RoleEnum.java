package com.husky.enums;

import lombok.Getter;

@Getter
public enum RoleEnum {

    ADMIN(1,"管理员"),
    TEACHER(2,"教师"),
    STUDENT(3,"学生");

    private Integer id;
    private String name;

    RoleEnum(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
