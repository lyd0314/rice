package com.example.rice.Entity;
/**(11)出货操作(后台-->协议)*/
public class shipment_entity {

    private String inform;          //返回参数

    public shipment_entity(String inform) {
        this.inform = inform;
    }

    public String getInform() {
        return inform;
    }

    public void setInform(String inform) {
        this.inform = inform;
    }
}
