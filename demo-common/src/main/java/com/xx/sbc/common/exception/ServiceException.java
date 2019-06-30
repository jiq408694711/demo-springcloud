package com.xx.sbc.common.exception;

public class ServiceException extends Exception {
    private String code;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, String code) {
        super(message);
        this.code = code;
    }
}
