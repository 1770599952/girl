package com.imooc.enums;

/**
 * Created by MAIBENBEN on 2018/1/31.
 */
public enum ResultEnum {

    SUCCESS(0,"成功"),
    FAIL(-1,"未知错误"),
    CHILD_ERROR(100,"未成年，不合法哦！"),
    AGE_LOWWER(101,"年龄太小！")
    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
