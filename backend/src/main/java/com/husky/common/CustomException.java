package com.husky.common;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * User: 周圣杰
 * Date: 2023/2/1
 * Time: 16:01
 */
@Data
public class CustomException extends RuntimeException{
    private String message;
}
