package com.example.jfrd.config;

/**
 * 所有业务异常的枚举
 */
public enum BizExceptionEnum implements ServiceExceptionEnumerate {

    /**
     * 账户问题
     */
    USER_ALREADY_REG(401,"该用户已经注册"),
    NO_THIS_USER(400,"没有此用户"),
    USER_NOT_EXISTED(400, "没有此用户或账户密码错误"),
    ACCOUNT_NOT_LOGIN(499, "用户未登录或登录超时"),
    ACCOUNT_FREEZED(401, "账号被冻结"),
    OLD_PWD_NOT_RIGHT(402, "原密码不正确"),
    TWO_PWD_NOT_MATCH(405, "两次输入密码不一致");

    BizExceptionEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    private Integer code;
    private String message;

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
