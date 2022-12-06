package com.xxx.common;

import com.alibaba.fastjson.JSONObject;

// 致命消息
public class FatalMessage {
    JSONObject jsonObject = new JSONObject();

    public FatalMessage(String message) {
        jsonObject.put("status", 500);
        jsonObject.put("message", message);
        //jsonObject.put("success", false);
        //jsonObject.put("type", "error");
        //jsonObject.put("data", null);
    }

    public JSONObject getMessage() {
        return jsonObject;
    }
}