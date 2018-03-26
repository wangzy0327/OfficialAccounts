package com.weixin.pojo;

public class Ticket {
    // JS-SDK 接口访问凭证
    private String jsapi_ticket;
    // 凭证有效期，单位：秒
    private int expiresIn;

    public String getJsapi_ticket() {
        return jsapi_ticket;
    }

    public void setJsapi_ticket(String jsapi_ticket) {
        this.jsapi_ticket = jsapi_ticket;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
}
