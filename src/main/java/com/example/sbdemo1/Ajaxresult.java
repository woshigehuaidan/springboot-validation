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
    //有没有产生冲突?
    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }

    public JSONObject toJSONObject() {

        String msg = JSONObject.toJSONString(this);

        return JSONObject.parseObject(msg, Feature.OrderedField);
    }
}
