package com.example.sbdemo1;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@RestController
@RequestMapping("/test")
public class TestValidated {

    @RequestMapping("/testValid")
    public String testValid(@RequestBody @Validated  ValidBean validBean) {

        return "halo";
    }

//    @RequestMapping("/testValid")
//    public String testValid(@RequestBody @Validated  ValidBean validBean) {
//        if ()
//        return "halo";
//    }

//    @RequestMapping("/testValid2")
//    public String testValid2(@RequestBody @Validated  ValidBean validBean,BindingResult bindingResult) {
//        List<ObjectError> allErrors = bindingResult.getAllErrors();
//        List<String> data = new ArrayList<String>();
//        for (int i=0;i<allErrors.size();i++){
//            System.out.println(allErrors.get(i).getDefaultMessage());
//            data.add(allErrors.get(i).getDefaultMessage());
//
//        }
//
//        return JSONObject.toJSONString(data);
//    }

//    @RequestMapping("/testValid2")
//    public String testValid2(@RequestBody @Validated  ValidBean validBean,BindingResult bindingResult) {
//
//        Ajaxresult ajaxresult = new Ajaxresult();
//        if (bindingResult.hasErrors()){
//            ajaxresult.setSuccess(false);
//            ajaxresult.setResultInfo(bindingResult.getAllErrors().get(0).getDefaultMessage()+bindingResult.getAllErrors().get(1).getDefaultMessage());
//        }else {
//            ajaxresult.setSuccess(true);
//            ajaxresult.setResultInfo("登陆成功");
//        }
//        return JSONObject.toJSONString(ajaxresult);
//    }

    @RequestMapping("/testValid2")
    public String testValid2(@RequestBody @Validated  ValidBean validBean) {
        Ajaxresult ajaxresult = new Ajaxresult(null,false);
        if(validBean.getName().equals("")||validBean.getName()==null||validBean.getAge()==null){
            ajaxresult.setSuccess(false);
            ajaxresult.setResultInfo("用户名不能为空!");
            return JSONObject.toJSONString(ajaxresult);
        }
            ajaxresult.setSuccess(true);
            ajaxresult.setResultInfo("登陆成功");
        return JSONObject.toJSONString(ajaxresult);
    }

    @RequestMapping("/testValid1")
    public String testValid1(@RequestBody @Validated  ValidBean validBean,BindingResult bindingResult) {

        List<ObjectError> allErrors = bindingResult.getAllErrors();

        for (int i=0;i<allErrors.size();i++){
            System.out.println(allErrors.get(i).getDefaultMessage());
            switch (allErrors.get(i).getDefaultMessage()){
                case "用户名不能为空":
                    System.out.println("用户名不为空");
                    return "用户名";
                case "邮箱不能为空":
                    System.out.println("邮箱不为空");
                    return "邮箱不为空";
                case "年龄不能为空":
                    System.out.println("年龄不为空");
                    return "年龄不为空";
                case "名字长度不在范围之内":
                    System.out.println("名字长度不在范围");
                    return "名字长度不在范围";
                case "年龄不在范围之内":
                    System.out.println("年龄不在范围");
                    return "年龄不在范围";
                case "邮箱格式不对":
                    System.out.println("邮箱格式");
                    return "邮箱格式";
            }

        }

        return "halo";
    }
}
