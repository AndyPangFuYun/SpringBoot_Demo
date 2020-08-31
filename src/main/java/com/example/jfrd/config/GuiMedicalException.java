package com.example.jfrd.config;

/**
 * 封装gui-medical的异常
 */
public class GuiMedicalException extends RuntimeException{
    private static final long serialVersionUID = 3583873916474657694L;

    private Integer code;

    private String message;

    public GuiMedicalException(Integer code,String msg){
        this.code = code;
        this.message = msg;
    }

    public GuiMedicalException(ServiceExceptionEnumerate serviceExceptionEnumerate){
        this.code = serviceExceptionEnumerate.getCode();
        this.message = serviceExceptionEnumerate.getMessage();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
