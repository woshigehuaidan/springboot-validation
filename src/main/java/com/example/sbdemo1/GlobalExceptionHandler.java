package com.example.sbdemo1;


import com.alibaba.fastjson.JSONObject;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public String globalException(MethodArgumentNotValidException e){
        Class<?> parameterType = e.getParameter().getParameterType();
        System.out.println(parameterType.getCanonicalName());
        BindingResult bindingResult = e.getBindingResult();
        System.out.println(Size.class.getName());
        System.out.println(bindingResult.getFieldError().getCode());
        System.out.println(bindingResult.getFieldError().getField());
        System.out.println(bindingResult.getFieldError().getDefaultMessage());
        Ajaxresult ajaxresult = null;
        ajaxresult.setSuccess(false);
        ajaxresult.setResultInfo(bindingResult.getAllErrors().get(0).getDefaultMessage());
        return JSONObject.toJSONString(ajaxresult);
    }
}