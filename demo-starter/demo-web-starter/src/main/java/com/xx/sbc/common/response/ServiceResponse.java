package com.xx.sbc.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceResponse implements Serializable {

    protected static final long serialVersionUID = -1L;

    private String code;
    private String message;
    private Boolean success = true;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public static ServiceResponse success() {
        ServiceResponse response = new ServiceResponse();
        response.setSuccess(true);
        return response;
    }

    public static ServiceResponse fail(String code) {
        ServiceResponse response = new ServiceResponse();
        response.setSuccess(false);
//        this.message = LocaleContextUtil.getMessage(code);
        response.setCode(code);
        return response;
    }

    public static ServiceResponse fail(String code, Object[] args) {
        ServiceResponse response = new ServiceResponse();
        response.setSuccess(false);
//        this.message = LocaleContextUtil.getMessage(code, args);
        response.setCode(code);
        return response;
    }
}
