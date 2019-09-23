package com.example.rice.Entity;
/**(15)出米请求*/
public class riceShipment_entity {
    private int message;    //执行是否成功,后台执行成功或者成功,如果成功则返回1.
    private String inform;  //转换积分通知,当米不足以此次出货的时候,会把没有出到的米,转换为积分给到用户
    private String weight;  //出米重量,单位:克

    public riceShipment_entity(int message, String inform, String weight) {
        this.message = message;
        this.inform = inform;
        this.weight = weight;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public String getInform() {
        return inform;
    }

    public void setInform(String inform) {
        this.inform = inform;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
