package com.xxx.common;

import com.alibaba.fastjson.JSONObject;

// 错误消息提示
public class ErrorMessage {
    JSONObject jsonObject = new JSONObject();

    public ErrorMessage(String message) {
        jsonObject.put("status", 30);
        jsonObject.put("message", message);
        //jsonObject.put("success", false);
        //jsonObject.put("type", "error");
        //jsonObject.put("data", null);
    }

    public JSONObject getMessage() {
        return jsonObject;
    }
}