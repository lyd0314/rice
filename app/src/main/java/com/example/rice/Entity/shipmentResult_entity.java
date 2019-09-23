package com.example.rice.Entity;
/**(13)出货结果上报*/
public class shipmentResult_entity {
    private String macno;   //设备编号,设备初始化就产生的
    private String type;    //类型，安卓返回
    private String orderId; //订单编号，安卓返回

    public shipmentResult_entity(String macno, String type, String orderId) {
        this.macno = macno;
        this.type = type;
        this.orderId = orderId;
    }

    public String getMacno() {
        return macno;
    }

    public void setMacno(String macno) {
        this.macno = macno;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
