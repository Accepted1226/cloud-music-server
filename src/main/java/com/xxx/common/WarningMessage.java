package com.xxx.common;

import com.alibaba.fastjson.JSONObject;

// 警告消息
public class WarningMessage {
    JSONObject jsonObject = new JSONObject();

    public WarningMessage(String message) {
        jsonObject.put("status", 30);
        jsonObject.put("message", message);
//        jsonObject.put("success", false);
//        jsonObject.put("type", "warning");
//        jsonObject.put("data", null);
    }

    public JSONObject getMessage() {
        return jsonObject;
    }
}
