package com.xx.sbc.common.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice(basePackages = "com.xx.sbc")
public class ServiceExceptionHandler {

    @Autowired
    protected MessageSource messageSource;

//    @ResponseStatus(HttpStatus.BAD_REQUEST) // 400
//    @ExceptionHandler(value = MethodArgumentNotValidException.class)
//    @ResponseBody
//    public ServiceResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e, WebRequest request) {
//        return buildExceptionResponse(BAD_REQUEST_EXCEPTION_CODE, e.getMessage(), e.getClass().getName(), request, HttpStatus.BAD_REQUEST.value());
//    }
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST) // 400
//    @ExceptionHandler(value = BindException.class)
//    @ResponseBody
//    public ServiceResponse handleBindException(BindException e, WebRequest request) {
//        return buildExceptionResponse(BAD_REQUEST_EXCEPTION_CODE, getBindExceptionMessage(e.getBindingResult()), e.getClass().getName(), request, HttpStatus.BAD_REQUEST.value());
//    }
//
//    @ResponseStatus(HttpStatus.UNAUTHORIZED) // 401
//    @ExceptionHandler(value = UserAuthorizationException.class)
//    @ResponseBody
//    public ServiceResponse handleUserAuthorizationException(UserAuthorizationException e, WebRequest request) {
//        return buildExceptionResponse(e.getErrorCode(), e.getErrorMessage(), e.getClass().getName(), request, HttpStatus.UNAUTHORIZED.value());
//    }
//
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 500
//    @ExceptionHandler(value = {ServiceException.class})
//    @ResponseBody
//    public ServiceResponse handleServiceException(ServiceException e, WebRequest request) {
//        return ServiceResponse.fail(e.getCode());
//    }
//
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 500
//    @ExceptionHandler(value = Exception.class)
//    @ResponseBody
//    public ServiceResponse handleException(Exception e, WebRequest request) {
//        return buildExceptionResponse(COMMON_EXCEPTION_CODE, "服务器系统错误!", e.getClass().getName(), request, HttpStatus.INTERNAL_SERVER_ERROR.value());
//    }

}
