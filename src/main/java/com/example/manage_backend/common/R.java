package com.example.manage_backend.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用返回结果
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class R {

    private Integer code; //编码：1成功，0和其它数字为失败

    private String message; //信息

    private Object data; //数据

    public static R success() {
        return new R(200, null, null);
    }

    public static R success(Object data) {
        return new R(200, null, data);
    }

    public static R error(Integer code, String message) {
        return new R(code, message, null);
    }

    public static R error() {
        return new R(500, "系统错误", null);
    }
}
