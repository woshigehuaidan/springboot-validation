package com.example.sbdemo1;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;

public class Ajaxresult {
    private String resultInfo;
    private boolean success;//测试Git
    private Integer errorcode;


    public Ajaxresult(String resultInfo, boolean success) {
        this.resultInfo = resultInfo;
        this.success = success;
    }

    public Ajaxresult(String resultInfo, boolean success, Integer errorcode) {
        this.resultInfo = resultInfo;
        this.success = success;
        this.errorcode = errorcode;
    }

    public Integer getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(Integer errorcode) {
        this.errorcode = errorcode;
    }

    public String getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }
    //是否应该产生冲突呢//我不知道idea
    //是否产生了冲突呢//你应该肯定知道
    //是否应该产生冲突呢//你肯定知道idea
    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    //否应该产生冲突呢//我不知道idea
    //是否产生了冲突呢//你你应该肯定知道
    //是否应该产生冲突呢//你肯定知道idea

    public JSONObject toJSONObject() {

        String msg = JSONObject.toJSONString(this);

        return JSONObject.parseObject(msg, Feature.OrderedField);
    }
}
