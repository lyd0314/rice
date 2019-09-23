package com.example.rice.Entity;
/**
 * (1)检测设备是否在线,是否启用
 * ①由安卓发起查询操作,后台接收到了请求以后向协议请求,协议会返回当前设备是否在线.*/
public class isOnline_entity {

    private String isOnline;    //是否在线，由协议返回给后台,后台返回给安卓
    private int normal;         //机器是否启用，由后台设定

    public isOnline_entity(String isOnline, int normal) {
        this.isOnline = isOnline;
        this.normal = normal;
    }

    public String getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(String isOnline) {
        this.isOnline = isOnline;
    }

    public int getNormal() {
        return normal;
    }

    public void setNormal(int normal) {
        this.normal = normal;
    }
}
