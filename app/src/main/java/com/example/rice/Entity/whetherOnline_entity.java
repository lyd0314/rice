package com.example.rice.Entity;
/**
 * (2)查询是否在线(后台--->协议)
 * ①接收到后台的请求以后,查询设备是否在线*/

public class whetherOnline_entity {

    private String inform;      //返回参数,由协议返回给后台

    public whetherOnline_entity(String inform) {
        this.inform = inform;
    }

    public String getInform() {
        return inform;
    }

    public void setInform(String inform) {
        this.inform = inform;
    }
}
