package com.example.sbdemo1;
//
//import cn.com.imch.mddp.protocol.annotation.ErrorCode;
//import cn.com.imch.mddp.protocol.vo.EnumErrorMessage;
//import cn.com.imch.mddp.utils.response.ResponseUtils;
import com.alibaba.fastjson.JSONObject;
import com.example.validation.ErrorCode;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.Field;

//@RestControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public JSONObject handleMethodArgumentNotValid(MethodArgumentNotValidException ex) throws NoSuchFieldException {
        BindingResult result = ex.getBindingResult();
        Integer errorCode = null;
        String msg = null;

        Field field = ex.getParameter().getParameterType().getField(result.getFieldError().getField());
        ErrorCode[] errorCodeAnnotations = field.getDeclaredAnnotationsByType(ErrorCode.class);
        for (ErrorCode errorCodeAnnotation : errorCodeAnnotations) {
            if (result.getFieldError().getCode().equals(errorCodeAnnotation.type().getName())) {
                errorCode = errorCodeAnnotation.code();
                msg = result.getFieldError().getDefaultMessage();
                System.out.println(result.getFieldError().getDefaultMessage());
            }
        }

        Ajaxresult ajaxresult = new Ajaxresult(msg,true,errorCode);
        return ajaxresult.toJSONObject();
    }
}
