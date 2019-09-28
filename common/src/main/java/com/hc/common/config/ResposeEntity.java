package com.hc.common.config;

import com.hc.common.pojo.User;

import java.util.List;

public class ResposeEntity {
    private String status;
    private String msg;
    private Object data;

    public ResposeEntity(String status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ResposeEntity(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public static ResposeEntity success(Object data){
        return new ResposeEntity("200","成功", data);
    }
    public static ResposeEntity fail(String msg){
        return new ResposeEntity("888", msg);
    }
}
