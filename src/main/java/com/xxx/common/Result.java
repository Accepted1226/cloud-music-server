package com.xxx.common;


import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {

    private Integer code;
    private Integer status;
    private String msg;
    private Object data;

    public static Result success(Object data) {
        return success("操作成功", data);
    }

    public static Result success(String mess, Object data) {
        Result m = new Result();
        m.setCode(0);
        m.setStatus(0);
        m.setData(data);
        m.setMsg(mess);
        return m;
    }

    public static Result fail(String mess) {
        return fail(mess, null);
    }

    public static Result fail(String mess, Object data) {
        Result m = new Result();
        m.setCode(-1);
        m.setStatus(-1);
        m.setData(data);
        m.setMsg(mess);

        return m;
    }

    public static Result result(EnumExceptionType enumExceptionType,Object data) {
        Result m = new Result();
        m.setCode(enumExceptionType.getErrorCode());
        m.setStatus(-1);
        m.setData(data);
        m.setMsg(enumExceptionType.getCodeMessage());

        return m;
    }

    public static Result result(EnumExceptionType enumExceptionType) {
        return result(enumExceptionType,null);
    }
}