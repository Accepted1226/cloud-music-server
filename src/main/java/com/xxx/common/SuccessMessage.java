package com.xxx.common;

import com.alibaba.fastjson.JSONObject;

// 成功消息
public class SuccessMessage<T> {
    JSONObject jsonObject = new JSONObject();

    public SuccessMessage(String message) {
        jsonObject.put("status",0);
        jsonObject.put("message", message);
//        jsonObject.put("code", 200);
//        jsonObject.put("message", message);
//        jsonObject.put("success", true);
//        jsonObject.put("type", "success");
//        jsonObject.put("data",null);
    }

    public SuccessMessage(String message, T data) {
        jsonObject.put("status",0);
        jsonObject.put("data", data);
//        jsonObject.put("code", 200);
        jsonObject.put("message", message);
//        jsonObject.put("success", true);
//        jsonObject.put("type", "success");
//        jsonObject.put("data", data);
    }
    public SuccessMessage(Integer count,String msg){
        jsonObject.put("status",0);

        jsonObject.put("data", msg);
    }


    public SuccessMessage(Integer id){
        JSONObject data=new JSONObject();
        data.put("id",id);
        jsonObject.put("data",data);
        jsonObject.put("status",0);
    }
    public SuccessMessage(T lis,Integer count,String msg){

        JSONObject data=new JSONObject();
        data.put("total",count);
        data.put("data",lis);
        jsonObject.put("status",0);
        jsonObject.put("data", data);

    }

    public SuccessMessage( T data) {
        //jsonObject.put("code", 200);
        //jsonObject.put("message", null);
        //jsonObject.put("success", true);
        //jsonObject.put("type", "success");
        jsonObject.put("status",0);
        jsonObject.put("data", data);
    }



    public JSONObject getMessage() {
        return jsonObject;
    }
}
